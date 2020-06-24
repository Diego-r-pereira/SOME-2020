package com.diego.defensahito3.Onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.diego.defensahito3.App.BasicCalculatorActivity;
import com.diego.defensahito3.App.CustomCalculatorActivity;
import com.diego.defensahito3.App.ScientificCalculatorActivity;
import com.diego.defensahito3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectAppFragment extends Fragment implements View.OnClickListener{

    private EditText etSelectApp, etUsername;
    private Button buttonIngresar;
    private Button btDescBasic, btDescScientific, btDescCustom;
    private Button btSelectBasic, btSelectScientific, btSelectCustom;
    private ViewPager viewPager;
    private View view;

    public SelectAppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_select_app, container, false);

        initializeInflater(inflater, container);
        initializeComponents();

        return view;
    }

    public void initializeInflater(LayoutInflater inflater, ViewGroup container){
        view = inflater.inflate(R.layout.fragment_select_app, container, false);
    }

    public void initializeComponents(){
        viewPager = getActivity().findViewById(R.id.viewPagerContainer);

        etSelectApp = view.findViewById(R.id.etSelectApp);
        etUsername = view.findViewById(R.id.etUsername);

        btDescScientific = view.findViewById(R.id.buttonDescriptionScientific);
        btDescScientific.setOnClickListener(this);
        btDescCustom = view.findViewById(R.id.buttonDescriptionCustom);
        btDescCustom.setOnClickListener(this);
        btDescBasic = view.findViewById(R.id.buttonDescriptionBasica);
        btDescBasic.setOnClickListener(this);

        btSelectBasic = view.findViewById(R.id.buttonSelectBasica);
        btSelectBasic.setOnClickListener(this);
        btSelectScientific = view.findViewById(R.id.buttonSelectScientific);
        btSelectScientific.setOnClickListener(this);
        btSelectCustom = view.findViewById(R.id.buttonSelectCustom);
        btSelectCustom.setOnClickListener(this);

        buttonIngresar = view.findViewById(R.id.buttonIngresar);
        buttonIngresar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonDescriptionBasica:
                Toast.makeText(getActivity(), "This is the Basic Calculator with the main operation like plus, minus, divide, etc.",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDescriptionScientific:
                Toast.makeText(getActivity(), "This is the Scientific Calculator that makes Scientific stuff or whatever I'm sleeping",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDescriptionCustom:
                Toast.makeText(getActivity(), "This is the Custom Calculator, the most tough question in the quiz, thanks for that by the way",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSelectBasica:
                etSelectApp.setText("Basic");
                break;
            case R.id.buttonSelectScientific:
                etSelectApp.setText("Scientific");
                break;
            case R.id.buttonSelectCustom:
                etSelectApp.setText("Custom");
                break;
            case R.id.buttonIngresar:

                String selectApp = etSelectApp.getText().toString();
                String username = etUsername.getText().toString();

                if (!checkValues(selectApp, username)){
                    Toast.makeText(getActivity(), "Please select an APP and fill your NAME",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (selectApp.equals("Basic")){
                        Intent intent = new Intent(getActivity(), BasicCalculatorActivity.class);
                        intent.putExtra("SELECTAPP", selectApp);
                        intent.putExtra("USERNAME", username);
                        startActivity(intent);
                    }
                    if (selectApp.equals("Scientific")){
                        Intent intent = new Intent(getActivity(), ScientificCalculatorActivity.class);
                        intent.putExtra("SELECTAPP", selectApp);
                        intent.putExtra("USERNAME", username);
                        startActivity(intent);
                    }
                    if (selectApp.equals("Custom")){
                        Intent intent = new Intent(getActivity(), CustomCalculatorActivity.class);
                        intent.putExtra("SELECTAPP", selectApp);
                        intent.putExtra("USERNAME", username);
                        startActivity(intent);
                    getActivity().finish();
                    }
                }
                break;
        }
    }

    public  boolean checkValues (String select, String username){
        boolean isValid = true;

        if (select.equals("") || username.equals("")){
            isValid = false;
        }
        return isValid;
    }
}
