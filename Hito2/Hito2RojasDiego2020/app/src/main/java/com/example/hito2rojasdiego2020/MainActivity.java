package com.example.hito2rojasdiego2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ciudad, etSetConfirm, etSetSospe, etBusqueda;
    private EditText etCbbaConf, etCbbaSos, etSczConf;
    private EditText etSczSos, etOrConf, etOrSos;
    private Button btSetValue, btBusqueda;
    private String sConf, sSOs, city ;
    private String n1CB, n2SCZ, n3OR, option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializarVariable();
    }

    public void initializarVariable(){

        btSetValue = findViewById(R.id.btSetValue);
        btSetValue.setOnClickListener(this);
        btBusqueda = findViewById(R.id.btBusqueda);
        btBusqueda.setOnClickListener(this);

        etSetConfirm = findViewById(R.id.etSetConfirm);
        etSetSospe = findViewById(R.id.etSetSospe);
        ciudad = findViewById(R.id.etSetCiudad);
        etBusqueda = findViewById(R.id.etBusqueda);


        etCbbaConf = findViewById(R.id.etCbbaConf);
        etSczConf = findViewById(R.id.etSczConf);
        etOrConf = findViewById(R.id.etOrConf);

        etCbbaSos = findViewById(R.id.etCbbaSos);
        etSczSos = findViewById(R.id.etSczSos);
        etOrSos = findViewById(R.id.etOrSos);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSetValue:
                setValues();
            break;
            case R.id.btBusqueda:
                calcular();
            break;
        }
    }

    public void setValues(){

        sConf = etSetConfirm.getText().toString();
        sSOs = etSetSospe.getText().toString();
        city = ciudad.getText().toString();

        if (city.equals("cbba")){
            etCbbaConf.setText(sConf);
            etCbbaSos.setText(sSOs);
        } if (city.equals("or")){
            etOrConf.setText(sConf);
            etOrSos.setText(sSOs);
        } if (city.equals("scz")){
            etSczConf.setText(sConf);
            etSczSos.setText(sSOs);
        }
    }

    public void calcular(){
        int n1, n2, n3, mayor;
        option = etBusqueda.getText().toString();

        if (option.equals("conf")){
            n1CB = etCbbaConf.getText().toString();
            n2SCZ = etSczConf.getText().toString();
            n3OR = etOrConf.getText().toString();
        }

        if (option.equals("sosp")){
            n1CB = etCbbaSos.getText().toString();
            n2SCZ = etSczSos.getText().toString();
            n3OR = etOrSos.getText().toString();
        }

        n1 = Integer.parseInt(n1CB);
        n2 = Integer.parseInt(n2SCZ);
        n3 = Integer.parseInt(n3OR);

        if (n1 > n2) {
            if (n1 > n3) {
                mayor = n1;
            } else {
                mayor = n3;
            }
        } else {
            if (n2 > n3) {
                mayor = n2;
            } else {
                mayor = n3;
            }
        }

        Toast.makeText(this, "Mayor numero:" + mayor, Toast.LENGTH_LONG).show();
    }
}
