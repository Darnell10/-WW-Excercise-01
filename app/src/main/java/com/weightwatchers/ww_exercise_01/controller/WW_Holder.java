package com.weightwatchers.ww_exercise_01.controller;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weightwatchers.ww_exercise_01.R;
import com.weightwatchers.ww_exercise_01.model.WW_DataModel;

public class WW_Holder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    private TextView titleView;


    public WW_Holder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.ww_image);

        titleView = itemView.findViewById(R.id.ww_title);


    }

    public void onBind(WW_DataModel wwDataModel) {

        titleView.setText(wwDataModel.getTitle());


        imageView.setOnClickListener(v -> {
            Snackbar
                    .make(imageView, R.string.snack_message, Snackbar.LENGTH_LONG).show();
        });


        String imagePath = "https://www.weightwatchers.com/" + wwDataModel.getImage();

        Picasso.with(itemView.getContext())
                .load(imagePath)
                .placeholder(R.drawable.ww)
                .error(R.drawable.ww)
                .into(imageView);


    }
}
