package com.example.pc.flight_booking_app.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.flight_booking_app.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FlightBooking extends AppCompatActivity {

    private static final String TAG = "FlightBooking";

    private DatePickerDialog.OnDateSetListener datePickedListener;
    private TextView txtDateDeparture;
    private Button btnDateDeparture;
    private CheckBox chkRound;
    private TextView txtDateReturn;
    private Button btnDateReturn;
    private int firstID;
    private int secondID;
    private String country = "";
    private String city ="";
    private Button btnOrigin;
    private Button btnDestination;
    private TextView txtOrigin;
    private TextView txtDestination;
    private Bundle bundle;
    private boolean isOrigin;
    private Button btnPreview;
    private Boolean isReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_booking);

        //set variables
        txtDateDeparture = (TextView) findViewById(R.id.fbTxtDateDeparture);
        btnDateDeparture = (Button) findViewById(R.id.fbBtnDateDeparture);
        chkRound = (CheckBox) findViewById(R.id.fbChkRound);
        btnDateReturn = (Button) findViewById(R.id.fbBtnDateReturn);
        txtDateReturn = (TextView) findViewById(R.id.fbTxtDateReturn);
        btnOrigin = (Button) findViewById(R.id.fbBtnOrigin);
        btnDestination = (Button) findViewById(R.id.fbBtnDes);
        txtOrigin = (TextView) findViewById(R.id.fbTxtOrigin);
        txtDestination = (TextView) findViewById(R.id.fbTxtDestination);
        firstID = -1;
        secondID = -1;
        btnPreview = (Button) findViewById(R.id.fbBtnPreview);
        isReturn = false;
        //

        //set previous settings if needed
        previousSet();

        //Set visible
        if(!chkRound.isChecked()) {
            btnDateReturn.setVisibility(View.INVISIBLE);
            txtDateReturn.setVisibility(View.INVISIBLE);
        }

        //LISTENERS BELOW

        //departure date SELECTION
        btnDateDeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDates();
            }
        });

        //return date SELECTION
        btnDateReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isReturn = true;
                setDates();
            }
        });

        //calender listener for date selection
        datePickedListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month++;
                String date = year + "-" + month + "-" + day;

                if(isReturn){
                    txtDateReturn.setText(date);
                    isReturn = false;
                }else
                    txtDateDeparture.setText(date);

            }
        };

        //Round Trip checkbox - set visibility
        chkRound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked){
                    btnDateReturn.setVisibility(View.VISIBLE);
                    txtDateReturn.setVisibility(View.VISIBLE);
                }else{
                    btnDateReturn.setVisibility(View.INVISIBLE);
                    txtDateReturn.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Origin Selection
        btnOrigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FlightBooking.this,Flight_Point_List.class);
                //save previous
                Bundle extras = sendExtras(true);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        //Destination Selection
        btnDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FlightBooking.this,Flight_Point_List.class);
                //save previous
                Bundle extras = sendExtras(false);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        //Go to next page
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkAllParam()){
                    Intent intent = new Intent(FlightBooking.this,MapsActivity.class);
                    Bundle extras = sendExtras(false);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });

    }

    //save settings
    private Bundle sendExtras(boolean n){
        Bundle extras = new Bundle();

        extras.putBoolean("isOrigin", n);

        extras.putString("origin",txtOrigin.getText().toString());
        extras.putString("departure", txtDateDeparture.getText().toString());
        extras.putString("return", txtDateReturn.getText().toString());
        extras.putBoolean("chkRound",chkRound.isChecked());
        extras.putString("origin", txtOrigin.getText().toString());
        extras.putString("destination", txtDestination.getText().toString());
        extras.putInt("firstID",firstID);
        extras.putInt("secondID",secondID);

        return extras;
    }

    //set saved settings
    private void previousSet(){
        if(getIntent().hasExtra("isOrigin")){
            bundle = getIntent().getExtras();
            isOrigin = bundle.getBoolean("isOrigin");
            txtDateDeparture.setText(bundle.getString("departure"));
            txtDateReturn.setText( bundle.getString("return"));
            firstID = bundle.getInt("firstID");
            secondID = bundle.getInt("secondID");
            chkRound.setChecked(bundle.getBoolean("chkRound"));
        }

        if(getIntent().hasExtra("isOrigin") && isOrigin){
            country = bundle.getString("country");
            city = bundle.getString("city");
            txtOrigin.setText(country + ", " + city);
            txtDestination.setText(bundle.getString("destination"));
        }else if(getIntent().hasExtra("isOrigin")){
            country = bundle.getString("country");
            city = bundle.getString("city");
            txtDestination.setText(country + ", " + city);
            txtOrigin.setText(bundle.getString("origin"));
        }
    }

    //Check for error before going to next page
    private boolean checkAllParam(){

        String n = "YYYY-MM-DD";

        if(firstID ==- 1 || secondID == -1){
            Toast.makeText(this, "Origin and Destination cannot be empty", Toast.LENGTH_SHORT).show();
           return false;
        }

        if(firstID==secondID){
            Toast.makeText(this, "Origin and Destination must be different", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(txtDateDeparture.getText().toString().equals(n) || (txtDateReturn.getText().toString().equals(n) && chkRound.isChecked())){
            Toast.makeText(this, "Date cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!txtDateReturn.getText().toString().equals(n) && chkRound.isChecked()){

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try{
                Date date = sdf.parse(txtDateDeparture.getText().toString());
                Date date2 = sdf.parse(txtDateReturn.getText().toString());

                int n2 = date.compareTo(date2);
                if(n2 >= 0){
                    Toast.makeText(this, "Return Date must be after Departure date", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }catch(Exception e){
                Toast.makeText(this, "Exception error", Toast.LENGTH_SHORT).show();
                return false;
            }


        }

        return true;
    }

    //set date
    private void setDates(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dialog = new DatePickerDialog(
                FlightBooking.this,
                android.R.style.Theme_Holo_Dialog,
                datePickedListener,
                year,month,day);
        dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
        dialog.show();
    }

}
