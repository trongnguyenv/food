package com.project.food.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.project.food.models.Settings;

public class HomeViewPagerAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 3;
    private final Settings userSettings;

    public HomeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Settings userSettings) {
        super(fragmentActivity);
        this.userSettings = userSettings;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new Fragment();
        switch (position){
            case 0:
//                fragment = MealTypeFragment.newInstance(userSettings);
                break;
            case 1:
//                fragment = SearchFragment.newInstance(userSettings);
                break;
            case 2:
//                fragment = new SavedRecipesFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
