package com.example.pc.flight_booking_app.database;

/**
 * Created by PC on 12/12/2017.
 * HEADER
 * table data used to create table
 *
 */

public class TableData {

    public static String getTable_ticket() {
        return table_ticket;
    }

    public static String getTicketC1() {
        return ticketC1;
    }

    public static String getTicketC2() {
        return ticketC2;
    }

    public static String getTable_ticket_flight() {
        return table_ticket_flight;
    }

    public static String getTicket_flightC1() {
        return ticket_flightC1;
    }

    public static String getTicket_flightC2() {
        return ticket_flightC2;
    }

    public static String getTable_flight() {
        return table_flight;
    }

    public static String getFlightC1() {
        return flightC1;
    }

    public static String getFlightC3() {
        return flightC3;
    }

    public static String getFlightC4() {
        return flightC4;
    }

    public static String getFlightC5() {
        return flightC5;
    }

    public static String getFlightC6() {
        return flightC6;
    }

    public static String getFlightC7() {
        return flightC7;
    }

    public static String getFlightC8() {
        return flightC8;
    }

    public static String getFlightC9() {
        return flightC9;
    }

    public static String getTable_country() {
        return table_country;
    }

    public static String getCountryC1() {
        return countryC1;
    }

    public static String getCountryC2() {
        return countryC2;
    }

    //Ticket table
    private static final String table_ticket = "ticket_t";
    private static final String ticketC1 = "ticketID";
    private static final String ticketC2 = "PassengerID";

    //Ticket to Flight associated table
    private static final String table_ticket_flight = "ticket-flight";
    private static final String ticket_flightC1 = "ticketID";
    private static final String ticket_flightC2 = "flight_number";

    //Flight option table
    private static final String table_flight = "flight_t";
    private static final String flightC1 = "flight_number";
    private static final String flightC3 = "departure_date";
    private static final String flightC4 = "departure_time";
    private static final String flightC5 = "airline";
    //origin and destination by country id
    private static final String flightC6 = "origin";
    private static final String flightC7 = "destination";
    private static final String flightC8 = "ticket_price";
    private static final String flightC9 = "flight_time";


    private static final String table_country = "country_t";
    private static final String countryC1 = "countryid";
    private static final String countryC2 = "geo";





}
