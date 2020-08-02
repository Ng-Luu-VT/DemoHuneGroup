package com.example.demohunegroup.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;

import com.example.demohunegroup.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import adapter.AdvertisementAdapter;
import adapter.MenuPagerAdapter;
import item.ItemAdvertisement;
import iterface.ItemAdvertisementInterface;

public class MenuActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        viewpager();


    }



    private void viewpager() {
        ViewPager2 viewPager2 = findViewById(R.id.actMenu_viewPager2);
        viewPager2.setAdapter(new MenuPagerAdapter(this));

        final TabLayout tabLayout = findViewById(R.id.actMenu_tabLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Trang chủ");
                        tab.setIcon(R.drawable.ic_home);
                        break;
                    case 1:
                        tab.setText("Chat");
                        tab.setIcon(R.drawable.ic_chat);
                        break;
                    case 2:
                        tab.setText("Điểm thưởng");
                        tab.setIcon(R.drawable.ic_gift);
                        break;
                    case 3:
                        tab.setText("Thông báo");
                        tab.setIcon(R.drawable.ic_notifications);
                        break;
                    case 4:
                        tab.setText("Tài khoản");
                        tab.setIcon(R.drawable.ic_account);
                        break;
                }
            }
        }
        );
        tabLayoutMediator.attach();

//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
//                badgeDrawable.setVisible(false);
//            }
//        });
    }


}