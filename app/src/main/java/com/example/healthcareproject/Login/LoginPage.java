package com.example.healthcareproject.Login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcareproject.DataBase.DataBase;
import com.example.healthcareproject.HomePage;
import com.example.healthcareproject.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginPage extends AppCompatActivity {

    //initialize variable
    TextInputEditText edit_userName, edit_password;
    Button login_btn;
    TextView register_tv;
    private CheckBox showPasswordCheckbox;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        //Define variable
        edit_userName = findViewById(R.id.editUsername);
        edit_password = findViewById(R.id.editPassword);
        login_btn = findViewById(R.id.loginBtn);
        register_tv = findViewById(R.id.register);
        DataBase db = new DataBase(this);

        /*--------------------------------------------------------------Show password ---------------------------------------------------------------------------------------*/
        showPasswordCheckbox = findViewById(R.id.showPasswordCheckbox);

        showPasswordCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Show or hide the password based on the checkbox state
            if (isChecked) {
                edit_password.setTransformationMethod(null); // Show password
            } else {
                edit_password.setTransformationMethod(new PasswordTransformationMethod()); // Hide password
            }
        });

        login_btn.setOnClickListener(view -> {
            /*--------------------------------------------------------------This check the editText is empty or not---------------------------------------------------------------------------------------*/
            String userName = Objects.requireNonNull(edit_userName.getText()).toString();
            String password = Objects.requireNonNull(edit_password.getText()).toString();
            if (userName.length() == 0 && password.length() == 0) {
                edit_userName.setError("");
                edit_password.setError("");
            } else if (userName.length() == 0 || password.length() == 0) {
                if (userName.length() == 0) {
                    edit_userName.setError("");
                } else {
                    edit_password.setError("");
                }
            } else {
                if (db.login(userName, password) == 1) {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    /*--------------------------------------------------------------Using SharedPreferences for store a userName ---------------------------------------------------------------------------------------*/
                    SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("username",userName);
                    //To save our data with key and value
                    editor.apply();

                    Intent i = new Intent(LoginPage.this, HomePage.class);
                    startActivity(i);
                } else {
                    if (db.userNameCheck(userName)!=1){
                        Toast.makeText(this, "Please register yourself username doesn't exists ", Toast.LENGTH_SHORT).show();
                    }
                        Toast.makeText(this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();

                }
            }
        });
        /*--------------------------------------------------------------Go to Register Activity---------------------------------------------------------------------------------------*/
        register_tv.setOnClickListener(view -> {
            Intent i = new Intent(LoginPage.this, RegistrationPage.class);
            startActivity(i);
        });

    }
}