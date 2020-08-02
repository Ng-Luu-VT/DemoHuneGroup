package com.example.demohunegroup.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.demohunegroup.fragment.AccountFragment;
import com.example.demohunegroup.fragment.ChatFragment;
import com.example.demohunegroup.fragment.HomePageFragment;
import com.example.demohunegroup.fragment.NotificationFragment;
import com.example.demohunegroup.fragment.RewardPointsFragment;

public class MenuPagerAdapter extends FragmentStateAdapter {
    public MenuPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomePageFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new RewardPointsFragment();
            case 3:
                return new NotificationFragment();
            default:
                return new AccountFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
