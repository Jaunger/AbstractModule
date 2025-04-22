package com.daniel.clicker;

import android.view.View;
import android.widget.TextView;

import com.daniel.abstractmodule.BaseRecyclerAdapter;

import java.util.List;

public class LeaderboardAdapter extends BaseRecyclerAdapter<LeaderboardEntry> {
    public LeaderboardAdapter(List<LeaderboardEntry> items) {
        super(sortByScoreDescending(items), R.layout.item_leaderboard_entry);
    }

    private static List<LeaderboardEntry> sortByScoreDescending(List<LeaderboardEntry> items) {
        items.sort((a, b) -> Integer.compare(b.score, a.score)); // Descending order
        return items;
    }

    @Override
    protected void bindView(View view, LeaderboardEntry item) {
        TextView name = view.findViewById(R.id.entry_name);
        TextView score = view.findViewById(R.id.entry_score);
        name.setText(item.name);
        score.setText("Score: " + item.score);
    }
}
