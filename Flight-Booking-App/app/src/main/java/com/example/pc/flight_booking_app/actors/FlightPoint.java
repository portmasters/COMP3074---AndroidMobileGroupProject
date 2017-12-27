package com.example.pc.flight_booking_app.actors;

/**
 * Created by PC on 12/18/2017.
 */

public class FlightPoint {
    public FlightPoint() {
    }

    public FlightPoint(String country, float lat, float longi, String city) {
        this.country = country;
        this.lat = lat;
        this.longi = longi;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    private int id;
    private String country;
    private float lat;
    private float longi;
    private String city;
}
