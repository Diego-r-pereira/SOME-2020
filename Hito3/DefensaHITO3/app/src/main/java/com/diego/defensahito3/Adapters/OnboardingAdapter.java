package com.diego.defensahito3.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.diego.defensahito3.Onboarding.SelectAppFragment;
import com.diego.defensahito3.Onboarding.StudentFragment;
import com.diego.defensahito3.Onboarding.WelcomeFragment;

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
                return new StudentFragment();
            case 2:
                return new SelectAppFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
