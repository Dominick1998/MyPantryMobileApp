package com.example.mypantry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypantry.model.GroceryItem;

import java.util.List;

public class GroceryAdapterListBasic extends RecyclerView.Adapter<GroceryAdapterListBasic.ViewHolder> {

    private Context context;
    private List<GroceryItem> items;

    public GroceryAdapterListBasic(Context context, List<GroceryItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GroceryItem currentItem = items.get(position);


        holder.groceryItemName.setText(currentItem.getGroceryName());
        holder.itemSKU.setText(currentItem.getGrocerySKU());
        holder.itemQuantity.setText(currentItem.getGroceryQuantity());

        holder.itemRemoval.setOnClickListener(view -> {
            items.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView groceryItemName;
        TextView itemSKU;
        TextView itemQuantity;
        Button itemRemoval;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            groceryItemName = itemView.findViewById(R.id.groceryItemName);
            itemSKU = itemView.findViewById(R.id.itemSKU);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemRemoval = itemView.findViewById(R.id.itemRemoval);
        }
    }
}
