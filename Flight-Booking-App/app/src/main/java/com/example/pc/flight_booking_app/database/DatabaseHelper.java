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


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i1) {

    }

    private String dropTable(){
        return "DROP TABLE IF EXISTS " + TableData.getTable_ticket_flight()
                + "," + TableData.getTable_country()
                + "," + TableData.getTable_flight();
    }
}
