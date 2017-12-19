package com.example.pc.flight_booking_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pc.flight_booking_app.R;
import com.example.pc.flight_booking_app.actors.FlightPoint;
import com.example.pc.flight_booking_app.actors.Flights;
import com.example.pc.flight_booking_app.database.DatabaseHelper;
import com.example.pc.flight_booking_app.utility.Listings;

import java.util.ArrayList;
import java.util.List;

public class Flight_List extends AppCompatActivity {

    private int[] id;
    private String[] listing;
    private Bundle bundle;
    private ListView list;
    private List<Flights> listGrab;
    private List<Flights> listGrab2;
    private ArrayAdapter<String> arrayAdapter;

    private String dDate;
    private String origin;
    private String destination;
    private int distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight__list);


        DatabaseHelper sqlDB = new DatabaseHelper(this);

        listGrab = sqlDB.getFlights();
        listGrab2 = new ArrayList<Flights>();
        list = (ListView) findViewById(R.id.fpvLvFlight);


        bundle = getIntent().getExtras();
        dDate = bundle.getString("departure");
        origin = bundle.getString("origin");
        destination = bundle.getString("destination");
        distance = bundle.getInt("distance");



        setList();

        if(listGrab2.size() == 0){
            for(Flights o :Listings.randomFlightlist(dDate,origin,destination,distance)){
                sqlDB.addFlight(o);
            }
            listGrab = sqlDB.getFlights();
            setList();
        }

        id = new int[listGrab2.size()];
        listing = new String[listGrab2.size()];
        for(int i=0;i<listGrab2.size();i++){
            id[i] = listGrab2.get(i).getFlight_number();
            listing[i] = "Airline: " + listGrab2.get(i).getAirline() + " \nDeparture time: " + Integer.parseInt(listGrab2.get(i).getDepartureTime())/100 + ":00 \nPrice: $"
                    + listGrab2.get(i).getTicketPrice();
        }

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listing);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void setList(){
        for(Flights o : listGrab){
            if(o.getDepartureDate().equals(dDate) && o.getOrigin().equals(origin) && o.getDestination().equals(destination)){
                listGrab2.add(o);
            }
        }
    }
}
