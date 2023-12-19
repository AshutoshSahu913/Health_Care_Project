package com.example.healthcareproject.Articles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcareproject.Adapter.ArticleAdapter;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.Model.ArticleModel;
import com.example.healthcareproject.R;

import java.util.ArrayList;

public class HealthArticles extends AppCompatActivity {


    //    ArrayList list;
//    SimpleAdapter sa;
//    ListView lstView;
    RecyclerView recyclerView;
    ArticleAdapter articleAdapter;
    ArrayList<ArticleModel> lst;

    private final String[][] health_details = {
            {"Walking Daily", "Click more Details", ""},
            {"Home care of COVID-19", "Click more Details", ""},
            {"Stop Smoking", "Click more Details", ""},
            {"Menstrual Cramps", "Click more Details", ""},
            {"Healthy Gut", "Click more Details", ""},
            {"Home Workouts", "Click more Details", ""},

    };
    //    HashMap<String, String> item;
    ImageView backToHome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);
        backToHome = findViewById(R.id.backToHomeHA);
        backToHome.setOnClickListener(view -> startActivity(new Intent(HealthArticles.this, HomePage.class)));

        /*--------------------------------------Set The data form list View  ----------------------------------------------------------------------------------------*/

        recyclerView = findViewById(R.id.rvArticle);
        lst = new ArrayList<>();
        lst.add(new ArticleModel(R.drawable.running, "Walking Daily"));
        lst.add(new ArticleModel(R.drawable.covid, "Home care of COVID-19"));
        lst.add(new ArticleModel(R.drawable.stop, "Stop Smoking"));
        lst.add(new ArticleModel(R.drawable.cramp, "Menstrual Cramps"));
        lst.add(new ArticleModel(R.drawable.healty, "Healthy Gut"));
        lst.add(new ArticleModel(R.drawable.home, "Home Workouts"));
        articleAdapter = new ArticleAdapter(lst, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(articleAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}