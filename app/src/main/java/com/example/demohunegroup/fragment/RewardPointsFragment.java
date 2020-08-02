package com.example.demohunegroup.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demohunegroup.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import com.example.demohunegroup.adapter.RewardPointAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RewardPointsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RewardPointsFragment extends Fragment {
    public RewardPointsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reward_points, container, false);
        init(view);
        binEvent();
        return view;
    }

    private void init(View view) {
        ViewPager2 viewPager2 = view.findViewById(R.id.actMenu_fragReward_viewPager2);
        viewPager2.setAdapter(new RewardPointAdapter(this));
        final TabLayout tabLayout = view.findViewById(R.id.actMenu_fragReward_tabLayout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Đổi coupon");
                        tab.setIcon(R.drawable.ic_home);
                        break;
                    case 1:
                        tab.setText("Coupon của tôi");
                        tab.setIcon(R.drawable.ic_chat);
                        break;
                    case 2:
                        tab.setText("Điểm thưởng");
                        tab.setIcon(R.drawable.ic_gift);
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                BadgeDrawable badgeDrawable = Objects.requireNonNull(tabLayout.getTabAt(position)).getOrCreateBadge();
//                badgeDrawable.setVisible(false);
//            }
//        });
    }

    private void binEvent() {

    }
}