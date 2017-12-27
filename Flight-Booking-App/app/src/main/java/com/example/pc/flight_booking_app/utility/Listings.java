package com.example.pc.flight_booking_app.utility;

import com.example.pc.flight_booking_app.activities.Flight_Point_List;
import com.example.pc.flight_booking_app.actors.FlightPoint;
import com.example.pc.flight_booking_app.actors.Flights;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * Created by PC on 12/18/2017.
 */

public class Listings {



    public static List<FlightPoint> addNewFlightPointList(){
        List<FlightPoint> list = new ArrayList<>();

        list.add(new FlightPoint("Canada",43.678317f,-79.626538f,"Toronto"));
        list.add(new FlightPoint("Japan",35.568260f, 139.775945f,"Tokyo"));
        list.add(new FlightPoint("United State",32.907381f, -97.040510f,"Dallas"));
        return list;
    }

    public static List<Flights> addNewRandomFlightlist(String date, String origin, String destination, int distance){
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
        int flightTimeHours = Math.round(distance/700);
        int price = distance/5;
        list.add(new Flights(date,Integer.toString(startTime[0]),"Eva",origin,destination,Integer.toString(price + (rn.nextInt(4)*100)),Integer.toString(flightTimeHours)));
        list.add(new Flights(date,Integer.toString(startTime[1]),"Emirates",origin,destination,Integer.toString(price + (rn.nextInt(4)*100)),Integer.toString(flightTimeHours)));
        list.add(new Flights(date,Integer.toString(startTime[2]),"Hannel",origin,destination,Integer.toString(price + (rn.nextInt(4)*100)),Integer.toString(flightTimeHours)));

        return list;
    }

    public static Date calcArrivalTime(String departure, int time, int duration){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            Date dateCheck = sdf.parse(departure);
            cal.setTime(dateCheck);
            cal.add(Calendar.HOUR_OF_DAY,time + duration);





        }catch (Exception e){
            return null;
        }

        date = cal.getTime();
        return date;
    }

    public static Date getDate(String dateInput){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(dateInput);

        }catch (Exception e){
            return null;
        }

        return date;
    }

}
