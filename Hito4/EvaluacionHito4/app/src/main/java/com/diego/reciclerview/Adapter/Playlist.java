package com.diego.reciclerview.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.diego.reciclerview.R;

import java.util.ArrayList;

public class Playlist extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "Playlist";

    private Context context;
    private ArrayList<String> musics;
    private ArrayList<String> play;
//    private ArrayList<String> imagesURL;

    public Playlist(@NonNull Context context, ArrayList<String> musicName, ArrayList<String> playIcon){
        this.context = context;
        this.musics = musicName;
        this.play = playIcon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_playlist, viewGroup, false);
        ViewHolder vHolder = new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide
                .with(context)
                .asBitmap()
                .load("https://i.imgur.com/59AoTWq.png")
                .into(holder.getCirclePlay());
        Glide
                .with(context)
                .asBitmap()
                .load("https://i.imgur.com/2Nat0RQ.png")
                .into(holder.getCirclePause());
        Glide
                .with(context)
                .asBitmap()
                .load("https://i.imgur.com/LJjdlQe.png")
                .into(holder.getCircleStop());
        holder.getTvPlay().setText(musics.get(position));
        holder.getCirclePlay().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Play " + musics.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }
}
