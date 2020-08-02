package com.example.demohunegroup.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.demohunegroup.fragment.MyCouponFragment;
import com.example.demohunegroup.fragment.PointsFragment;
import com.example.demohunegroup.fragment.RedeemCouponFragment;
import com.example.demohunegroup.fragment.RewardPointsFragment;

public class RewardPointAdapter extends FragmentStateAdapter {
    public RewardPointAdapter(@NonNull RewardPointsFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new RedeemCouponFragment();
            case 1:
                return new MyCouponFragment();
            default:
                return new PointsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
