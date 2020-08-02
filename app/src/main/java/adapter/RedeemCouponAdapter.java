package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demohunegroup.R;

import java.util.ArrayList;

import item.ItemAdvertisement;
import item.ItemRedeemPoint;
import iterface.ItemRedeemPointInterface;

public class RedeemCouponAdapter extends RecyclerView.Adapter<RedeemCouponAdapter.NewViewHolder> {
    public RedeemCouponAdapter(ArrayList<ItemRedeemPoint> mData) {
        this.mData = mData;
    }

    private ArrayList<ItemRedeemPoint> mData;

    public void setItemRedeemPointInterface(ItemRedeemPointInterface itemRedeemPointInterface) {
        this.itemRedeemPointInterface = itemRedeemPointInterface;
    }

    private ItemRedeemPointInterface itemRedeemPointInterface;

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_redeemcoupon,parent,false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        ItemRedeemPoint itemRedeemPoint = mData.get(position);
        holder.binData(itemRedeemPoint);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvTime;
        TextView tvPoint;
        ImageView ivItem;
        TextView tvBuy;
        LinearLayout linearLayout;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.fragRedeem_tvTitle);
            tvPoint = itemView.findViewById(R.id.fragRedeem_tvPoint);
            tvTime = itemView.findViewById(R.id.fragRedeem_tvTime);
            ivItem = itemView.findViewById(R.id.fragRedeem_ivItem);
            tvBuy = itemView.findViewById(R.id.fragRedeem_tvBuy);
            linearLayout = itemView.findViewById(R.id.fragRedeem_linearLayoutTotal);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemRedeemPointInterface != null) itemRedeemPointInterface.itemClicked(getAdapterPosition());
                }
            });
        }

        public void binData(ItemRedeemPoint item){
            tvTitle.setText(item.getTvTitle());
            tvTime.setText(item.getTvTime());
            tvPoint.setText(item.getTvPoint());
            ivItem.setImageResource(item.getIvItem());
        }

    }

    public ArrayList<ItemRedeemPoint> getData() {
        return mData;
    }
}
