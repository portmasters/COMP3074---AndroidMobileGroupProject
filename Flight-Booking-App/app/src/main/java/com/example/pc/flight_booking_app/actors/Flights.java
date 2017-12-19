package com.example.pc.flight_booking_app.actors;

/**
 * Created by PC on 12/17/2017.
 */

public class Flights {
    public Flights() {
    }

    public Flights(String departureDate, String departureTime, String airline, String origin, String destination, String ticketPrice, String flightTime) {
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.flightTime = flightTime;
    }



    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    private int flight_number;
    private String departureDate;
    private String departureTime;
    private String airline;
    private String origin;
    private String destination;
    private String ticketPrice;
    private String flightTime;
}
