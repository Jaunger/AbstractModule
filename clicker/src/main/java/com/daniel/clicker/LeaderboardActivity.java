package com.daniel.clicker;


import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.daniel.abstractmodule.SecondAbstractActivity;

public class LeaderboardActivity extends SecondAbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_leaderboard;
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
        return "Leaderboard";
    }

    @Override
    protected RecyclerView.Adapter<?> getRecyclerAdapter() {
        return new LeaderboardAdapter(LeaderboardStore.getEntries());
    }


}