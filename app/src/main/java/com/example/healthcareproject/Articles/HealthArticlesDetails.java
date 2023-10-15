package com.example.healthcareproject.Articles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthcareproject.R;

public class HealthArticlesDetails extends AppCompatActivity {

    TextView articleName,articleDes;
    ImageView backToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);
        articleName=findViewById(R.id.articleNameTxt);
        articleDes=findViewById(R.id.articleDetailsTxt);
        Intent intent = getIntent();
        if (intent != null) {
            articleName.setText(intent.getStringExtra("text1"));

            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String[] des = bundle.getStringArray("text2");

                // Check if the array is not null and has content
                if (des != null && des.length > 0) {
                    StringBuilder descriptionBuilder = new StringBuilder();
                    for (String desc : des) {
                        descriptionBuilder.append(desc).append("\n");  // Add each description and a newline
                    }
                    // Set the combined descriptions in the TextView
                    articleDes.setText(descriptionBuilder.toString());
                }
            }
        }

        backToHome=findViewById(R.id.backToHA);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticlesDetails.this, HealthArticles.class));
            }
        });


    }
}