package com.daniel.abstractmodule;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;


public abstract class AbstractActivity extends AppCompatActivity {

    protected TextView headerText;
    protected Button primaryButton, secondaryButton;

    @LayoutRes
    protected abstract int getLayoutResId();
    protected abstract void setup();

    protected int getHeaderTextViewId() { return 0; }
    protected int getPrimaryButtonId() { return 0; }
    protected int getSecondaryButtonId() { return 0; }

    protected String getHeaderText() { return ""; }
    protected String getPrimaryButtonText() { return ""; }
    protected String getSecondaryButtonText() { return ""; }

    protected void onPrimaryButtonClick() {}
    protected void onSecondaryButtonClick() {}

    protected void setBackground(int resId, AppCompatImageView imageView) {
        Glide.with(this).load(resId).centerCrop().into(imageView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        int headerId = getHeaderTextViewId();
        if (headerId != 0) {
            headerText = findViewById(headerId);
            headerText.setText(getHeaderText());
        }

        int primaryId = getPrimaryButtonId();
        if (primaryId != 0) {
            primaryButton = findViewById(primaryId);
            primaryButton.setText(getPrimaryButtonText());
            primaryButton.setOnClickListener(v -> onPrimaryButtonClick());
        }

        int secondaryId = getSecondaryButtonId();
        if (secondaryId != 0) {
            secondaryButton = findViewById(secondaryId);
            secondaryButton.setText(getSecondaryButtonText());
            secondaryButton.setOnClickListener(v -> onSecondaryButtonClick());
        }

        setup();
    }
}