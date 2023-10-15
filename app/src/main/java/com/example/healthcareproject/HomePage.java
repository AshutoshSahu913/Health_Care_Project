package com.example.healthcareproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.healthcareproject.Articles.HealthArticles;
import com.example.healthcareproject.Doctors.FindDoctor;
import com.example.healthcareproject.LabTest.LabTest;
import com.example.healthcareproject.Login.LoginPage;
import com.example.healthcareproject.Medicine.BuyMedicine;

public class HomePage extends AppCompatActivity {

    TextView name, odTitle, bmTitle, haTitle;
    CardView logout, findDoctor, labTest, orderDetails, buyMedicine, healthArticles;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        /*--------------------------------------This is for set the username ----------------------------------------------------------------------------------------*/
        name = findViewById(R.id.userNameHome);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        name.setText(username);

        /*--------------------------------------This is for logout the app ----------------------------------------------------------------------------------------*/
        logout = findViewById(R.id.cardLogOut);
        logout.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomePage.this, LoginPage.class));
        });

        /*--------------------------------------This is for find doctor activity ----------------------------------------------------------------------------------------*/
        findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, FindDoctor.class);
            startActivity(intent);
        });

        /*--------------------------------------This is for find Lab test activity ----------------------------------------------------------------------------------------*/
        labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, LabTest.class);
            startActivity(intent);
        });

        /*--------------------------------------This is for Order Details activity ----------------------------------------------------------------------------------------*/
        orderDetails = findViewById(R.id.cardOrderDetails);
        odTitle = findViewById(R.id.orderDetails);
        orderDetails.setOnClickListener(view -> {
            Intent i = new Intent(HomePage.this, OrderDetails.class);
            i.putExtra("title", odTitle.getText());
            startActivity(i);
        });
        /*--------------------------------------This is for Buy Medicine activity ----------------------------------------------------------------------------------------*/
        buyMedicine = findViewById(R.id.cardBuyMedicine);

        buyMedicine.setOnClickListener(view -> {
            Intent i = new Intent(HomePage.this, BuyMedicine.class);
            bmTitle = findViewById(R.id.titleBM);
            i.putExtra("title", bmTitle.getText());
            startActivity(i);
        });

        /*--------------------------------------This is for Health Articles activity ----------------------------------------------------------------------------------------*/
        healthArticles = findViewById(R.id.cardHealthArticles);

        healthArticles.setOnClickListener(view -> {
            Intent i = new Intent(HomePage.this, HealthArticles.class);
            haTitle = findViewById(R.id.titleHA);
            i.putExtra("title", haTitle.getText());
            startActivity(i);
        });

    }
}