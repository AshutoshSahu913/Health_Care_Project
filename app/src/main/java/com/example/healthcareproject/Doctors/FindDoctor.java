package com.example.healthcareproject.Doctors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcareproject.Adapter.DoctorAdapter;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.Model.DoctorModel;
import com.example.healthcareproject.R;

import java.util.ArrayList;

public class FindDoctor extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DoctorModel> list;
    DoctorAdapter doctorAdapter;
    ImageView backToHome;

    TextView titleFD;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
//        Intent i=getIntent();
//        String title=i.getStringExtra("title");
//        titleFD = findViewById(R.id.titleFD);
//        titleFD.setText(title);
        /*--------------------------------------------------------------Go back to Home Activity---------------------------------------------------------------------------------------*/
        backToHome = findViewById(R.id.backToHome);
        backToHome.setOnClickListener(view -> {
            startActivity(new Intent(FindDoctor.this, HomePage.class));
        });

        /*--------------------------------------------------------------Go back to Home Activity---------------------------------------------------------------------------------------*/
        list = new ArrayList<>();
        list.add(new DoctorModel(R.drawable.physician, "Family Physicians"));
        list.add(new DoctorModel(R.drawable.dentist, "Dentists"));
        list.add(new DoctorModel(R.drawable.nutritionist, "Dietitian"));
        list.add(new DoctorModel(R.drawable.surgeon, "Surgeon"));
        list.add(new DoctorModel(R.drawable.cardiologist, "Cardiologists"));
        list.add(new DoctorModel(R.drawable.dermatologist, "Dermatologists"));
        list.add(new DoctorModel(R.drawable.neurologist, "Neurologists"));
        list.add(new DoctorModel(R.drawable.radiologists, "Radiologists"));

        recyclerView=findViewById(R.id.rvDoctors);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        doctorAdapter = new DoctorAdapter(list, getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(doctorAdapter);

    }
}