package com.mukeshkpdeveloper.scrolltopositionexample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private final ArrayList<LocationMasterDatum> data;
    private Activity mContext;
    private ScrollPositionListener scrollPositionListener;

    public RvAdapter(Activity mContext, ArrayList<LocationMasterDatum> data, ScrollPositionListener scrollPositionListener) {
        this.data = data;
        this.mContext = mContext;
        this.scrollPositionListener = scrollPositionListener;
    }

    @Override
    public RvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(RvAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LocationMasterDatum dummyParentDataItem = data.get(position);
        holder.tv_location_name.setText(dummyParentDataItem.getLocationName());

        holder.tv_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollPositionListener.scrollPositionListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView tv_location_name, tv_count;

        MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            tv_location_name = itemView.findViewById(R.id.tv_location_name);
            tv_count = itemView.findViewById(R.id.tv_count);
        }
    }
}