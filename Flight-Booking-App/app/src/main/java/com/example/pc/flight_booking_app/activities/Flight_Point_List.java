package com.example.pc.flight_booking_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pc.flight_booking_app.R;
import com.example.pc.flight_booking_app.actors.FlightPoint;
import com.example.pc.flight_booking_app.database.DatabaseHelper;

import java.util.List;

public class Flight_Point_List extends AppCompatActivity {

    private int[] id;
    private String[] listing;
    private Bundle extras;
    private boolean isOrigin;
    private ListView list;
    private List<FlightPoint> listGrab;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight__point__list);

        DatabaseHelper sqlDB = new DatabaseHelper(this);

        listGrab = sqlDB.getFlightPoints();
        list = (ListView) findViewById(R.id.fplLvFlightPoint);
        id = new int[listGrab.size()];
        listing = new String[listGrab.size()];
        extras = getIntent().getExtras();


        for(int i=0;i<listGrab.size();i++){
            id[i] = listGrab.get(i).getId();
            listing[i] = " Country: " + listGrab.get(i).getCountry()+ " City:" + listGrab.get(i).getCity();
        }


        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listing);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });
    }
}
