package com.example.demohunegroup.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demohunegroup.R;
import com.example.demohunegroup.activity.MainActivity;

import java.util.ArrayList;

import com.example.demohunegroup.adapter.RedeemCouponAdapter;
import com.example.demohunegroup.item.ItemRedeemPoint;
import com.example.demohunegroup.iterface.ItemButtonBuyInterface;
import com.example.demohunegroup.iterface.ItemRedeemPointInterface;

public class RedeemCouponFragment extends Fragment implements ItemRedeemPointInterface, ItemButtonBuyInterface {
    private RecyclerView rvRedeem;
    private RedeemCouponAdapter mRedeemCouponAdapter;
    private TextView tvBuy;


    public RedeemCouponFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        binEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_redeem_coupon, container, false);
        return view;

    }


    private void init(View view) {
        rvRedeem = view.findViewById(R.id.fragRedeem_rvRedeem);
        mRedeemCouponAdapter = new RedeemCouponAdapter(genData());
        rvRedeem.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvRedeem.setHasFixedSize(true);
        rvRedeem.setAdapter(mRedeemCouponAdapter);
    }

    private ArrayList<ItemRedeemPoint> genData() {
        ArrayList<ItemRedeemPoint> listItem = new ArrayList<>();
        for (int i =0;i<10;i++){
            ItemRedeemPoint itemRedeemPoint = new ItemRedeemPoint();
            itemRedeemPoint.setIvItem(R.drawable.ic_gift);
            itemRedeemPoint.setTvTitle("aaaaaaaaaaaaaaaaaaaaaaaaaaaâ");
            itemRedeemPoint.setTvTime("31-12-2020");;
            itemRedeemPoint.setTvPoint("1500 Point");
            listItem.add(itemRedeemPoint);
        }
        return listItem;
    }

    private void binEvent() {
        mRedeemCouponAdapter.setItemRedeemPointInterface(this);
        mRedeemCouponAdapter.setItemButtonBuyInterface(this);
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void itemButtonClicked(View view, int position) {
        if (view!=null){
            Dialog dialog = new Dialog(view.getContext());
            dialog.setContentView(R.layout.dialog_redeemcoupon);
            dialog.show();
        }


    }
}