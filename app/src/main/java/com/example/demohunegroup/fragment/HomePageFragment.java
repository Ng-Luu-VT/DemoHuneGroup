package com.example.demohunegroup.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demohunegroup.R;
import com.example.demohunegroup.activity.MainActivity;

import java.util.ArrayList;

import com.example.demohunegroup.adapter.AdvertisementAdapter;
import com.example.demohunegroup.item.ItemAdvertisement;
import com.example.demohunegroup.iterface.ItemAdvertisementInterface;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends Fragment implements ItemAdvertisementInterface {
    private RecyclerView rvAd;
    private AdvertisementAdapter mAdvertisementAdapter;

    public HomePageFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        init(view);
        binEvent();
        return view;
    }

    private void binEvent() {
        mAdvertisementAdapter.setItemAdvertisementInterface(this);
    }

    private void init(View view) {
        rvAd = view.findViewById(R.id.actMenu_fragHome_rvAd);
        mAdvertisementAdapter = new AdvertisementAdapter(genData());
        rvAd.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        rvAd.setHasFixedSize(true);
        rvAd.setAdapter(mAdvertisementAdapter);
    }

    private ArrayList<ItemAdvertisement> genData() {
        ArrayList<ItemAdvertisement> listItem = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            ItemAdvertisement itemAdvertisement = new ItemAdvertisement();
            itemAdvertisement.setIvAdvertisement(R.drawable.ic_home);
            listItem.add(itemAdvertisement);
        }
        return listItem;
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}