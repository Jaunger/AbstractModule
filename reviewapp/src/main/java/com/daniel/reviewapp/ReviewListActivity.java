package com.daniel.reviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.abstractmodule.BaseRecyclerAdapter;
import com.daniel.abstractmodule.SecondAbstractActivity;

import java.util.List;

public class ReviewListActivity extends SecondAbstractActivity {
    private List<String> reviews;

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
    protected String getHeaderText() {
        return "Your Reviews";
    }

    @Override
    protected RecyclerView.Adapter<?> getRecyclerAdapter() {
      return new ReviewAdapter(ReviewStorage.getReviews());
    }

    @Override
    protected void setup() {
        Button back = findViewById(R.id.back_button);

        back.setOnClickListener(v -> finish());
    }
}
