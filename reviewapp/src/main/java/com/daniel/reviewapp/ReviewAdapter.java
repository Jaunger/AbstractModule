package com.daniel.reviewapp;

import android.view.View;
import android.widget.TextView;

import com.daniel.abstractmodule.BaseRecyclerAdapter;

import java.util.List;

public class ReviewAdapter extends BaseRecyclerAdapter<String> {
    public ReviewAdapter(List<String> items) {
        super(items, R.layout.item_review);
    }

    @Override
    protected void bindView(View view, String item) {
        TextView name = view.findViewById(R.id.tv_review);
        name.setText(item);
    }
}
