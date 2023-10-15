package com.example.healthcareproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class OrderDetails extends AppCompatActivity {

    ImageView backToHome;
    TextView titleOD;
    SimpleAdapter sa;
    ArrayList<HashMap<String, String>> list;
    HashMap<String, String> item;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        /*--------------------------------------------------This is for find Title-------------------------------------------------------------------*/
        titleOD = findViewById(R.id.titleOD);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        titleOD.setText(title);


        /*--------------------------------------------------This is for Back to Home-------------------------------------------------------------------*/
        backToHome = findViewById(R.id.backToHomeOD);
        backToHome.setOnClickListener(view -> startActivity(new Intent(OrderDetails.this, HomePage.class)));

        /*--------------------------------------------------This is for Show all orders-------------------------------------------------------------------*/
        DataBase db = new DataBase(this);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        ArrayList dbData = db.getOrderData(username);

        String[][] orderDetails = new String[dbData.size()][];

        for (int i = 0; i < orderDetails.length; i++) {
            orderDetails[i] = new String[8];
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(Pattern.quote("$"));
            orderDetails[i][0] = "Customer Name: "+strData[0];
            orderDetails[i][1] = "Address : "+strData[1];
            orderDetails[i][2]=strData[3];
            if (strData[7].compareTo("medicine") == 0) {
                orderDetails[i][3] =""+ strData[4];
            } else {
                orderDetails[i][3] = "Delivered : " + strData[4] + " " + strData[5];
            }
            orderDetails[i][2] = "Total Amount : ₹" + strData[6];
            orderDetails[i][4] = "Order Type : "+strData[7];
        }

        list = new ArrayList<>();
        for (String[] orderDetail : orderDetails) {
            item = new HashMap<>();
            item.put("line1", orderDetail[0]);
            item.put("line2", orderDetail[1]);
            item.put("line3", orderDetail[2]);
            item.put("line4", orderDetail[3]);
            item.put("line5", orderDetail[4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewOD);
        lst.setAdapter(sa);

    }
}