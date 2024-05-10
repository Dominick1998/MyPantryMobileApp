package com.example.mypantry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypantry.model.GroceryItem;
import com.example.mypantry.model.PantryItem;

import java.util.List;

public class PantryAdapterListBasic extends RecyclerView.Adapter<PantryAdapterListBasic.ViewHolder> {

    private Context mContext;
    private List<PantryItem> mItems;

    public PantryAdapterListBasic(Context context, List<PantryItem> items) {
        mContext = context;
        mItems = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pantry_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem currentItem = mItems.get(position);

        holder.itemName.setText(currentItem.getPantryName());
        holder.itemQuantity.setText(currentItem.getPantryQuantity());
        holder.itemExpDate.setText(currentItem.getPantryExpDate());
        holder.itemLocation.setText(currentItem.getPantryLocation());
        holder.itemNote.setText(currentItem.getPantryNotes());

        holder.itemRemoval.setOnClickListener(view -> {
            mItems.remove(position);
            notifyDataSetChanged();
        });

        holder.groceryAdd.setOnClickListener(view -> {
            GroceryItem groceryItem = new GroceryItem(currentItem.getPantryName(), currentItem.getPantryQuantity(), currentItem.getPantrySKU());
            DataHolder.getInstance().getGroceryList().add(groceryItem);
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemQuantity;
        TextView itemExpDate;
        TextView itemLocation;
        TextView itemNote;
        Button itemRemoval;

        ImageButton groceryAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.pantryItemName);
            itemLocation = itemView.findViewById(R.id.itemLocation);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemExpDate = itemView.findViewById(R.id.itemExpDate);
            itemNote = itemView.findViewById(R.id.itemNotes);
            itemRemoval = itemView.findViewById(R.id.itemRemoval);
            groceryAdd = itemView.findViewById(R.id.groceryAdd);
        }
    }
}
