package com.events_management.ticketmangmenta.app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] item = {"Dashboard", "Orders"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    private List<ItemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item);

        RecyclerView recyclerView = findViewById(R.id.recycle_cards_view);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        // În metoda onCreate a activității
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_options, android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();

                // Verificați dacă opțiunea selectată este "Dashboard"
                if (selectedOption.equals("Dashboard")) {
                    // Dacă da, faceți vizibile butonul și bara de căutare
                    Button btnAddEvent = findViewById(R.id.btn_add_event);
                    EditText searchBar = findViewById(R.id.search_bar);
                    RecyclerView recyclerView = findViewById(R.id.recycle_cards_view);
                    btnAddEvent.setVisibility(View.VISIBLE);
                    searchBar.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);

                    // Simulați adăugarea datelor în lista pentru RecyclerView
                    itemList = new ArrayList<>();
                    itemList.add(new ItemModel("Card 1", "Description for Card 1", R.drawable.eventz)); // Example card
                    itemList.add(new ItemModel("Card 2", "Description for Card 2", R.drawable.eventz)); // Example card
                    itemList.add(new ItemModel("Card 3", "Description for Card 3", R.drawable.eventz)); // Example card
                    itemList.add(new ItemModel("Card 4", "Description for Card 4", R.drawable.eventz)); // Example card
                    itemList.add(new ItemModel("Card 5", "Description for Card 5", R.drawable.eventz)); // Example card
                    itemList.add(new ItemModel("Card 6", "Description for Card 6", R.drawable.eventz)); // Example card

                    // Inițializați și setați adapterul pentru RecyclerView
                    YourCustomAdapter adapter = new YourCustomAdapter(itemList);
                    recyclerView.setAdapter(adapter);

                    // Setați GridLayoutManager pentru a aranja cardurile în două coloane
                    GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
                    recyclerView.setLayoutManager(layoutManager);
                } else {
                    // Altfel, faceți invizibile butonul și bara de căutare
                    Button btnAddEvent = findViewById(R.id.btn_add_event);
                    EditText searchBar = findViewById(R.id.search_bar);
                    RecyclerView recyclerView = findViewById(R.id.recycle_cards_view);
                    btnAddEvent.setVisibility(View.GONE);
                    searchBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
        });
    }
}
