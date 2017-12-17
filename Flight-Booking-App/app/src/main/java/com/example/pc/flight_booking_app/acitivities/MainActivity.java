package com.example.pc.flight_booking_app.acitivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.pc.flight_booking_app.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Used to test other activities
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
        //


        //INSERT MAIN CODE BELOW


    }
}
