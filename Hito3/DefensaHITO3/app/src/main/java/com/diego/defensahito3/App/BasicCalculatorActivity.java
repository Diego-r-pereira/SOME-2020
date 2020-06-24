package com.diego.defensahito3.App;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.diego.defensahito3.R;

public class BasicCalculatorActivity extends AppCompatActivity {

    private TextView tvShowUser, tvShowApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);

        initializeVariable();
    }

    public void initializeVariable(){
        tvShowUser = findViewById(R.id.tvShowUserBasic);
        tvShowApp = findViewById(R.id.tvShowAppBasic);

        String username = getIntent().getStringExtra("USERNAME");
        String getApp = getIntent().getStringExtra("SELECTAPP");
        String msg = "Bienvenido: " + username;
        String msg2 = "Esta es la aplicacion " + getApp;
        tvShowUser.setText(msg);
        tvShowApp.setText(msg2);
    }
}
