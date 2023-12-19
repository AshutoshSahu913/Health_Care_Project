package com.example.healthcareproject.LabTest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTest extends AppCompatActivity {

    ImageView backToHome, goToCart;
    private final String[][] packages = {
            {"Basic Checkup", "199"},
            {"Comprehensive Checkup", "399"},
            {"Executive Checkup", "599"},
            {"Premium Checkup", "899"},
            {"Full Body Checkup ", "999"},
            {"Blood Glucose Fasting", "299"},
            {"Covid-19 Antibody", "799"},
            {"Thyroid Check ", "399"},
            {"Immunity Check ", "699"},
            {"Women's Health Checkup", "299"},
            {"Men's Health Checkup", "349"},
            {"Heart Health Checkup", "499"}
    };

    private final String[] package_details = {
            "Blood Pressure Measurement\nComplete Blood Count",
            "Blood Glucose Fasting\nLipid Profile\nLiver Function Test\nComplete Blood Count",
            "Blood Glucose Fasting\nLipid Profile\nLiver Function Test\nKidney Function Test\nThyroid Profile",
            "Blood Glucose Fasting\nLipid Profile\nLiver Function Test\nKidney Function Test\nThyroid Profile\nVitamin D Test",
            "Blood Glucose Fasting\n" + "Complete Hemogram\n" + "HbA1c\n" + "Iron Studies\n" + "Kidney Function Test\n" + "LDH Lactate Dehydrogenase, Serum\n" + "Lipid Profile\n" + "Liver Function Test",
            "Blood Glucose Fasting",
            "COVID-19 Antibody - IgG",
            "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
            "Complete Hemogram\n" + "CRP (C Reactive Protein) Quantitative, Serum\n" + "Iron Studies\n" + "Kidney Function Test\n" + "Vitamin D Total-25 Hydroxy\n" + "Liver Function Test\n" + "Lipid Profile",
            "Blood Glucose Fasting\nPap Smear\nMammogram\nBone Density Test",
            "Blood Glucose Fasting\nProstate-Specific Antigen (PSA) Test\nTestosterone Levels",
            "Blood Pressure Measurement\nEKG\nStress Test\nEchocardiogram"
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        /*--------------------------------------Go back to Home activity ----------------------------------------------------------------------------------------*/
        backToHome = findViewById(R.id.backToHomeLT);
        backToHome.setOnClickListener(view -> startActivity(new Intent(LabTest.this, HomePage.class)));

        /*--------------------------------------Go to Lab Cart activity ----------------------------------------------------------------------------------------*/
        goToCart = findViewById(R.id.goToCartBtn);
        goToCart.setOnClickListener(view -> {
            Intent i = new Intent(LabTest.this, MyCartLab.class);
            startActivity(i);
        });

        /*--------------------------------------Set The data form list View  ----------------------------------------------------------------------------------------*/
        listView = findViewById(R.id.labTestList);
        list = new ArrayList<>();
        for (String[] aPackage : packages) {
            item = new HashMap<>();
            item.put("line1", aPackage[0]);
            item.put("line2", "Total Cost : " + aPackage[1]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.lab_test_item_list,
                new String[]{"line1", "line2"},
                new int[]{R.id.line_x, R.id.line_y}
        );
        listView.setAdapter(sa);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it = new Intent(LabTest.this, LabTestDetails.class);
            it.putExtra("text1", packages[i][0]);
            it.putExtra("text2", package_details[i]);
            it.putExtra("text3", packages[i][1]);
            startActivity(it);
        });

    }
}
