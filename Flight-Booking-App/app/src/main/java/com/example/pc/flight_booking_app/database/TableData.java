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

    public static String getFlightC2() {
        return flightC2;
    }

    public static String getTable_flightPoint() {
        return table_flightPoint;
    }

    public static String getFlightPointC1() {
        return flightPointC1;
    }

    public static String getFlightPointC2() {
        return flightPointC2;
    }

    public static String getFlightPointC3() {
        return flightPointC3;
    }

    public static String getFlightPointC4() {
        return flightPointC4;
    }
    public static String getFlightPointC5() {
        return flightPointC5;
    }

    public static String getTable_customer(){return table_customer;}

    public static String getCustomerC1(){return customerC1;}

    public static String getCustomerC2(){return customerC2;}

    public static String getCustomerC3(){return customerC3;}

    public static String getCustomerC4(){return customerC4;}

    public static String getCustomerC5(){return customerC5;}

    public static String getCustomerC6(){return customerC6;}

    public static String getCustomerC7(){return customerC7;}

    public static String getCustomerC8(){return customerC8;}

    public static String getCustomerC9(){return customerC9;}

    //Ticket table
    private static final String table_ticket = "ticket_t";
    private static final String ticketC1 = "ticketID";
    private static final String ticketC2 = "PassengerID";

    //Ticket to Flight associated table
    private static final String table_ticket_flight = "ticket_flight";
    private static final String ticket_flightC1 = "ticketID";
    private static final String ticket_flightC2 = "flight_number";

    //Flight option table
    private static final String table_flight = "flight_t";
    private static final String flightC1 = "flight_number";
    private static final String flightC2 = "departure_date";
    private static final String flightC3 = "departure_time";
    private static final String flightC4 = "airline";
    private static final String flightC5 = "origin";
    private static final String flightC6 = "destination";
    private static final String flightC7 = "ticket_price";
    private static final String flightC8 = "flight_time";

    //Countries table
    private static final String table_flightPoint = "flightPoint_t";
    private static final String flightPointC1 = "flight_Point_id";
    private static final String flightPointC2 = "country";
    private static final String flightPointC3 = "lat";
    private static final String flightPointC4 = "long";
    private static final String flightPointC5 = "city";

    //Customer table
    private static final String table_customer = "customer_t";
    private static final String customerC1 = "customer_id";
    private static final String customerC2 = "username";
    private static final String customerC3 = "password";
    private static final String customerC4 = "first_name";
    private static final String customerC5 = "last_name";
    private static final String customerC6 = "address";
    private static final String customerC7 = "phone_number";
    private static final String customerC8 = "credit_card_number";
    private static final String customerC9 = "security_number";






}
