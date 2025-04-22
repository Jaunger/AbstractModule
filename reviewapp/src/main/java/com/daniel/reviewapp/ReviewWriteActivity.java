package com.daniel.reviewapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daniel.abstractmodule.AbstractActivity;

public class ReviewWriteActivity extends AbstractActivity {

    private TextView companyNameText;
    private EditText reviewInput;
    private Button submitNextButton,finishButton;

    private final String[] companies = {"Startup A", "Startup B", "Startup C"};
    private int currentIndex = 0;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_review_write;
    }

    @Override
    protected void setup() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        initViews();

        updateCompany();

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

        finishButton.setOnClickListener(v -> startActivity(new Intent(this, ReviewListActivity.class)));
    }

    private void initViews() {
        imageView = findViewById(R.id.img_background);
        companyNameText = findViewById(R.id.txt_company_name);
        reviewInput = findViewById(R.id.edit_review);
        submitNextButton = findViewById(R.id.btn_submit_next);
        finishButton = findViewById(R.id.btn_finish);
    }

    private void updateCompany() {
        companyNameText.setText(companies[currentIndex]);
    }
}