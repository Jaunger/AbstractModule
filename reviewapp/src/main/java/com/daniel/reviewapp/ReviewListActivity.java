package com.daniel.reviewapp;

import android.content.pm.ActivityInfo;

import androidx.recyclerview.widget.RecyclerView;

import com.daniel.abstractmodule.SecondAbstractActivity;

public class ReviewListActivity extends SecondAbstractActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_review_list;
    }

    @Override
    protected int getHeaderTextViewId() {
        return R.id.header_text;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.recycler_view;
    }

    @Override
    protected int getBackButtonId() {
        return R.id.back_button;
    }

    @Override
    protected String getHeaderText() {
        return "Your Reviews";
    }

    @Override
    protected RecyclerView.Adapter<?> getRecyclerAdapter() {
      return new ReviewAdapter(ReviewStorage.getReviews());
    }

    @Override
    protected void setup() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
}
