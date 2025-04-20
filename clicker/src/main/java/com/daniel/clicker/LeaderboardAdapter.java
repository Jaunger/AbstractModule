package com.daniel.clicker;

import android.view.View;
import android.widget.TextView;

import com.daniel.abstractmodule.BaseRecyclerAdapter;

import java.util.List;

public class LeaderboardAdapter extends BaseRecyclerAdapter<LeaderboardEntry> {
    public LeaderboardAdapter(List<LeaderboardEntry> items) {
        super(items, R.layout.item_leaderboard_entry);
    }

    @Override
    protected void bindView(View view, LeaderboardEntry item) {
        TextView name = view.findViewById(R.id.entry_name);
        TextView score = view.findViewById(R.id.entry_score);
        name.setText(item.name);
        score.setText("Score: " + item.score);
    }
}
