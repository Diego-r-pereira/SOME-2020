package com.diego.reciclerview.Adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.diego.reciclerview.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private RelativeLayout rlContainer;

    public RelativeLayout getRlContainer() {
        return rlContainer;
    }

    public CircleImageView getCircleImage() {
        return circleImage;
    }

    public TextView getTvImage() {
        return tvImage;
    }

    private CircleImageView circleImage;
    private TextView tvImage;

    public  ViewHolder(View itemView) {
        super(itemView);
        initializeComponents(itemView);
    }

    private void initializeComponents(View itemView){
        rlContainer = itemView.findViewById(R.id.rlListItem);
        circleImage = itemView.findViewById(R.id.circleImageViewItem);
        tvImage = itemView.findViewById(R.id.tvImage);
    }



}
