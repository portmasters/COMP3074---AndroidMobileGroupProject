package com.example.pc.flight_booking_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pc.flight_booking_app.actors.FlightPoint;
import com.example.pc.flight_booking_app.actors.Flights;
import com.example.pc.flight_booking_app.utility.Listings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 12/12/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String db_Name = "FlightAppDatabase";

    public DatabaseHelper(Context context) {
        super(context, db_Name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqlDB) {

        //drop table
        for(String o : dropTable())
            sqlDB.execSQL(o);


        //Table creation
        String CREATE_TICKET_T = "CREATE TABLE " + TableData.getTable_ticket()
                + "("
                + TableData.getTicket_flightC1() + " INTEGER PRIMARY KEY,"
                + TableData.getTicketC2() + " INTEGER"
                + ")";

        String CREATE_FLIGHT_T = "CREATE TABLE " + TableData.getTable_flight()
                + "("
                + TableData.getFlightC1() + " INTEGER PRIMARY KEY,"
                + TableData.getFlightC2() + " TEXT,"
                + TableData.getFlightC3() + " TEXT,"
                + TableData.getFlightC4() + " TEXT,"
                + TableData.getFlightC5() + " TEXT,"
                + TableData.getFlightC6() + " TEXT,"
                + TableData.getFlightC7() + " TEXT,"
                + TableData.getFlightC8() + " TEXT"
                + ")";

        String CREATE_FLIGHTPOINT_T = "CREATE TABLE " + TableData.getTable_flightPoint()
                + "("
                + TableData.getFlightPointC1() + " INTEGER PRIMARY KEY,"
                + TableData.getFlightPointC2() + " TEXT,"
                + TableData.getFlightPointC3() + " REAL,"
                + TableData.getFlightPointC4() + " REAL,"
                + TableData.getFlightPointC5() + " TEXT"
                + ")";

        String CREATE_TICKET_FLIGHT_T = "CREATE TABLE " + TableData.getTable_ticket_flight()
                + "("
                + TableData.getTicket_flightC1() + " INTEGER,"
                + TableData.getTicket_flightC2() + " INTEGER"
                + ")";

        String CREATE_CUSTOMER_T = "CREATE TABLE " + TableData.getTable_customer()
                + "("
                + TableData.getCustomerC1() + " INTEGER PRIMARY KEY,"
                + TableData.getCustomerC2() + " TEXT,"
                + TableData.getCustomerC3() + " TEXT,"
                + TableData.getCustomerC4() + " TEXT,"
                + TableData.getCustomerC5() + " TEXT,"
                + TableData.getCustomerC6() + " TEXT,"
                + TableData.getCustomerC7() + " TEXT,"
                + TableData.getCustomerC8() + " TEXT,"
                + TableData.getCustomerC9() + " TEXT"
                + ")";

        String [] statements = new String[]{CREATE_TICKET_T, CREATE_FLIGHT_T, CREATE_FLIGHTPOINT_T, CREATE_TICKET_FLIGHT_T, CREATE_CUSTOMER_T};

        //execute table
        for(String execute : statements)
            sqlDB.execSQL(execute);


        for(FlightPoint o : Listings.addNewFlightPointList())
        {
            ContentValues values = new ContentValues();
            values.put(TableData.getFlightPointC2(),o.getCountry());
            values.put(TableData.getFlightPointC3(),o.getLat());
            values.put(TableData.getFlightPointC4(),o.getLongi());
            values.put(TableData.getFlightPointC5(),o.getCity());

            sqlDB.insert(TableData.getTable_flightPoint(),null,values);
        }

        ContentValues value = new ContentValues();
        value.put(TableData.getFlightC1(),10010);
        value.put(TableData.getFlightC2()," ");
        value.put(TableData.getFlightC3()," ");
        value.put(TableData.getFlightC4()," ");
        value.put(TableData.getFlightC5()," ");
        value.put(TableData.getFlightC6()," ");
        value.put(TableData.getFlightC7()," ");
        value.put(TableData.getFlightC8()," ");

        sqlDB.insert(TableData.getTable_flight(),null,value);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i1) {
        //Execute when database version is updated

        onCreate(sqlDB);
    }

    //used to drop table
    private List<String> dropTable(){
        List<String> list = new ArrayList<String>();
        list.add("DROP TABLE IF EXISTS " + TableData.getTable_ticket_flight());
        list.add("DROP TABLE IF EXISTS " + TableData.getTable_flightPoint());
        list.add("DROP TABLE IF EXISTS " + TableData.getTable_flight());
        list.add("DROP TABLE IF EXISTS " + TableData.getTable_ticket());
        list.add("DROP TABLE IF EXISTS " + TableData.getTable_customer());

        return list;

    }

    public void addFlightPoint(FlightPoint o){

        SQLiteDatabase sqlDB = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TableData.getFlightPointC2(),o.getCountry());
        values.put(TableData.getFlightPointC3(),o.getLat());
        values.put(TableData.getFlightPointC4(),o.getLongi());
        values.put(TableData.getFlightPointC5(),o.getCity());

        sqlDB.insert(TableData.getTable_flightPoint(),null,values);
        sqlDB.close();
    }


    public List<FlightPoint> getFlightPoints(){
        List<FlightPoint> list = new ArrayList<FlightPoint>();

        String query = "SELECT * FROM "+ TableData.getTable_flightPoint();

        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                FlightPoint flightPoint = new FlightPoint();
                flightPoint.setId(Integer.parseInt(cursor.getString(0)));
                flightPoint.setCountry((cursor.getString(1)));
                flightPoint.setLat(Float.parseFloat((cursor.getString(2))));
                flightPoint.setLongi(Float.parseFloat((cursor.getString(3))));
                flightPoint.setCity(cursor.getString(4));
                list.add(flightPoint);
            }while(cursor.moveToNext());
        }
        return list;
    }

    //addFlights
    public void addFlight(Flights o){

        SQLiteDatabase sqlDB = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TableData.getFlightC2(),o.getDepartureDate());
        values.put(TableData.getFlightC3(),o.getDepartureTime());
        values.put(TableData.getFlightC4(),o.getAirline());
        values.put(TableData.getFlightC5(),o.getOrigin());
        values.put(TableData.getFlightC6(),o.getDestination());
        values.put(TableData.getFlightC7(),o.getTicketPrice());
        values.put(TableData.getFlightC8(),o.getFlightTime());

        sqlDB.insert(TableData.getTable_flight(),null,values);
        sqlDB.close();
    }


    public List<Flights> getFlights(){
        List<Flights> list = new ArrayList<Flights>();

        String query = "SELECT * FROM "+ TableData.getTable_flight();

        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Flights flight = new Flights();
                flight.setFlight_number(Integer.parseInt(cursor.getString(0)));
                flight.setDepartureDate(cursor.getString(1));
                flight.setDepartureTime(cursor.getString(2));
                flight.setAirline(cursor.getString(3));
                flight.setOrigin(cursor.getString(4));
                flight.setDestination(cursor.getString(5));
                flight.setTicketPrice(cursor.getString(6));
                flight.setFlightTime(cursor.getString(7));

                list.add(flight);
            }while(cursor.moveToNext());
        }
        return list;
    }
}
