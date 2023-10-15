package com.example.healthcareproject.Doctors;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;

import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {

    /*--------------------------------------------------Initialize variable-------------------------------------------------------------------*/
    TextView textView1, textView2, textView3, textView4;
    TextView deptTitle;
    ImageView backToHomeDetails;
    TextView selectDateTxt, selectTimeTxt;
    Button bookAppointment;


    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);


        /*--------------------------------------------------Define TextView-------------------------------------------------------------------*/
        deptTitle = findViewById(R.id.deptName);
        textView1 = findViewById(R.id.editFullname);
        textView2 = findViewById(R.id.editAddress);
        textView3 = findViewById(R.id.editContactNo);
        textView4 = findViewById(R.id.editFees);


        /*--------------------------------------------------No editable text-------------------------------------------------------------------*/

//        textView1.setKeyListener(null);
//        textView2.setKeyListener(null);
//        textView3.setKeyListener(null);
//        textView4.setKeyListener(null);

        /*--------------------------------------------------Set data in the textView-------------------------------------------------------------------*/
        SharedPreferences sharedPreferences = getSharedPreferences("titleDept", Context.MODE_PRIVATE);
        String titleDept=sharedPreferences.getString("title","").toString();

        //To save our data with key and value

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String full_name = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");
//        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
//        String title = sharedPreferences.getString("text1", "").toString();
//        String full_name = sharedPreferences.getString("text2", "").toString();
//        String address = sharedPreferences.getString("text3", "").toString();
//        String contact = sharedPreferences.getString("text4", "").toString();
//        String fees = sharedPreferences.getString("text5", "").toString();

        deptTitle.setText(" Department Name : " + title/*titleDept*/);
        textView1.setText(full_name);
        textView2.setText(address);
        textView3.setText(contact);
        textView4.setText(fees);


        /*--------------------------------------------------Back to Doctor Details activity-------------------------------------------------------------------*/
        backToHomeDetails = findViewById(R.id.backToDoctorDetails);
        backToHomeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookAppointment.this, DoctorDetails.class);
//                i.putExtra("title", deptTitle.toString());

//            editor.putString("text2", textView1.toString());
//            editor.putString("text3", textView2.toString());
//            editor.putString("text4", textView3.toString());
//            editor.putString("text5", textView4.toString());


                /*------------------------------------------------------------------------------------------------*/
          /*  SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.putString("department",title);
            //To save our data with key and value

            editor.apply();*/
                /*------------------------------------------------------------------------------------------------*/
                startActivity(i);

            }
        });



        /*--------------------------------------------------define select data picker -------------------------------------------------------------------*/
        selectDateTxt = findViewById(R.id.selectDateText);
        initDatePicker();
        selectDateTxt.setOnClickListener(view -> datePickerDialog.show());


        /*--------------------------------------------------define select Time picker -------------------------------------------------------------------*/
        selectTimeTxt = findViewById(R.id.selectTimeText);
        initTimePicker();
        selectTimeTxt.setOnClickListener(view -> timePickerDialog.show());

        /*--------------------------------------------------Book Appointment-------------------------------------------------------------------*/
        bookAppointment = findViewById(R.id.bookAppointmentBtn);
        bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase db = new DataBase(getApplicationContext());
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                if (db.checkAppointmentExists(username, title/*titleDept*/ + "=>" + full_name, address, contact, selectDateTxt.getText().toString(), selectTimeTxt.getText().toString()) == 1) {
                    Toast.makeText(BookAppointment.this, "Appointment already Booked", Toast.LENGTH_SHORT).show();
                } else {
                    db.addOrder(username, title/*titleDept*/ + "=>" + full_name, address, contact, 0, selectDateTxt.getText().toString(), selectTimeTxt.getText().toString(), Float.parseFloat(fees), "appointment");
                    Toast.makeText(BookAppointment.this, "Your appointment is done successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BookAppointment.this, HomePage.class));
                }
            }
        });

    }

    /*--------------------------------------------------This is method for the Date picker-------------------------------------------------------------------*/
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                selectDateTxt.setText(i2 + "/" + i1 + "/" + i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = android.R.style.Theme_Wallpaper;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }

    /*--------------------------------------------------This is method for the Time picker-------------------------------------------------------------------*/
    private void initTimePicker() {

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                selectTimeTxt.setText(i + ":" + i1);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);
        int am_pm = cal.get(Calendar.AM_PM);
        int style = android.R.style.Theme_Wallpaper;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, false);

    }
}