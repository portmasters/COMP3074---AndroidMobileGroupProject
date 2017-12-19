package com.example.pc.flight_booking_app.utility;

import com.example.pc.flight_booking_app.activities.Flight_Point_List;
import com.example.pc.flight_booking_app.actors.FlightPoint;
import com.example.pc.flight_booking_app.actors.Flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by PC on 12/18/2017.
 */

public class Listings {



    public static List<FlightPoint> flightPointList(){
        List<FlightPoint> list = new ArrayList<>();

        list.add(new FlightPoint("Canada",43.678317f,-79.626538f,"Toronto"));
        list.add(new FlightPoint("Japan",35.568260f, 139.775945f,"Tokyo"));
        list.add(new FlightPoint("United State",32.907381f, -97.040510f,"Dallas"));
        return list;
    }

    public static List<Flights> randomFlightlist(String date, String origin, String destination, int distance){
        Random rn = new Random();

        int[] startTime = new int[3];

        for(int i = 0; i <startTime.length;i++){
           startTime[i] = -1;
        }

        while(startTime[0]==startTime[1] || startTime[0] == startTime[2] || startTime[1] == startTime[2]){
            for(int i = 0; i <startTime.length;i++){
                startTime[i] = rn.nextInt(15)+8;
            }
        }

        for(int i = 0; i <startTime.length;i++){
            startTime[i] = startTime[i] * 100;
        }

        List<Flights> list = new ArrayList<Flights>();
        int flight = distance/700;
        int price = distance/5;
        list.add(new Flights(date,Integer.toString(startTime[0]),"Eva",origin,destination,Integer.toString(price + (rn.nextInt(3)*100)),Integer.toString(flight)));
        list.add(new Flights(date,Integer.toString(startTime[1]),"Emirates",origin,destination,Integer.toString(price + (rn.nextInt(3)*100)),Integer.toString(flight)));
        list.add(new Flights(date,Integer.toString(startTime[2]),"Hannel",origin,destination,Integer.toString(price + (rn.nextInt(3)*100)),Integer.toString(flight)));

        return list;
    }

}
