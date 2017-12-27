package com.example.pc.flight_booking_app.activities;

import android.content.Intent;
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
    private Bundle bundle;
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
        bundle = getIntent().getExtras();
        isOrigin = bundle.getBoolean("isOrigin");

        for(int i=0;i<listGrab.size();i++){
            id[i] = listGrab.get(i).getId();
            listing[i] = " Country: " + listGrab.get(i).getCountry()+ " City:" + listGrab.get(i).getCity();
        }


        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listing);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent (Flight_Point_List.this, FlightBooking.class);
                Bundle extras = new Bundle();

                extras.putString("country",listGrab.get(i).getCountry());
                extras.putString("city",listGrab.get(i).getCity());
                extras.putBoolean("isOrigin", isOrigin);
                extras.putString("departure", bundle.getString("departure"));
                extras.putString("return", bundle.getString("return"));
                extras.putString("destination", bundle.getString("destination"));
                extras.putString("origin", bundle.getString("origin"));
                extras.putBoolean("chkRound", bundle.getBoolean("chkRound"));

                if(isOrigin) {
                    extras.putInt("firstID", listGrab.get(i).getId());
                    extras.putInt("secondID", bundle.getInt("secondID"));

                }
                else {
                    extras.putInt("firstID", bundle.getInt("firstID"));
                    extras.putInt("secondID",listGrab.get(i).getId());
                }
                intent.putExtras(extras);

                startActivity(intent);

            }
        });
    }
}
