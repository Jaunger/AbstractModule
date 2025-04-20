package com.daniel.abstractmodule;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public abstract  class SecondAbstractActivity extends AppCompatActivity {
    protected TextView headerText;
    protected RecyclerView recyclerView;

    @LayoutRes
    protected abstract int getLayoutResId();
    protected abstract int getHeaderTextViewId();
    protected abstract int getRecyclerViewId();

    protected abstract String getHeaderText();
    protected abstract RecyclerView.Adapter<?> getRecyclerAdapter();
    protected void setup() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        headerText = findViewById(getHeaderTextViewId());
        recyclerView = findViewById(getRecyclerViewId());

        headerText.setText(getHeaderText());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(getRecyclerAdapter());

        setup();
    }
}