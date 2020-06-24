package com.diego.onboardingapp.Onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.diego.onboardingapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextRecognitionFragment extends Fragment {
    private TextView textNext, textBack;
    private ViewPager viewPager;
    private View view;

    public TextRecognitionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_text_recognition, container, false);
        initializeInflater(inflater, container);
        initializeComponents();
        eventClicPrevkNext();

        return view;
    }

    public void initializeInflater(LayoutInflater inflater, ViewGroup container){
        view = inflater.inflate(R.layout.fragment_text_recognition, container, false);
    }

    public void initializeComponents(){
        viewPager = getActivity().findViewById(R.id.viewPagerContainer);
        textNext = view.findViewById(R.id.textNextIns);
        textBack = view.findViewById(R.id.textPrevIns);
    }

    public void eventClicPrevkNext(){
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        textNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
//                Toast.makeText(getActivity(), "Ingresando App!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}