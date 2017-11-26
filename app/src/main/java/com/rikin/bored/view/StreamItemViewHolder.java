package com.rikin.bored.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rikin.bored.R;

import butterknife.BindView;
import butterknife.ButterKnife;

class StreamItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.stream_title)
    TextView streamTitle;

    StreamItemViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
