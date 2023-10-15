package com.example.healthcareproject.LabTest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.Cart.MyCartLab;
import com.example.healthcareproject.R;
import com.google.android.material.textfield.TextInputEditText;

public class BookLabTest extends AppCompatActivity {

    TextInputEditText fullName,address,pinCode,contactNo;
    Button bookLabTest;
    ImageView backToLabCart;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lab_test);
        fullName=findViewById(R.id.editFullNameBLT);
        address=findViewById(R.id.editAddressBLT);
        pinCode=findViewById(R.id.editPinCodeBLT);
        contactNo=findViewById(R.id.editContactNoBLT);

        bookLabTest=findViewById(R.id.bookLabTestBtn);
        backToLabCart =findViewById(R.id.backToLabCart);

        Intent i=getIntent();
        String price=i.getStringExtra("price");/*.toString().split(java.util.regex.Pattern.quote("#"));*/
        String date=i.getStringExtra("date");
        String time=i.getStringExtra("time");

        bookLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");
                DataBase db = new DataBase(getApplicationContext());
                db.addOrder(username, fullName.getText().toString(), address.getText().toString(), contactNo.getText().toString(), Integer.parseInt(pinCode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(price.toString()), "lab");
                db.removeCart(username, "lab");

                Toast.makeText(BookLabTest.this, "Your Booking is Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), HomePage.class));

            }
        });
        backToLabCart.setOnClickListener(view ->startActivity(new Intent(BookLabTest.this, MyCartLab.class)));
    }

}