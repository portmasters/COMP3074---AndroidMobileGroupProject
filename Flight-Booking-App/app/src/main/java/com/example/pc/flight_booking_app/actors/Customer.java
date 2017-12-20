package com.example.pc.flight_booking_app.actors;

/**
 * Created by PC on 12/17/2017.
 */

public class Customer {
    private int customer_id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String address;
    private String phone;
    private String ccn;
    private String security;

    public Customer(){
    }

    public Customer(int customer_id, String username, String password, String fname, String lname, String address, String phone, String ccn, String security){
        this.customer_id = customer_id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.ccn = ccn;
        this.security = security;
    }

    public int getCustomer_id(){return customer_id;}
    public void setCustomer_id(int customer_id){this.customer_id = customer_id;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getFname(){return fname;}
    public void setFname(String fname){this.fname = fname;}

    public String getLname(){return lname;}
    public void setLname(String lname){this.lname = lname;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

    public String getCcn(){return ccn;}
    public void setCcn(String ccn){this.ccn = ccn;}

    public String getSecurity(){return security;}
    public void setSecurity(String security){this.security = security;}
}
