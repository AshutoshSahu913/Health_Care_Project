package com.example.healthcareproject.Medicine;

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
import com.example.healthcareproject.R;

import java.util.Objects;

public class BuyMedicineDetails extends AppCompatActivity {

    TextView medName, medDes, medPrice;
    Button addToCart;
    ImageView backToBM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        medName=findViewById(R.id.medicineNameTxt);
        medDes=findViewById(R.id.medicineDetailsTxt);
        medPrice=findViewById(R.id.medicinePrice);
        /*--------------------------------------------------Get Intent data -------------------------------------------------------------------*/
        Intent i = getIntent();
        medName.setText(i.getStringExtra("text1"));
        medDes.setText(i.getStringExtra("text2"));
        medPrice.setText(i.getStringExtra("text3"));

        /*--------------------------------------------------back to Buy Medicine -------------------------------------------------------------------*/
        backToBM = findViewById(R.id.backToBM);
        backToBM.setOnClickListener(view -> startActivity(new Intent(this, BuyMedicine.class)));


        /*--------------------------------------------------Add to cart -------------------------------------------------------------------*/
        addToCart = findViewById(R.id.addToCartBtnBMD);
        addToCart.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");
            String medicine = medName.getText().toString();
            float price = Float.parseFloat(Objects.requireNonNull(i.getStringExtra("text3")));

            DataBase db = new DataBase(getApplicationContext());

            if (db.checkCart(username, medicine) == 1) {
                Toast.makeText(this, "Medicine already Added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineDetails.this, MyCartMedicine.class));

            } else {
                db.addCart(username, medicine, price, "medicine");
                Toast.makeText(this, "Medicine Inserted to Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MyCartMedicine.class));
            }
        });
    }
}