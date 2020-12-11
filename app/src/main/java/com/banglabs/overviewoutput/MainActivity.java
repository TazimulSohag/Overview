package com.banglabs.overviewoutput;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton, endButton, searchButton;
    private TextView startDateTextView, endDateTextView;
    private DatePickerDialog datePickerDialog;
    int sday, smonth, syear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //textView
        startDateTextView = findViewById(R.id.show_start_date_id);
        endDateTextView = findViewById(R.id.show_end_date_id);
        searchButton = findViewById(R.id.search_btn_id);


        //button

        startButton = findViewById(R.id.start_date_btn_id);
        endButton = findViewById(R.id.end_date_btn_id);


        //listener

        startButton.setOnClickListener(this);
        endButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.start_date_btn_id:
                DatePicker datePicker = new DatePicker(this);
                int currentDay = datePicker.getDayOfMonth();
                int currentMonth = datePicker.getMonth();
                int currentYear = datePicker.getYear();


                datePickerDialog = new DatePickerDialog(this,

                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                startDateTextView.setText(day + " / " + (month + 1) + " / " + year);


                            }
                        }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();
                break;


            case R.id.end_date_btn_id:

                DatePicker DatePicker = new DatePicker(this);
                int CurrentDay = DatePicker.getDayOfMonth();
                int CurrentMonth = DatePicker.getMonth();
                int CurrentYear = DatePicker.getYear();

                sday = CurrentDay;
                smonth = CurrentMonth;
                syear = CurrentYear;


                datePickerDialog = new DatePickerDialog(this,

                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker DatePicker, int Year, int Month, int Day) {

                                endDateTextView.setText(Day + " / " + (Month + 1) + " / " + Year);
                            }
                        }, CurrentYear, CurrentMonth, CurrentDay);
                datePickerDialog.show();
                break;


        }


    }
}
