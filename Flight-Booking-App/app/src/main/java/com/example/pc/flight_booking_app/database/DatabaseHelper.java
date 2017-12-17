package com.example.pc.flight_booking_app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

        String CREATE_COUNTRY_T = "CREATE TABLE " + TableData.getTable_country()
                + "("
                + TableData.getCountryC1() + " INTEGER PRIMARY KEY,"
                + TableData.getCountryC2() + " TEXT,"
                + TableData.getCountryC3() + " REAL,"
                + TableData.getCountryC4() + " REAL" + ")";

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
                + "," + TableData.getTable_country()
                + "," + TableData.getTable_flight();
    }
}
