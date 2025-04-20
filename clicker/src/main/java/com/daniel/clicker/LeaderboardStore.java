package com.daniel.clicker;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardStore {
    private static final List<LeaderboardEntry> entries = new ArrayList<>();

    public static void addEntry(String name, int score) {
        entries.add(new LeaderboardEntry(name, score));
    }

    public static List<LeaderboardEntry> getEntries() {
        return new ArrayList<>(entries);
    }
}
