package com.diego.onboardingapp.Onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.diego.onboardingapp.App.ScientificCalculator;
import com.diego.onboardingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private TextView textBack;
    private EditText etLogin, etPassword;
    private Button buttonLogin;
    private ViewPager viewPager;
    private View view;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false);
        initializeInflater(inflater, container);
        initializeComponents();


        return view;
    }

    public void initializeInflater(LayoutInflater inflater, ViewGroup container){
        view = inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void initializeComponents(){
        viewPager = getActivity().findViewById(R.id.viewPagerContainer);

        etLogin = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);

        textBack = view.findViewById(R.id.textPrevLogin);
        textBack.setOnClickListener(this);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textPrevLogin:
                viewPager.setCurrentItem(0);
                break;
            case R.id.buttonLogin:

                String username = etLogin.getText().toString();
                String password = etPassword.getText().toString();

                if (!checkValues(username, password)){
                    Toast.makeText(getActivity(), "Please add user and password",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getActivity(), ScientificCalculator.class);
                    intent.putExtra("USERNAME", username);
                    intent.putExtra("PASSWORD", password);
                    startActivity(intent);
                    getActivity().finish();
                }

                break;
        }
    }

    public  boolean checkValues (String username, String password){
        boolean isValid = true;

        if (username.equals("") || password.equals("")){
            isValid = false;
        }
         return isValid;
    }
}