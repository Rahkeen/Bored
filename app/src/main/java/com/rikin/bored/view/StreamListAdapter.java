package com.rikin.bored.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rikin.bored.R;
import com.rikin.bored.com.rikin.bored.model.repository.StreamData;

import java.util.List;

public class StreamListAdapter extends RecyclerView.Adapter<StreamItemViewHolder> {

    private List<StreamData> data;

    @Override
    public StreamItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stream_item, parent, false);

        return new StreamItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StreamItemViewHolder holder, int position) {
        holder.streamTitle.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<StreamData> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
