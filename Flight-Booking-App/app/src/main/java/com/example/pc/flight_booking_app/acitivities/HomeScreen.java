package com.example.pc.flight_booking_app.acitivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pc.flight_booking_app.R;

public class HomeScreen extends AppCompatActivity {

    private Button btnBookFlight;
    private Button btnViewFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //set variables
        btnBookFlight = (Button) findViewById(R.id.hsBtnBookFlight);
        btnViewFlight = (Button) findViewById(R.id.hsBtnViewBookings);


        //
        btnBookFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnViewFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
