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
import com.example.pc.flight_booking_app.utility.Listings;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PreviewFlightBooking extends AppCompatActivity {

    private ListView lvAirline;
    private String [] selectedAirline;
    private ArrayAdapter<String> arrayAdapter;
    private Bundle bundle;
    private String dDate;
    private String origin;
    private String destination;
    private int flightNumber;
    private EditText etFlightNumber;
    private EditText etOrigin;
    private EditText etDestination;
    private EditText etTravelTime;
    private EditText etPrice;
    private EditText etDepartureDate;
    private EditText etDepartureTime;
    private EditText etArrivalDate;
    private EditText etArrivalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_flight_booking);

        //Set Variables
        setTools();
        bundle = getIntent().getExtras();
        setTextandBundles();

        setDisableButton();

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

    //disable buttons
    private void setDisableButton(){
        etFlightNumber.setEnabled(false);
        etOrigin.setEnabled(false);
        etDestination.setEnabled(false);
        etTravelTime.setEnabled(false);
        etPrice.setEnabled(false);
        etDepartureDate.setEnabled(false);
        etDepartureTime.setEnabled(false);
        etArrivalDate.setEnabled(false);
        etArrivalTime.setEnabled(false);
    }

    private void setTools(){
        etFlightNumber = (EditText) findViewById(R.id.pfbEtFlightNumber);
        etOrigin = (EditText) findViewById(R.id.pfbEtOrigin);
        etDestination = (EditText) findViewById(R.id.pfbEtDestination);
        etTravelTime = (EditText) findViewById(R.id.pfbEtTravel);
        etPrice = (EditText) findViewById(R.id.pfbEtPrice);
        etDepartureDate = (EditText) findViewById(R.id.pfbEtDepartureDate);
        etDepartureTime = (EditText) findViewById(R.id.pfbEtDTime);
        etArrivalDate = (EditText) findViewById(R.id.pfbEtArrivalDate);
        etArrivalTime = (EditText) findViewById(R.id.pfbEtATime);
        lvAirline = (ListView) findViewById(R.id.pfLvAirline);
    }

    private void setTextandBundles(){
        Date date = Listings.getDate(bundle.getString("departure"));
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("hh");

        dDate = bundle.getString("departure");
        origin = bundle.getString("origin");
        destination = bundle.getString("destination");
        etOrigin.setText(bundle.getString("origin"));
        etDestination.setText(bundle.getString("destination"));
        etDepartureDate.setText(formatter.format(date));
        selectedAirline = new String[]{"Select airline"};

        if(getIntent().hasExtra("airline")) {
            flightNumber = bundle.getInt("flightID");
            String departureTime = bundle.getString("departureTime");
            String travelTime = bundle.getString("travelTime");
            Date arrivalDate = Listings.calcArrivalTime(dDate,Integer.parseInt(departureTime)/100,Integer.parseInt(travelTime));

            etFlightNumber.setText(Integer.toString(flightNumber));
            etDepartureTime.setText(departureTime);
            etPrice.setText(bundle.getString("price"));
            selectedAirline = new String[]{"Airline: " + bundle.getString("airline")};
            etTravelTime.setText(travelTime + " Hours");
            etArrivalDate.setText(formatter.format(arrivalDate));




        }
    }
}
