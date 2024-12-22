package com.fathan.lastassigment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fathan.lastassigment.R;
import com.fathan.lastassigment.models.AboutDetail;

import java.util.List;

public class AboutDetailAdapter extends RecyclerView.Adapter<AboutDetailAdapter.ViewHolder> {

    private final List<AboutDetail> details;

    public AboutDetailAdapter(List<AboutDetail> details) {
        this.details = details;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_about, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AboutDetail detail = details.get(position);
        holder.labelTextView.setText(detail.getLabel());
        holder.valueTextView.setText(detail.getValue());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView labelTextView, valueTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            labelTextView = itemView.findViewById(R.id.label);
            valueTextView = itemView.findViewById(R.id.value);
        }
    }
}
