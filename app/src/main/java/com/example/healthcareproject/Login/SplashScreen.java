package com.example.healthcareproject.Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;

public class SplashScreen extends AppCompatActivity {
    private static final long SPLASH_DELAY = 3000;

    ImageView splashImg, splashBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashImg = findViewById(R.id.splashImg);
        splashBack = findViewById(R.id.splashBack);
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 10f,
                1f, 10f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(1800);
        scaleAnimation.setFillAfter(true);
        splashBack.startAnimation(scaleAnimation);

        DataBase db = new DataBase(this);
        String username = db.getUsername();

        new Handler().postDelayed(() -> {
            if (username == null) {
                startActivity(new Intent(SplashScreen.this, LoginPage.class));
            } else {
                Intent intent = new Intent(SplashScreen.this, HomePage.class);
                startActivity(intent);
            }
            finish();
        }, SPLASH_DELAY);
        db.close();
    }
}