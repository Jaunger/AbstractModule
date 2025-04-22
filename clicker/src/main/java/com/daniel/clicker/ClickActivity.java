package com.daniel.clicker;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
        nameInput = findViewById(R.id.input_name);
        counterText = findViewById(R.id.counter_view);
        Button clickButton = findViewById(R.id.btn_click);
        Button finishButton = findViewById(R.id.btn_finish);

        clickButton.setOnClickListener(v -> {
            clickCount++;
            counterText.setText("Clicks: " + clickCount);
        });

        setBackground(R.drawable.img_background, findViewById(R.id.img_background));
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