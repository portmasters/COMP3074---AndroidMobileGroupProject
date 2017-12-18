package com.example.pc.flight_booking_app.actors;

/**
 * Created by PC on 12/17/2017.
 */

public class flightPoint {
    public flightPoint() {
    }

    public flightPoint(int id, String name, float lat, float longi) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.longi = longi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLongi() {
        return longi;
    }

    public void setLongi(float longi) {
        this.longi = longi;
    }

    private int id;
    private String name;
    private float lat;
    private float longi;
}
