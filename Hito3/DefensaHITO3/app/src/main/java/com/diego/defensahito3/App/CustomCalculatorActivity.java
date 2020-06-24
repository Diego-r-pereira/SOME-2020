package com.diego.defensahito3.App;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.diego.defensahito3.R;

public class CustomCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView tvShowUser, tvShowApp;
    public Button limpiar, tangente, resta, igual, suma, poten, poten3, btSumN, btSumFibo, factorial, CloseApp;
    public double numeros[]= new double[8], resultado;
    public Button cero, uno, dos, tres, cuatro;
    public Boolean shiftEnabled=false,decimal=false,parentesis=false,rest=false,sum=false,div=false,multi=false,pot=false,consec=false, raiz=false,tange=false,cos=false,seno=false,pocen=false, facto=false;
    public TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_calculator);

        initializeVariable();
    }

    public void initializeVariable(){
        tvShowUser = findViewById(R.id.tvShowUserCustom);
        tvShowApp = findViewById(R.id.tvShowAppCustom);

        String username = getIntent().getStringExtra("USERNAME");
        String getApp = getIntent().getStringExtra("SELECTAPP");
        String msg = "Bienvenido: " + username;
        String msg2 = "App: " + getApp;
        tvShowUser.setText(msg);
        tvShowApp.setText(msg2);

        display=findViewById(R.id.input);
        limpiar= findViewById(R.id.btClean);
        limpiar.setOnClickListener(this);

        Button multi= (Button) findViewById(R.id.btMulti);
        Button div=(Button) findViewById(R.id.btDiv);
        resta= findViewById(R.id.btRestar);
        igual= findViewById(R.id.btEqual);
        factorial= findViewById(R.id.btFactorial);
        suma= findViewById(R.id.btSumar);
        poten= findViewById(R.id.btAlCuadrado);
        poten3= findViewById(R.id.btAlCubo);
        Button shift=(Button) findViewById(R.id.btShift) ;
        btSumN= findViewById(R.id.btSumatoriaN);
        btSumFibo = findViewById(R.id.btFactorial);
        CloseApp=findViewById(R.id.btClose);

        multi.setOnClickListener(this);
        div.setOnClickListener(this);
        resta.setOnClickListener(this);
        igual.setOnClickListener(this);
        factorial.setOnClickListener(this);
        suma.setOnClickListener(this);
        poten.setOnClickListener(this);
        poten3.setOnClickListener(this);
        shift.setOnClickListener(this);
        btSumN.setOnClickListener(this);
        btSumFibo.setOnClickListener(this);
        CloseApp.setOnClickListener(this);

        cero= findViewById(R.id.bt0);
        uno=findViewById(R.id.bt1);
        dos= findViewById(R.id.bt2);
        tres= findViewById(R.id.bt3);
        cuatro= findViewById(R.id.bt4);

        cero.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int seleccion=v.getId();
        String a=display.getText().toString();
        try{
            switch (seleccion) {
                case R.id.btShift:
                    shiftEnabled=!shiftEnabled;
                    if(!shiftEnabled) {
                        poten.setText("X2");
                    }else
                    {
                        poten.setText("X3");
                    }
                    if(!shiftEnabled) {
                        poten3.setText("X3");
                    }else
                    {
                        poten3.setText("XY");
                    }
                    if(!shiftEnabled) {
                        btSumN.setText("Ʃn");
                    }else
                    {
                        btSumN.setText("Ʃnxy");
                    }

                    if(!shiftEnabled) {
                        factorial.setText("N!");
                    }else
                    {
                        factorial.setText("ƩFibo");
                    }

                    break;
                case R.id.btClose:
                    Intent salida=new Intent( Intent.ACTION_MAIN); //Llamando a la activity principal
                    finish();
                    break;
                case R.id.bt0:
                    display.setText(a + "0");
                    break;
                case R.id.bt1:
                    display.setText(a + "1");
                    break;
                case R.id.bt2:
                    display.setText(a + "2");
                    break;
                case R.id.bt3:
                    display.setText(a + "3");
                    break;
                case R.id.bt4:
                    display.setText(a + "4");
                    break;
                case R.id.btRestar:
                    rest = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.btSumar:
                    sum = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.btMulti:
                    multi = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.btDiv:
                    div = true;
                    numeros[0] = Double.parseDouble(a);
                    display.setText("");
                    decimal = false;
                    parentesis = false;
                    break;
                case R.id.btSumatoriaN:
                    consec=true;
                    numeros[0] = Double.parseDouble(a);
                    resultado=0;
                    //numeros[1]=Double.parseDouble(a);
                    for(int i=0;i<=numeros[0];i++){
                        resultado=resultado+i;
                    }
                    display.setText(String.valueOf(resultado));
                    decimal = false;
                    parentesis = false;

                    break;
                case R.id.btEqual:
                    numeros[1] = Double.parseDouble(a);
                    if (sum == true) {
                        for (int i = 0; i < 8; i++) {
                            resultado = numeros[0] + numeros[1];
                        }
                        display.setText(String.valueOf(resultado));

                    } else if (rest == true) {
                        for (int i = 0; i < 8; i++) {
                            resultado = numeros[0] - numeros[1];
                        }
                        display.setText(String.valueOf(resultado));
                    } else if (multi == true) {
                        for (int i = 0; i < 8; i++) {
                            resultado = numeros[0] * numeros[1];
                        }
                        display.setText(String.valueOf(resultado));

                    } else if (div == true) {
                        if(numeros[0]==0){
                            Toast.makeText(this,"Math ERROR", Toast.LENGTH_LONG).show();
                        }else
                            for (int i = 0; i < 8; i++) {
                                resultado = numeros[0] / numeros[1];
                            }
                        display.setText(String.valueOf(resultado));
                    }
                    break;
                case R.id.btClean:
                    display.setText("");
                    decimal=false;
                    parentesis=false;
                    break;
                case R.id.btAlCuadrado:
                    pot = true;
                    if(shiftEnabled){
                        numeros[0] = Double.parseDouble(a);
                        //numeros[1]=Double.parseDouble(a);
                        resultado = Math.pow(numeros[0], 3);
                        display.setText(String.valueOf(resultado));
                        decimal = false;
                        parentesis = false;
                    }else{
                        numeros[0] = Double.parseDouble(a);
                        //numeros[1]=Double.parseDouble(a);
                        resultado = Math.pow(numeros[0], 2);
                        display.setText(String.valueOf(resultado));
                        decimal = false;
                        parentesis = false;
                    }

                    break;
                case R.id.btAlCubo:
                    pot = true;
                    numeros[0] = Double.parseDouble(a);
                    //numeros[1]=Double.parseDouble(a);
                    resultado = Math.pow(numeros[0], 3);
                    display.setText(String.valueOf(resultado));
                    decimal = false;
                    parentesis = false;
                    break;
                case  R.id.btFactorial:
                    facto=true;
                    if(shiftEnabled){
                        numeros[0] = Double.parseDouble(a);
                        int t1=0;
                        int t2=1;
                        int c=0;
                        resultado=1;
                        for(int i = 1;i<=numeros[0] - 2 ;++i){
                            c = t1 + t2;
                            t1 = t2;
                            t2 = c;
                            resultado = resultado + t2;
                        }
                        display.setText(String.valueOf(resultado));
                    }else {
                        numeros[0]=Double.parseDouble(a);
                        resultado=1;
                        for(int i=2;i<=numeros[0];i++){
                            resultado=resultado*i;
                        }
                        display.setText(String.valueOf(resultado));
                    }

                    break;
            }
        }catch (Exception e){
            display.setText("SintaxError");
        }
    }
}
