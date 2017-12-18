package com.example.pc.flight_booking_app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pc.flight_booking_app.actors.flightPoint;

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

        //Table creation
        String CREATE_TICKET_T = "CREATE TABLE " + TableData.getTable_ticket()
                + "("
                + TableData.getTicket_flightC1() + " INTEGER PRIMARY KEY,"
                + TableData.getTicketC2() + " INTEGER"
                + ")";

        String CREATE_FLIGHT_T = "CREATE TABLE " + TableData.getTable_flight()
                + "("
                + TableData.getTicket_flightC1() + " INTEGER PRIMARY KEY,"
                + TableData.getFlightC2() + " TEXT,"
                + TableData.getFlightC3() + " TEXT,"
                + TableData.getFlightC4() + " TEXT,"
                + TableData.getFlightC5() + " TEXT,"
                + TableData.getFlightC6() + " TEXT,"
                + TableData.getFlightC7() + " REAL,"
                + TableData.getFlightC8() + " TEXT"
                + ")";

        String CREATE_COUNTRY_T = "CREATE TABLE " + TableData.getTable_flightPoint()
                + "("
                + TableData.getFlightPointC1() + " INTEGER PRIMARY KEY,"
                + TableData.getFlightPointC2() + " TEXT,"
                + TableData.getFlightPointC3() + " REAL,"
                + TableData.getFlightPointC4() + " REAL" + ")";

        String CREATE_TICKET_FLIGHT_T = "CREATE TABLE " + TableData.getTable_ticket_flight()
                + "("
                + TableData.getTicket_flightC1() + " INTEGER,"
                + TableData.getTicket_flightC2() + " INTEGER"
                + ")";

        String [] statements = new String[]{CREATE_TICKET_T, CREATE_FLIGHT_T, CREATE_COUNTRY_T, CREATE_TICKET_FLIGHT_T};

        //execute table
        for(String execute : statements)
            sqlDB.execSQL(execute);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i1) {
        //Execute when database version is updated
        sqlDB.execSQL(dropTable());
        onCreate(sqlDB);
    }

    //used to drop table
    private String dropTable(){
        return "DROP TABLE IF EXISTS " + TableData.getTable_ticket_flight()
                + "," + TableData.getTable_flightPoint()
                + "," + TableData.getTable_flight();
    }

    public void addCountry(flightPoint o){

        SQLiteDatabase sqlDB = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TableData.getFlightPointC2(),o.getName());
        values.put(TableData.getFlightPointC3(),o.getLongi());
        values.put(TableData.getFlightPointC4(),o.getLat());

        sqlDB.insert(TableData.getTable_flightPoint(),null,values);
        sqlDB.close();
    }


    public List<flightPoint> getCountries(){
        List<flightPoint> list = new ArrayList<flightPoint>();

        String query = "SELECT * FROM "+ TableData.getTable_flightPoint();

        SQLiteDatabase sqlDB = this.getWritableDatabase();
        Cursor cursor = sqlDB.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                flightPoint country = new flightPoint();
                country.setId(Integer.parseInt(cursor.getString(0)));
                country.setName((cursor.getString(1)));
                country.setLongi(Float.parseFloat((cursor.getString(2))));
                country.setLat(Float.parseFloat((cursor.getString(3))));



                list.add(country);
            }while(cursor.moveToNext());
        }


        return list;

    }

}
