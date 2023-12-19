package com.example.healthcareproject.LabTest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.R;

public class LabTestDetails extends AppCompatActivity {
    /*--------------------------------------------------Initialize variable-------------------------------------------------------------------*/
    TextView pName, pDetails, pFees;
    Button addToCart;
    ImageView backToLabTest;

    @Nullable
    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        /*--------------------------------------------------Define variable-------------------------------------------------------------------*/
        pName = findViewById(R.id.packageNameTxt);
        pDetails = findViewById(R.id.packageDetailsTxt);
        pFees = findViewById(R.id.packageFeesTxt);


        /*--------------------------------------------------Get Intent data -------------------------------------------------------------------*/
        Intent i = getIntent();
        pName.setText(i.getStringExtra("text1"));
        pDetails.setText(i.getStringExtra("text2"));
        pFees.setText(i.getStringExtra("text3") + "/-");

        /*--------------------------------------------------back to Lab Test -------------------------------------------------------------------*/
        backToLabTest = findViewById(R.id.backToLT);
        backToLabTest.setOnClickListener(view -> {
            startActivity(new Intent(this, LabTest.class));
        });


        /*--------------------------------------------------Add to cart -------------------------------------------------------------------*/
        addToCart = findViewById(R.id.addToCartBtn);
        addToCart.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "").toString();
            String product = pName.getText().toString();
            float price = Float.parseFloat(i.getStringExtra("text3").toString());

            DataBase db = new DataBase(getApplicationContext());

            if (db.checkCart(username, product) == 1) {
                Toast.makeText(this, "Product already Added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestDetails.this, MyCartLab.class));

            } else {
                db.addCart(username, product, price, "lab");
                Toast.makeText(this, "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MyCartLab.class));
            }
        });
    }

}