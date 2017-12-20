package com.example.pc.flight_booking_app.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by PC on 12/17/2017.
 */

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx){
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUsername(String username){
        prefs.edit().putString("username", username).commit();
    }

    public String getUsername(){
        String username = prefs.getString("username", "");
        return username;
    }

    /* to use SESSION CLASS

    private Session session;//global variable
    session = new Session(cntx); //in oncreate
    //and now we set sharedpreference then use this like

    session.setusename("USERNAME");
    now whenever you want to get the username then same work is to be done for session object and call this

    session.getusename();
     */


}
