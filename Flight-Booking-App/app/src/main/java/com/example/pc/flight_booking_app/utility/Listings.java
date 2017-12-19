package com.example.pc.flight_booking_app.utility;

import com.example.pc.flight_booking_app.activities.Flight_Point_List;
import com.example.pc.flight_booking_app.actors.FlightPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 12/18/2017.
 */

public class Listings {



    public static List<FlightPoint> flightPointList(){
        List<FlightPoint> list = new ArrayList<>();

        list.add(new FlightPoint("Canada",43.678317f,-79.626538f,"Toronto"));
        list.add(new FlightPoint("Japan",35.568260f, 139.775945f,"Tokoyo"));
        return list;
    }

}
