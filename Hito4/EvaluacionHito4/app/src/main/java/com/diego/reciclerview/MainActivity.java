package com.diego.reciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.diego.reciclerview.Adapter.RVAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RVAdapter rvAdapter, rvPlaylist;
    private ArrayList<String> imgNames = new ArrayList<>();
//    private ArrayList<Integer> imagesID = new ArrayList<>();
    private ArrayList<String> imagesID = new ArrayList<>();
    private ArrayList<String> musicsID = new ArrayList<>();
    private ArrayList<String> playMusic = new ArrayList<>();

    private final String imgURL = "V4OgA4O,yB3d2qH,9jMbaX2,rYndmdq,sypYnSP,HBeK1ot,YCqbt8r,eLk31XX," +
            "4ZHp7FO,XzffKgy,DJabk5C";
    private final String imgName = "Playlist 1,Playlist 2,Playlist 3,Playlist 4,Playlist 5," +
            "Playlist 6,Playlist 7,Playlist 8,Playlist 9,Playlist 10,Playlist 11";

    private final String musics = "Music 1,Music 2,Music 3,Music 4,Music 5,Music 6,Music 7,Music 8," +
            "Music 9,Music 10,Music 11,Music 12";
//    private final String playURL = "asdfasdf,asdfasdf,asdfasd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIMagebitMaps();
        initRecyclerView();
    }

    public void initIMagebitMaps(){
        imagesID.addAll(Arrays.asList(imgURL.split(",")));
        imgNames.addAll(Arrays.asList(imgName.split(",")));
        musicsID.addAll(Arrays.asList(musics.split(",")));
//        playMusic.addAll(Arrays.asList(playURL.split(",")));
    }

    public void initRecyclerView(){
        recyclerView = findViewById(R.id.rvContainer);
        rvAdapter = new RVAdapter(this, imgNames, imagesID);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        rvPlaylist = new RVAdapter(this, musicsID, imagesID);
    }
}
