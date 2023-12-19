package com.example.healthcareproject.LabTest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.ArrayList;
import java.util.HashMap;

public class MyCartLab extends AppCompatActivity {

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView totalCost, date, time;
    Button buyBtn;
    ImageView backBtn;
    TextView tv;

    ListView listView;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart_lab);

        date = findViewById(R.id.selectDeliveryDate);
        time = findViewById(R.id.selectDeliveryTime);
        buyBtn = findViewById(R.id.buyBtn);
        listView = findViewById(R.id.myCartLabListView);
        tv = findViewById(R.id.noData);

        /*--------------------------------------------------Shared preferences-------------------------------------------------------------------*/
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");


        /*==============================Back to labTest ===================================================*/
        backBtn = findViewById(R.id.backToLabTest);
        backBtn.setOnClickListener(view -> startActivity(new Intent(MyCartLab.this, LabTest.class)));
        /*--------------------------------------------------This Date picker-------------------------------------------------------------------*/
        initDatePicker();

        /*--------------------------------------------------This Time picker-------------------------------------------------------------------*/
        initTimePicker();

        /*--------------------------------------------------Create object of Database-------------------------------------------------------------------*/
        DataBase db = new DataBase(this);
        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username, "lab");
        if (dbData.size() == 0) {

            tv.setVisibility(View.VISIBLE);
        } else {
//        Toast.makeText(this, "" + dbData, Toast.LENGTH_SHORT).show();
            tv.setVisibility(View.GONE);
            /*--------------------------------------------------This is for listView-------------------------------------------------------------------*/
            list = new ArrayList<>();
            String[][] packages = new String[dbData.size()][];
            for (int i = 0; i < packages.length; i++) {
                packages[i] = new String[8];
            }
            for (int i = 0; i < dbData.size(); i++) {
                String arrDta = dbData.get(i).toString();
                String[] strData = arrDta.split(java.util.regex.Pattern.quote("#"));
                packages[i][0] = strData[0];
                packages[i][4] = strData[1];
                totalAmount = totalAmount + Float.parseFloat(strData[1]);

            }
            totalCost = findViewById(R.id.totalCost);
            totalCost.setText(totalAmount+"");

            for (int j = 0; j < dbData.size(); j++) {
                item = new HashMap<>();
                item.put("line1", packages[j][0]);
                item.put("line2", "₹" + packages[j][4]);
                list.add(item);
            }
            sa = new SimpleAdapter(this, list,
                    R.layout.lab_test_item_list,
                    new String[]{"line1", "line2"},
                    new int[]{R.id.line_x, R.id.line_y});
            listView.setAdapter(sa);

            /*--------------------------------------------------This is for Buy products-------------------------------------------------------------------*/
            buyBtn.setOnClickListener(view -> {
                Intent i = new Intent(MyCartLab.this, BookLabTest.class);
                i.putExtra("price", totalCost.getText());
                i.putExtra("date", date.getText());
                i.putExtra("time", time.getText());
                startActivity(i);
            });
        }
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
        materialDateBuilder.setTitleText("SELECT A LAB TEST DATE");

        // now create the instance of the material date
        // picker
        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        // handle select date button which opens the
        // material design date picker
        date.setOnClickListener(
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
                selection -> {

                    // if the user clicks on the positive
                    // button that is ok button update the
                    // selected date
                    date.setText(/*"Selected Date is : "*/  materialDatePicker.getHeaderText());
                    // in the above statement, getHeaderText
                    // is the selected date preview from the
                    // dialog
                });
    }

    /*--------------------------------------------------This is method for the Time picker-------------------------------------------------------------------*/
    private void initTimePicker() {
        time.setOnClickListener(view -> {
            // instance of MDC time picker
            MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                    // set the title for the alert dialog
                    .setTitleText("SELECT YOUR LAB TEST TIMING")
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
                time.setText(formattedTime);
            });
        });
    }

}