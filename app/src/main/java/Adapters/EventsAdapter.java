package Adapters;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.events_management.ticketmangmenta.app.R;

import Models.DTOs.EventsDtO;

import java.util.ArrayList;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private List<EventsDtO> eventList;
    private List<EventsDtO> filteredEventList; // Add a new list to hold the filtered items

    public EventsAdapter(List<EventsDtO> eventList) {
        this.eventList = eventList;
        this.filteredEventList = new ArrayList<>(eventList); // Initialize filteredEventList with the full list initially
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventsDtO currentItem = eventList.get(position);
        holder.textView.setText(currentItem.getEventName());
        holder.descriptionTextView.setText(currentItem.getEventDescription());
        holder.imageView.setImageResource(currentItem.getImageName());

        // Setează valorile pentru câmpurile adăugate în EventsDtO
        holder.ticketCategoryTextView.setText(currentItem.getTicketCategory());
        holder.numberOfTicketsTextView.setText(String.valueOf(currentItem.getNumberOfTickets()));
    }
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView descriptionTextView;
        public ImageView imageView;
        public TextView ticketCategoryTextView; // Adaugă TextView pentru categoria biletului
        public TextView numberOfTicketsTextView; // Adaugă TextView pentru numărul de bilete

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView); // Replace with the actual TextView ID in item_card_view.xml
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView); // Replace with the actual TextView ID for description
            imageView = itemView.findViewById(R.id.imageView); // Replace with the actual ImageView ID for image
            ticketCategoryTextView = itemView.findViewById(R.id.ticketCategoryTextView); // Replace with the actual TextView ID for ticket category
            numberOfTicketsTextView = itemView.findViewById(R.id.numberOfTicketsTextView); // Replace with the actual TextView ID for number of tickets
        }
    }

    public void filterList(String query) {
        filteredEventList.clear();

        if (TextUtils.isEmpty(query)) {
            filteredEventList.addAll(eventList); // If the query is empty, show all items
        } else {
            query = query.toLowerCase().trim();
            for (EventsDtO item : eventList) {
                if (item.getEventName().toLowerCase().contains(query)) {
                    filteredEventList.add(item); // Add items that match the search query to the filtered list
                }
            }
        }
        notifyDataSetChanged(); // Notify the adapter that the dataset has changed
    }
}
