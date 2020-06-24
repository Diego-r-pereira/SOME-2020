package com.diego.defensahito3.App;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.diego.defensahito3.R;

public class ScientificCalculatorActivity extends AppCompatActivity {

    private TextView tvShowUser, tvShowApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);

        initializeVariable();
    }

    public void initializeVariable() {
        tvShowUser = findViewById(R.id.tvShowUserSci);
        tvShowApp = findViewById(R.id.tvShowAppSci);

        String username = getIntent().getStringExtra("USERNAME");
        String getApp = getIntent().getStringExtra("SELECTAPP");
        String msg = "Bienvenido: " + username;
        String msg2 = "Esta es la aplicacion " + getApp;
        tvShowUser.setText(msg);
        tvShowApp.setText(msg2);
    }
}
