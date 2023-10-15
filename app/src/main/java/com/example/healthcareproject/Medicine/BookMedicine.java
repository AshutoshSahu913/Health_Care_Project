package com.example.healthcareproject.Medicine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class BookMedicine extends AppCompatActivity {
    TextInputEditText fullNameBMC, addressBMC, pinCodeBMC, contactNoBMC;
    Button bookMedicine;
    ImageView backToBMC;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_medicine);
        fullNameBMC = findViewById(R.id.editFullNameBMC);
        addressBMC = findViewById(R.id.editAddressBMC);
        pinCodeBMC = findViewById(R.id.editPinCodeBMC);
        contactNoBMC = findViewById(R.id.editContactNoBMC);

        bookMedicine = findViewById(R.id.bookMedicineBtn);
        backToBMC = findViewById(R.id.backToBMC);

        Intent i = getIntent();
        String price = i.getStringExtra("price");/*.toString().split(java.util.regex.Pattern.quote("#"));*/
        String date = i.getStringExtra("date");
        String time = i.getStringExtra("time");

        bookMedicine.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");
            DataBase db = new DataBase(getApplicationContext());
            assert price != null;
            db.addOrder(username, Objects.requireNonNull(fullNameBMC.getText()).toString(), Objects.requireNonNull(addressBMC.getText()).toString(), Objects.requireNonNull(contactNoBMC.getText()).toString(), Integer.parseInt(Objects.requireNonNull(pinCodeBMC.getText()).toString()), date, time, Float.parseFloat(price), "medicine");
            db.removeCart(username, "medicine");

            Toast.makeText(BookMedicine.this, "Your Booking is Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), HomePage.class));

        });
        backToBMC.setOnClickListener(view -> startActivity(new Intent(BookMedicine.this, MyCartMedicine.class)));
    }
}