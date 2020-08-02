package adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fragment.AccountFragment;
import fragment.ChatFragment;
import fragment.HomePageFragment;
import fragment.MyCouponFragment;
import fragment.NotificationFragment;
import fragment.PointsFragment;
import fragment.RedeemCouponFragment;
import fragment.RewardPointsFragment;

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
