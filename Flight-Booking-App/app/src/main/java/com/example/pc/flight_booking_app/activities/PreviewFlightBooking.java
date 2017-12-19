package com.example.pc.flight_booking_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.pc.flight_booking_app.R;

public class PreviewFlightBooking extends AppCompatActivity {

    private ListView lvAirline;
    private String [] selectedAirline;
    private ArrayAdapter<String> arrayAdapter;
    private Bundle bundle;

    private String dDate;
    private String origin;
    private String destination;
    private int distance;

    private EditText btnFlightNumber;
    private EditText btnOrigin;
    private EditText btnDestination;
    private EditText btnTravelTime;
    private EditText btnPrice;
    private EditText btnDepartureDate;
    private EditText btnDepartureTime;
    private EditText btnArrivalDate;
    private EditText btnArrivalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_flight_booking);


        bundle = getIntent().getExtras();
        dDate = bundle.getString("departure");
        origin = bundle.getString("origin");
        destination = bundle.getString("destination");
        distance = bundle.getInt("distance");

        btnFlightNumber = findViewById(R.id.pfbEtFlightNumber);
        btnOrigin = findViewById(R.id.pfbEtOrigin);
        btnDestination = findViewById(R.id.pfbEtDestination);
        btnTravelTime = findViewById(R.id.pfbEtTravel);
        btnPrice = findViewById(R.id.pfbEtPrice);
        btnDepartureDate = findViewById(R.id.pfbEtDepartureDate);
        btnDepartureTime = findViewById(R.id.pfbEtDTime);
        btnArrivalDate = findViewById(R.id.pfbEtArrivalDate);
        btnArrivalTime = findViewById(R.id.pfbEtATime);


        btnFlightNumber.setEnabled(false);
        btnOrigin.setEnabled(false);
        btnDestination.setEnabled(false);
        btnTravelTime.setEnabled(false);
        btnPrice.setEnabled(false);
        btnDepartureDate.setEnabled(false);
        btnDepartureTime.setEnabled(false);
        btnArrivalDate.setEnabled(false);
        btnArrivalTime.setEnabled(false);
        lvAirline = (ListView) findViewById(R.id.pfLvAirline);

        selectedAirline = new String[]{"Select airline"};

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, selectedAirline);
        lvAirline.setAdapter(arrayAdapter);

        lvAirline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PreviewFlightBooking.this,Flight_List.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
