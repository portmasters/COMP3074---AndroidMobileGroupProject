package com.example.pc.flight_booking_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pc.flight_booking_app.R;

public class PreviewFlightBooking extends AppCompatActivity {

    private ListView lvAirline;
    private String [] selectedAirline;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_flight_booking);

        lvAirline = (ListView) findViewById(R.id.pfLvAirline);

        selectedAirline[0] = "Select airline";

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, selectedAirline);
        lvAirline.setAdapter(arrayAdapter);

    }
}
