package com.example.healthcareproject.Medicine;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.healthcareproject.Cart.MyCartLab;
import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.LabTest.BookLabTest;
import com.example.healthcareproject.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MyCartMedicine extends AppCompatActivity {
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView totalCost, dateBM, timeBM;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    Button buyBtnBMC;
    ImageView backBtnBM;
    TextView tvBM;

    ListView listView;
    private String[][] packages = {};

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart_medicine);
        dateBM = findViewById(R.id.selectDeliveryDateBM);
        timeBM = findViewById(R.id.selectDeliveryTimeBM);
        buyBtnBMC = findViewById(R.id.buyBtnBM);
        listView = findViewById(R.id.lvBMC);
        tvBM = findViewById(R.id.noDataBM);

        /*--------------------------------------------------Shared preferences-------------------------------------------------------------------*/
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();


        /*==============================Back to labTest ===================================================*/
        backBtnBM = findViewById(R.id.backToBM);
        backBtnBM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyCartMedicine.this, BuyMedicine.class));
            }
        });
        /*--------------------------------------------------This Date picker-------------------------------------------------------------------*/
        initDatePicker();
        dateBM.setOnClickListener(view -> datePickerDialog.show());

        /*--------------------------------------------------This Time picker-------------------------------------------------------------------*/
        initTimePicker();
        timeBM.setOnClickListener(view -> timePickerDialog.show());
        /*--------------------------------------------------Create object of Database-------------------------------------------------------------------*/
        DataBase db = new DataBase(this);
        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username, "medicine");
        if (dbData.size() == 0) {

            tvBM.setVisibility(View.VISIBLE);
        } else {
//        Toast.makeText(this, "" + dbData, Toast.LENGTH_SHORT).show();
            tvBM.setVisibility(View.GONE);
            /*--------------------------------------------------This is for listView-------------------------------------------------------------------*/
            list = new ArrayList<>();
            packages = new String[dbData.size()][];
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
            totalCost = findViewById(R.id.totalCostBM);
            totalCost.setText(""+totalAmount);

            for (int j = 0; j < dbData.size(); j++) {
                item = new HashMap<>();
                item.put("line1", packages[j][0]);
                item.put("line2", packages[j][4]);
                list.add(item);
            }
            sa = new SimpleAdapter(this, list,
                    R.layout.lab_test_item_list,
                    new String[]{"line1", "line2"},
                    new int[]{R.id.line_x, R.id.line_y});
            listView.setAdapter(sa);

            /*--------------------------------------------------This is for Buy products-------------------------------------------------------------------*/
            buyBtnBMC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MyCartMedicine.this, BookMedicine.class);
                    i.putExtra("price", totalCost.getText());
                    i.putExtra("date", dateBM.getText());
                    i.putExtra("time", timeBM.getText());
                    startActivity(i);
                }
            });
        }
    }

    /*--------------------------------------------------This is method for the Date picker-------------------------------------------------------------------*/
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 + 1;
                dateBM.setText(i2 + "/" + i1 + "/" + i);
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
                timeBM.setText(i + ":" + i1);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = android.R.style.Theme_Wallpaper;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, false);

    }
}