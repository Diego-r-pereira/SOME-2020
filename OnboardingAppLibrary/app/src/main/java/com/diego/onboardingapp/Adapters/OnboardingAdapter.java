package com.diego.onboardingapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.diego.onboardingapp.Onboarding.FaceDetectionFragment;
import com.diego.onboardingapp.Onboarding.TextRecognitionFragment;
import com.diego.onboardingapp.Onboarding.WelcomeFragment;

public class OnboardingAdapter extends FragmentPagerAdapter {


    public OnboardingAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new WelcomeFragment();
            case 1:
                return new FaceDetectionFragment();
            case 2:
                return new TextRecognitionFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
