package com.daniel.abstractmodule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder> {
    private final List<T> items;
    private final int layoutId;

    public BaseRecyclerAdapter(List<T> items, @LayoutRes int layoutId) {
        this.items = items;
        this.layoutId = layoutId;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bindView(holder.itemView, items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract void bindView(View view, T item);
}
