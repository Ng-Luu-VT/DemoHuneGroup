package adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fragment.AccountFragment;
import fragment.ChatFragment;
import fragment.HomePageFragment;
import fragment.NotificationFragment;
import fragment.RewardPointsFragment;

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
