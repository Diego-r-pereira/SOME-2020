package com.diego.splashscreentome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llLogo, llTextWelcome, calculadora;

    private Button btSumar;

    private EditText text1, text2;

    private TextView respuesta;

    private Animation animTextWelcome;
    private Animation animTextCalculadora;
    private Animation animButon;

    private String v1, v2;
    private Integer res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAnimation();
        initializeComponents();
        createAnimationForLogo();
    }

    private void initializeComponents(){
        llLogo = (LinearLayout) findViewById(R.id.LinearLayoutLogo);
        llTextWelcome = (LinearLayout) findViewById(R.id.linerLayoutTextSplash);
        calculadora = (LinearLayout) findViewById(R.id.linerLayoutCalculator);

        btSumar = (Button) findViewById(R.id.btSum);
        btSumar.setOnClickListener(this);

        text1 = (EditText) findViewById(R.id.etNumber1);
        text2 = (EditText) findViewById(R.id.etNumber2);

        respuesta = (TextView) findViewById(R.id.tvResult);
    }

    public void initializeAnimation() {
        animTextWelcome = AnimationUtils.loadAnimation(this, R.anim.animation_for_text_welcome);
        animTextCalculadora = AnimationUtils.loadAnimation(this, R.anim.animation_fro_calculator);
        animButon = AnimationUtils.loadAnimation(this, R.anim.animation_for_button);
    }

    private void createAnimationForLogo(){
        llLogo.animate().translationY(-900).setDuration(1200).setStartDelay(300);
        llTextWelcome.startAnimation(animTextWelcome);

        calculadora.setVisibility(View.VISIBLE);
        calculadora.startAnimation(animTextCalculadora);

        btSumar.startAnimation(animButon);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSum:
                v1 = text1.getText().toString();
                v2 = text2.getText().toString();

                res = Integer.parseInt(v1) + Integer.parseInt(v2);
                respuesta.setText(""+res);
            break;
        }

    }
}