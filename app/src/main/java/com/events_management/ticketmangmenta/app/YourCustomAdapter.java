package com.events_management.ticketmangmenta.app;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.events_management.ticketmangmenta.app.ItemModel;

import java.util.List;

public class YourCustomAdapter extends RecyclerView.Adapter<YourCustomAdapter.ViewHolder> {

    private List<ItemModel> itemList;

    public YourCustomAdapter(List<ItemModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel currentItem = itemList.get(position);
        holder.textView.setText(currentItem.getName());
        // Puteți afișa descrierea și imaginea în carduri folosindu-vă de descrierea și numele imaginii din currentItem.
        holder.descriptionTextView.setText(currentItem.getDescription());
        holder.imageView.setImageResource(currentItem.getImageName()); // Use the resource ID directly

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView descriptionTextView;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView); // Replace with the actual TextView ID in item_card_view.xml
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView); // Replace with the actual TextView ID for description
            imageView = itemView.findViewById(R.id.imageView); // Replace with the actual ImageView ID for image
        }
    }
}
