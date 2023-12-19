package com.example.healthcareproject.Articles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.R;

public class HealthArticlesDetails extends AppCompatActivity {

    TextView articleName;
    ImageView backToHome, articleImg, artImg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);

        articleName = findViewById(R.id.articleNameTxt);
        articleImg=findViewById(R.id.articleDetailsImg);
        artImg =findViewById(R.id.articleImg);
        Intent intent = getIntent();
        if (intent != null) {
            articleImg.setImageResource(intent.getIntExtra("imgArt", 0));
            articleName.setText(intent.getStringExtra("titleArt"));
            int additionalImageResource = intent.getIntExtra("desImg", 0);
            artImg.setImageResource(additionalImageResource);

        }

        backToHome=findViewById(R.id.backToHA);
        backToHome.setOnClickListener(view -> startActivity(new Intent(HealthArticlesDetails.this, HealthArticles.class)));
    }
}