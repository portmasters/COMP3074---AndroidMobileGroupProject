package com.example.pc.flight_booking_app.activities;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pc.flight_booking_app.R;
import com.example.pc.flight_booking_app.actors.FlightPoint;
import com.example.pc.flight_booking_app.database.DatabaseHelper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btnContinue;
    private DatabaseHelper sqlDB = new DatabaseHelper(this);
    private Bundle bundle;
    private int firstID;
    private int secondID;
    private int result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getIntent().getExtras();
        firstID = bundle.getInt("firstID");
        secondID = bundle.getInt("secondID");

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnContinue = (Button) findViewById(R.id.mapBtnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapsActivity.this,PreviewFlightBooking.class);
                bundle.putInt("distance",result2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        List<FlightPoint> flightPoints = sqlDB.getFlightPoints();
        FlightPoint a = null;
        FlightPoint b = null;


        for(int i = 0; i<flightPoints.size(); i++){
            if(flightPoints.get(i).getId()==firstID)
                a = flightPoints.get(i);

            if(flightPoints.get(i).getId()==secondID)
                b = flightPoints.get(i);
        }


        LatLng origin= new LatLng(a.getLat(), a.getLongi());
        LatLng destination = new LatLng(b.getLat(), b.getLongi());
        float[] result = new float[1];
        Location.distanceBetween(a.getLat(), a.getLongi(),b.getLat(), b.getLongi(),result);
        result2 = Math.round(result[0]/1000);

        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions().position(origin).title("Origin"));
        mMap.addMarker(new MarkerOptions().position(destination).title("Destination"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(destination));




        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(origin,destination)
                .width(5)
                .color(Color.BLUE));
    }
}
