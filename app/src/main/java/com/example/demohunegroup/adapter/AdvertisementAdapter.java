package com.example.demohunegroup.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demohunegroup.R;

import java.util.ArrayList;

import com.example.demohunegroup.item.ItemAdvertisement;
import com.example.demohunegroup.iterface.ItemAdvertisementInterface;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.NewViewHolder> {

    //khai báo
    private ArrayList<ItemAdvertisement> mData;
    private ItemAdvertisementInterface itemAdvertisementInterface;

    public AdvertisementAdapter(ArrayList<ItemAdvertisement> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_advertisement,parent,false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        ItemAdvertisement item = mData.get(position);
        holder.binData(item);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAd;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAd = itemView.findViewById(R.id.fragHome_ivAd);
            ivAd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemAdvertisementInterface != null) itemAdvertisementInterface.itemClicked(getAdapterPosition());
                }
            });
        }
        public void binData(ItemAdvertisement item) {
            ivAd.setImageResource(item.getIvAdvertisement());
        }
    }

    public void setItemAdvertisementInterface(ItemAdvertisementInterface itemAdvertisementInterface) {
        this.itemAdvertisementInterface = itemAdvertisementInterface;
    }
    public ArrayList<ItemAdvertisement> getData() {
        return mData;
    }
}
