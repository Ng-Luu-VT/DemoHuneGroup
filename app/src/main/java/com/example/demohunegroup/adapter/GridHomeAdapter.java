package com.example.demohunegroup.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demohunegroup.R;
import com.example.demohunegroup.item.ItemGridHome;
import com.example.demohunegroup.item.ItemRedeemPoint;
import com.example.demohunegroup.iterface.ItemGridHomeInterface;

import java.util.ArrayList;

public class GridHomeAdapter extends RecyclerView.Adapter<GridHomeAdapter.NewViewHolder> {
    public void setItemGridHomeInterface(ItemGridHomeInterface itemGridHomeInterface) {
        this.itemGridHomeInterface = itemGridHomeInterface;
    }

    private ItemGridHomeInterface itemGridHomeInterface;

    public GridHomeAdapter(ArrayList<ItemGridHome> mData) {
        this.mData = mData;
    }

    private ArrayList<ItemGridHome> mData;

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_home,parent,false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        ItemGridHome itemGridHome = mData.get(position);
        holder.binData(itemGridHome);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        ImageView ivItem;
        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.fragHome_tvItemGrid);
            ivItem = itemView.findViewById(R.id.fragHome_ivItemGrid);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemGridHomeInterface != null) itemGridHomeInterface.itemClicked(getAdapterPosition());
                }
            });
        }

        public void binData(ItemGridHome itemGridHome){
            tvItem.setText(itemGridHome.getTvItem());
            ivItem.setImageResource(itemGridHome.getIvItem());
        }
    }

    public ArrayList<ItemGridHome> getData() {
        return mData;
    }
}
