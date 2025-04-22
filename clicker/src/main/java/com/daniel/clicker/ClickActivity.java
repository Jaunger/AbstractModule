package com.daniel.clicker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.core.content.ContextCompat;

import com.daniel.abstractmodule.AbstractActivity;

public class ClickActivity extends AbstractActivity {

    private int clickCount = 0;
    private EditText nameInput;
    private TextView counterText;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_click;
    }

    @Override
    protected void setup() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView = findViewById(R.id.img_background);
        nameInput = findViewById(R.id.input_name);
        counterText = findViewById(R.id.counter_view);
        Button clickButton = findViewById(R.id.btn_click);
        Button finishButton = findViewById(R.id.btn_finish);
        counterText.setTextColor(ContextCompat.getColor(this, R.color.white));
        nameInput.setTextColor(ContextCompat.getColor(this, R.color.white));
        nameInput.setHintTextColor(ContextCompat.getColor(this, R.color.white));
        setBackground(R.drawable.img_background, imageView);
        clickButton.setOnClickListener(v -> {
            clickCount++;
            counterText.setText("Clicks: " + clickCount);
        });

        finishButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }

            LeaderboardStore.addEntry(name, clickCount);
            nameInput.setText("");
            clickCount = 0;
            counterText.setText("Clicks: " + clickCount);
            Intent intent = new Intent(this, LeaderboardActivity.class);
            startActivity(intent);
        });

    }
}