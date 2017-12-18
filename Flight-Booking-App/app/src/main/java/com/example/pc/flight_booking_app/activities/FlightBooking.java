package com.example.pc.flight_booking_app.activities;

import android.app.DatePickerDialog;
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

import com.example.pc.flight_booking_app.R;

import java.util.Calendar;

public class FlightBooking extends AppCompatActivity {

    private static final String TAG = "FlightBooking";

    private TextView txtDateDeparture;
    private Button btnDateDeparture;
    private DatePickerDialog.OnDateSetListener datePickedListener;
    private CheckBox chkRound;
    private TextView txtDateReturn;
    private Button btnDateReturn;

    private boolean isReturnClick = false;


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

        //Set visible
        btnDateReturn.setVisibility(View.INVISIBLE);
        txtDateReturn.setVisibility(View.INVISIBLE);


        //Show calender view and set date for departure date button
        btnDateDeparture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        FlightBooking.this,
                        android.R.style.Theme_Holo_Dialog,
                        datePickedListener,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                dialog.show();


            }
        });
        //Show calender view and set date for return date button
        btnDateReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                isReturnClick = true;

                DatePickerDialog dialog = new DatePickerDialog(
                        FlightBooking.this,
                        android.R.style.Theme_Holo_Dialog,
                        datePickedListener,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                dialog.show();

            }
        });

        //calender listener for date selection
        datePickedListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month++;
                String date = month + "/" + day + "/" + year;

                if(isReturnClick){
                    txtDateReturn.setText(date);
                    isReturnClick=false;
                }else
                    txtDateDeparture.setText(date);
                
            }
        };
        //
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

    }


}
