package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et1, et2;
    private TextView tv1, tvRespuesta;
    private Button btSumar, btRestar, btMulti, btDiv, btClean, btCalcu2;
    private String n1, n2;
    private Integer respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariable();
    }

    public void initializeVariable(){
        et1 = findViewById(R.id.etNumber1);
        et2 = findViewById(R.id.etNumber2);

        tv1 = findViewById(R.id.textView1);
        tv1.setText("CALCULADORA BASICA");
        tvRespuesta = findViewById(R.id.textViewRespuesta);

        btSumar = findViewById(R.id.btSumar);
        btSumar.setOnClickListener(this);

        btRestar = findViewById(R.id.btRestar);
        btRestar.setOnClickListener(this);

        btMulti = findViewById(R.id.btMulti);
        btMulti.setOnClickListener(this);

        btDiv = findViewById(R.id.btDiv);
        btDiv.setOnClickListener(this);

        btClean = findViewById(R.id.btClean);
        btClean.setOnClickListener(this);

        btCalcu2 = findViewById(R.id.btCal2);
        btCalcu2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSumar:
                n1 = et1.getText().toString();
                n2 = et2.getText().toString();

                respuesta = Integer.parseInt(n1) + Integer.parseInt(n2);
                tvRespuesta.setText("" + respuesta);
                break; //logica
            case R.id.btRestar:
                n1 = et1.getText().toString();
                n2 = et2.getText().toString();

                respuesta = Integer.parseInt(n1) - Integer.parseInt(n2);
                tvRespuesta.setText("" + respuesta);
                break;
            case R.id.btMulti:
                n1 = et1.getText().toString();
                n2 = et2.getText().toString();

                respuesta = Integer.parseInt(n1) * Integer.parseInt(n2);
                tvRespuesta.setText("" + respuesta);
                break;
            case R.id.btDiv:
                n1 = et1.getText().toString();
                n2 = et2.getText().toString();

                respuesta = Integer.parseInt(n1) / Integer.parseInt(n2);
                tvRespuesta.setText("" + respuesta);
                break;
            case R.id.btClean:
                et1.setText("");
                et2.setText("");
                tvRespuesta.setText("");
                Toast.makeText(this.getApplication(), "Click Button Clear", Toast.LENGTH_LONG).show();
                break;
            case R.id.btCal2:
                Intent intent = new Intent(this, ScientficCalculator.class);
                startActivity(intent);
                break;
        }
    }
}
