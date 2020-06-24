package com.diego.reciclerview.Adapter;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.diego.reciclerview.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private RelativeLayout rlContainer;
    private CircleImageView circleImage, circlePlay, circlePause, circleStop;
    private TextView tvImage, tvPlay;
    private Button btnListen;

    public RelativeLayout getRlContainer() {
        return rlContainer;
    }

    public CircleImageView getCircleImage() {
        return circleImage;
    }

    public CircleImageView getCirclePlay(){
        return circlePlay;
    }
    public CircleImageView getCirclePause(){
        return circlePause;
    }
    public CircleImageView getCircleStop(){
        return circleStop;
    }

    public TextView getTvImage() {
        return tvImage;
    }

    public TextView getTvPlay() {
        return tvPlay;
    }

    public Button getBtnListen(){
        return btnListen;
    }

    public  ViewHolder(View itemView) {
        super(itemView);
        initializeComponents(itemView);
    }

    private void initializeComponents(View itemView){
        rlContainer = itemView.findViewById(R.id.rlListItem);
        circleImage = itemView.findViewById(R.id.circleImageViewItem);

        circlePlay = itemView.findViewById(R.id.circleIVplay);
        circlePause = itemView.findViewById(R.id.circleIVpause);
        circleStop = itemView.findViewById(R.id.circleIVStop);

        tvPlay = itemView.findViewById(R.id.tvPlay);

        tvImage = itemView.findViewById(R.id.tvImage);
        btnListen = itemView.findViewById(R.id.buttonListen);
    }

}