# 📦 Abstract Module Demo

This project showcases a shared `abstractmodule` used across multiple Android apps to promote reusability and consistency in UI structure and behavior.

---

## 🧰 Abstract Activities (From `:abstractmodule`)

The abstract module provides two flexible base activity classes and a reusable RecyclerView adapter. These form the **foundation for building consistent UI-driven Android apps** with minimal code duplication.

---

### 🧱 `AbstractActivity`

A base activity ideal for screens with a **header, background image, and up to two configurable buttons**. Used for forms, input screens, or interactive activities.

#### 🔧 What it provides:

- ✅ `setBackground(resId, imageView)`  
  Utility method to load a background image using Glide.
- ✅ Built-in support for:
  - **Header text**
  - **Primary and secondary buttons** (fully customizable labels + actions)
  - Reusable setup pattern for child classes

#### 🧩 Overridable Hooks:

```java
protected abstract int getLayoutResId();
protected abstract void setup();

protected int getHeaderTextViewId();         // Optional
protected int getPrimaryButtonId();          // Optional
protected int getSecondaryButtonId();        // Optional

protected String getHeaderText();            // Optional
protected String getPrimaryButtonText();     // Optional
protected String getSecondaryButtonText();   // Optional

protected void onPrimaryButtonClick();       // Optional
protected void onSecondaryButtonClick();     // Optional
```

---

### 🧾 `SecondAbstractActivity`

A base activity designed for **displaying a header and a list** (via `RecyclerView`). It abstracts away common RecyclerView boilerplate and is perfect for summary or list pages.

#### 🔧 What it provides:

- ✅ Header text at the top
- ✅ A fully set up `RecyclerView` with layout manager and adapter
- ✅ Minimal code required from child activities

#### 🧩 Required Overrides:

```java
protected abstract int getLayoutResId();
protected abstract int getHeaderTextViewId();
protected abstract int getRecyclerViewId();

protected abstract String getHeaderText();
protected abstract RecyclerView.Adapter<?> getRecyclerAdapter();
protected void setup(); // Optional extra setup
```

---

### 🌀 `BaseRecyclerAdapter<T>`

A reusable generic RecyclerView adapter for displaying lists of any type.

#### 🔧 What it provides:

- ✅ Inflates a custom layout for each item
- ✅ Binds any data type generically

#### 🧩 Usage Pattern:

Subclass it and implement `bindView()` to define how each item should be displayed.

```java
public class ReviewAdapter extends BaseRecyclerAdapter<Review> {
    public ReviewAdapter(List<Review> reviews) {
        super(reviews, R.layout.item_review);
    }

    @Override
    protected void bindView(View view, Review review) {
        TextView text = view.findViewById(R.id.text_review);
        text.setText(review.getText());
    }
}
```

---

## 📱 Included Apps

### 🎮 App One: Clicker Game

- Main screen extends `AbstractActivity`
  - Name input and click counter
  - "Click" button increases counter
  - "Finish Game" saves score and shows leaderboard
- Leaderboard screen extends `SecondAbstractActivity`
  - Displays all scores from `LeaderboardStore`
  - "Back" button to return

### 📝 App Two: Startup Reviewer

- First screen extends `AbstractActivity`
  - Shows startup pitch
  - Input field for writing a review
  - "Submit & Next" cycles through companies
  - "Finish Reviewing" navigates to the list
- Second screen extends `SecondAbstractActivity`
  - Displays all submitted reviews
  - "Back" button to return

---

## 🔀 Flow

### Clicker Game
1. Enter name
2. Tap "Click Me!" to increase score
3. Tap "Finish Game" to view leaderboard

### Review App
1. Read pitch
2. Write a review and tap "Submit & Next"
3. Tap "Finish Reviewing" to see all reviews

---

## 🛠 Setup

Both apps include the shared abstract module. Add this to the `build.gradle` of each app:

```gradle
implementation project(":abstractmodule")
```

---

## 📂 Project Structure

```
/abstractmodule
│
├── AbstractActivity.java
├── SecondAbstractActivity.java
└── BaseRecyclerAdapter.java

/clicker
│
├── ClickActivity.java
├── LeaderboardActivity.java
├── LeaderboardAdapter.java
├── LeaderboardEntry.java
├── LeaderboardStore.java
├── res/layout/activity_click.xml
├── res/layout/activity_leaderboard.xml
├── res/layout/item_entry.xml
└── res/drawable/img_background.png

/reviewapp
│
├── ReviewWriteActivity.java
├── ReviewListActivity.java
├── ReviewAdapter.java
├── ReviewStorage.java
├── res/layout/activity_review_write.xml
├── res/layout/activity_review_list.xml
├── res/layout/item_review.xml
└── res/drawable/img_background.png


```
---

## Screenshots and Videos

---

## 📐 Shared Design Goals

- All screens share a consistent structure by subclassing `AbstractActivity` or `SecondAbstractActivity`
- All background images and buttons are consistently placed via abstract layouts
- Code reusability is maximized via abstract base classes
  
---

## 💡 How to Extend

- Create a new app module and reuse `AbstractActivity` or `SecondAbstractActivity`
- For any list-based screen, use `BaseRecyclerAdapter<T>` to define custom item rendering
- Override lifecycle methods and UI logic via `setup()`
- Add more abstract features (e.g. theming, toolbar) as needed
  
---

## 📜 License

MIT License © Daniel  
Use freely, modify widely. Attribution appreciated!

