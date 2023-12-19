package com.example.healthcareproject.Doctors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

public class BookAppointment extends AppCompatActivity {

    /*--------------------------------------------------Initialize variable-------------------------------------------------------------------*/
    TextView textView1, textView2, textView3, textView4;
    TextView deptTitle;
    ImageView backToHomeDetails;
    TextView selectDateTxt, selectTimeTxt;
    Button bookAppointment;

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
        backToHomeDetails.setOnClickListener(view -> {
            /*Intent i = new Intent(BookAppointment.this, HomePage.class);
            startActivity(i);*/
            onBackPressed();
        });

        /*--------------------------------------------------define select data picker -------------------------------------------------------------------*/
        selectDateTxt = findViewById(R.id.selectDateText);
        initDatePicker();


        /*--------------------------------------------------define select Time picker -------------------------------------------------------------------*/
        selectTimeTxt = findViewById(R.id.selectTimeText);
        initTimePicker();

        /*--------------------------------------------------Book Appointment-------------------------------------------------------------------*/
        bookAppointment = findViewById(R.id.bookAppointmentBtn);
        bookAppointment.setOnClickListener(view -> {
            DataBase db = new DataBase(getApplicationContext());
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");
            if (db.checkAppointmentExists(username, title/*titleDept*/ + "=>" + full_name, address, contact, selectDateTxt.getText().toString(), selectTimeTxt.getText().toString()) == 1) {
                Toast.makeText(BookAppointment.this, "Appointment already Booked", Toast.LENGTH_SHORT).show();
            } else {
                assert fees != null;
                db.addOrder(username, title/*titleDept*/ + "=>" + full_name, address, contact, 0, selectDateTxt.getText().toString(), selectTimeTxt.getText().toString(), Float.parseFloat(fees), "appointment");
                Toast.makeText(BookAppointment.this, "Your appointment is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookAppointment.this, HomePage.class));
            }
        });

    }

    /*--------------------------------------------------This is method for the Date picker-------------------------------------------------------------------*/
    private void initDatePicker() {

        // now create instance of the material date picker
        // builder make sure to add the "datePicker" which
        // is normal material date picker which is the first
        // type of the date picker in material design date
        // picker
        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();

        // now define the properties of the
        // materialDateBuilder that is title text as SELECT A DATE
        materialDateBuilder.setTitleText("SELECT A APPOINTMENT DATE");

        // now create the instance of the material date
        // picker
        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        // handle select date button which opens the
        // material design date picker
        selectDateTxt.setOnClickListener(
                v -> {
                    // getSupportFragmentManager() to
                    // interact with the fragments
                    // associated with the material design
                    // date picker tag is to get any error
                    // in logcat
                    materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                });

        // now handle the positive button click from the
        // material design date picker
        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {

                        // if the user clicks on the positive
                        // button that is ok button update the
                        // selected date
                        selectDateTxt.setText(/*"Selected Date is : "*/  materialDatePicker.getHeaderText());
                        // in the above statement, getHeaderText
                        // is the selected date preview from the
                        // dialog
                    }
                });
    }

    /*--------------------------------------------------This is method for the Time picker-------------------------------------------------------------------*/
    private void initTimePicker() {
        selectTimeTxt.setOnClickListener(view -> {
            // instance of MDC time picker
            MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                    // set the title for the alert dialog
                    .setTitleText("SELECT YOUR APPOINTMENT TIMING")
                    // set the default hour for the
                    // dialog when the dialog opens
                    .setHour(12)
                    // set the default minute for the
                    // dialog when the dialog opens
                    .setMinute(10)
                    // set the time format
                    // according to the region
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .build();

            materialTimePicker.show(getSupportFragmentManager(), "MainActivity");

            // on clicking the positive button of the time picker
            // dialog update the TextView accordingly
            materialTimePicker.addOnPositiveButtonClickListener(v -> {
                int pickedHour = materialTimePicker.getHour();
                int pickedMinute = materialTimePicker.getMinute();

                // check for single digit hour and minute
                // and update TextView accordingly
                String formattedTime;
                if (pickedHour > 12) {
                    formattedTime = (pickedMinute < 10) ?
                            (materialTimePicker.getHour() - 12) + ":0" + materialTimePicker.getMinute() + " pm" :
                            (materialTimePicker.getHour() - 12) + ":" + materialTimePicker.getMinute() + " pm";
                } else if (pickedHour == 12) {
                    formattedTime = (pickedMinute < 10) ?
                            materialTimePicker.getHour() + ":0" + materialTimePicker.getMinute() + " pm" :
                            materialTimePicker.getHour() + ":" + materialTimePicker.getMinute() + " pm";
                } else if (pickedHour == 0) {
                    formattedTime = (pickedMinute < 10) ?
                            (12) + ":0" + materialTimePicker.getMinute() + " am" :
                            (12) + ":" + materialTimePicker.getMinute() + " am";
                } else {
                    formattedTime = (pickedMinute < 10) ?
                            materialTimePicker.getHour() + ":0" + materialTimePicker.getMinute() + " am" :
                            materialTimePicker.getHour() + ":" + materialTimePicker.getMinute() + " am";
                }

                // then update the preview TextView
                selectTimeTxt.setText(formattedTime);
            });
        });
    }
}