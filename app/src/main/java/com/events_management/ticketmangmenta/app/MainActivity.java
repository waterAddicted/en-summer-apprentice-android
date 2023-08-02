package com.events_management.ticketmangmenta.app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] item = {"Dashboard", "Orders"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item);

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
                    btnAddEvent.setVisibility(View.VISIBLE);
                    searchBar.setVisibility(View.VISIBLE);
                } else {
                    // Altfel, faceți invizibile butonul și bara de căutare
                    Button btnAddEvent = findViewById(R.id.btn_add_event);
                    EditText searchBar = findViewById(R.id.search_bar);
                    btnAddEvent.setVisibility(View.GONE);
                    searchBar.setVisibility(View.GONE);
                }
            }
        });

    }
}