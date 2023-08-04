package com.events_management.ticketmangmenta.app;

import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Adapters.EventsAdapter;
import Models.DTOs.EventsDtO;
import Service.IEventService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String[] item = {"Dashboard", "Orders"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    private List<EventsDtO> eventList;
    IEventService eventService;
    private EventsAdapter adapter;
    RecyclerView recyclerView;
    Button btnAddEvent;
    EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item);

        recyclerView = findViewById(R.id.recycle_cards_view);
        autoCompleteTextView.setAdapter(adapterItems);

        btnAddEvent = findViewById(R.id.btn_add_event);
        searchEditText = findViewById(R.id.search_bar);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();

                // Verificați dacă opțiunea selectată este "Dashboard"
                if (selectedOption.equals("Dashboard")) {
                    // Dacă da, faceți vizibile butonul și bara de căutare
                    btnAddEvent.setVisibility(View.VISIBLE);
                    searchEditText.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);

                    //Simulați adăugarea datelor în lista pentru RecyclerView
                    eventList = new ArrayList<>();
                    eventList.add(new EventsDtO("Card 1", "Description for Card 1", R.drawable.eventz,"VIP",3)); // Example card
                    eventList.add(new EventsDtO("Card 2", "Description for Card 2", R.drawable.event,"STANDARD",4)); // Example card
                    eventList.add(new EventsDtO("Card 3", "Description for Card 3", R.drawable.eventz,"STANDARD",4)); // Example card
                    eventList.add(new EventsDtO("Card 4", "Description for Card 4", R.drawable.eventz,"STANDARD",5)); // Example card
                    eventList.add(new EventsDtO("Card 5", "Description for Card 5", R.drawable.eventz,"VIP",3)); // Example card
                    eventList.add(new EventsDtO("Card 6", "Description for Card 6", R.drawable.eventz,"VIP",6)); // Example card

                    // Inițializați și setați adapterul pentru RecyclerView
                    adapter = new EventsAdapter(eventList);
                    recyclerView.setAdapter(adapter);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:80")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    eventService = retrofit.create(IEventService.class);

                    eventList = new ArrayList<>();
                    Call<List<EventsDtO>> call = eventService.fetchAllEvents();
                    call.enqueue(new Callback<List<EventsDtO>>() {
                        @Override
                        public void onResponse(Call<List<EventsDtO>> call, Response<List<EventsDtO>> response) {
                            if (!response.isSuccessful()) {
                                List<EventsDtO> eventsDTOS = response.body();
                                eventList = eventsDTOS.stream()
                                        .map(e -> new EventsDtO(e.getEventName(), e.getEventDescription(), R.drawable.eventz, "VIP", 0))
                                        .collect(Collectors.toList());
                                adapter = new EventsAdapter(eventList);
                                recyclerView.setAdapter(adapter);
                            } else {
                                Log.d("MainActivity", "Am ajuns în else");

                            }
                        }

                        @Override
                        public void onFailure(Call<List<EventsDtO>> call, Throwable t) {
                            // Tratează cazul în care apelul a eșuat
                            t.printStackTrace();
                        }
                    });

                    // Setați GridLayoutManager pentru a aranja cardurile în două coloane
                    GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
                    recyclerView.setLayoutManager(layoutManager);

                    // Add the TextWatcher to the searchEditText
                    searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_NULL) {
                                String query = textView.getText().toString().trim();
                                adapter.filterList(query);
                                return true;
                            }
                            return false;
                        }
                    });

                } else {
                    // Altfel, faceți invizibile butonul și bara de căutare
                    btnAddEvent.setVisibility(View.GONE);
                    searchEditText.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
        });

        // Add TextWatcher to the searchEditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String query = editable.toString().trim();
                adapter.filterList(query);
            }
        });
    }
}


