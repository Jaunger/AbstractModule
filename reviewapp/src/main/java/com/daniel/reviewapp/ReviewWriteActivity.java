package com.daniel.reviewapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.daniel.abstractmodule.AbstractActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewWriteActivity extends AbstractActivity {

    private TextView companyNameText;
    private EditText reviewInput;
    private Button submitNextButton, finishButton;

    private final String[] companies = {"Startup A", "Startup B", "Startup C"};
    private final ArrayList<String> reviews = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_review_write;
    }

    @Override
    protected void setup() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imageView = findViewById(R.id.img_background);
        companyNameText = findViewById(R.id.txt_company_name);
        reviewInput = findViewById(R.id.edit_review);
        submitNextButton = findViewById(R.id.btn_submit_next);
        finishButton = findViewById(R.id.btn_finish);

        updateCompany();
        setBackground(R.drawable.img_back, imageView);
        submitNextButton.setOnClickListener(v -> {
            String review = reviewInput.getText().toString().trim();
            if (!review.isEmpty()) {
                String company = companies[currentIndex];
                ReviewStorage.addReview(company + ": " + review);
                reviewInput.setText("");
                currentIndex++;

                if (currentIndex < companies.length) {
                    updateCompany();
                } else {
                    submitNextButton.setEnabled(false);
                    submitNextButton.setText("No more companies");
                }
            }
        });

        finishButton.setOnClickListener(v -> {
            startActivity(new Intent(this, ReviewListActivity.class));
        });
    }

    private void updateCompany() {
        companyNameText.setText(companies[currentIndex]);
    }
}