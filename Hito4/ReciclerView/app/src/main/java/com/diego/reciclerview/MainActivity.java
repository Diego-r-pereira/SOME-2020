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
    private RVAdapter rvAdapter;
    private ArrayList<String> imgNames = new ArrayList<>();
//    private ArrayList<Integer> imagesID = new ArrayList<>();
    private ArrayList<String> imagesID = new ArrayList<>();

    private final String imgURL = "VlGGqmG,DWX6eGn,EpmxiT3,V9Pcw5j,HkEJ5K4,DaXpXsG,0IRvKpq,XUZw40U,mjR9oaO";
    private final String imgName = "WhatsApp,Twitter,Youtube,SnapChat,Instagram,Google+,Pinterest,Linkdn,Facebook";

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

        /*imagesID.add(R.drawable.sp);  imgNames.add("Spotify");
        imagesID.add(R.drawable.fb);  imgNames.add("Facebook");
        imagesID.add(R.drawable.duo); imgNames.add("Duolingo");
        imagesID.add(R.drawable.ms);  imgNames.add("Messenger");
        imagesID.add(R.drawable.sn);  imgNames.add("SnapChat");
        imagesID.add(R.drawable.tw);  imgNames.add("Twitter");*/
    }

    public void initRecyclerView(){
        recyclerView = findViewById(R.id.rvContainer);
        rvAdapter = new RVAdapter(this, imgNames, imagesID);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
