package com.weightwatchers.ww_exercise_01.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weightwatchers.ww_exercise_01.R;
import com.weightwatchers.ww_exercise_01.model.WW_DataModel;

import java.util.List;

public class WW_Adapter extends RecyclerView.Adapter<WW_Holder> {
    List<WW_DataModel> ww_dataModelList;

    public WW_Adapter(List<WW_DataModel> ww_dataModelList) {
        this.ww_dataModelList = ww_dataModelList;
    }

    @NonNull
    @Override
    public WW_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .itemview_layout, parent, false);
        return new WW_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WW_Holder holder, int position) {

        holder.onBind(ww_dataModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return ww_dataModelList.size();
    }
}
