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
import com.example.healthcareproject.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class RegistrationPage extends AppCompatActivity {

    TextInputEditText edUsername, edPassword, edEmail, edConfirmPassword;
    Button registerBtn;
    TextView loginHere;
    CheckBox checkBox2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        edUsername = findViewById(R.id.editUsername);
        edPassword = findViewById(R.id.editPassword);
        edEmail = findViewById(R.id.editEmail);
        edConfirmPassword = findViewById(R.id.editRePassword);
        registerBtn = findViewById(R.id.registerBtn);
        loginHere = findViewById(R.id.loginHere);
        checkBox2=findViewById(R.id.showPasswordCheckbox2);
        registerBtn.setOnClickListener(view -> {
            String userName = Objects.requireNonNull(edUsername.getText()).toString();
            String email = Objects.requireNonNull(edEmail.getText()).toString();
            String password = Objects.requireNonNull(edPassword.getText()).toString();
            String confirm = Objects.requireNonNull(edConfirmPassword.getText()).toString();


            checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                // Show or hide the password based on the checkbox state
                if (isChecked) {edPassword.setTransformationMethod(null);
//                    edConfirmPassword.setTransformationMethod(null);
                    // Show password
                } else {
                    edConfirmPassword.setTransformationMethod(new PasswordTransformationMethod()); // Hide password
//                    edConfirmPassword.setTransformationMethod(new PasswordTransformationMethod()); // Hide password
                }
            });

            // create DATABASE Objects
            DataBase db=new DataBase(getApplicationContext());
            if (userName.length() == 0 && password.length() == 0 && email.length() == 0 && confirm.length() == 0) {
                edUsername.setError("");
                edEmail.setError("");
                edPassword.setError("");
                edConfirmPassword.setError("");
            } else if (userName.length() == 0 || password.length() == 0 || email.length() == 0 || confirm.length() == 0) {
                if (userName.length() == 0) {
                    edUsername.setError("");
                }
                if (password.length() == 0) {
                    edPassword.setError("");
                }
                if (email.length() == 0) {
                    edEmail.setError("");
                } else {
                    edConfirmPassword.setError("");
                }
            } else {
                if (password.compareTo(confirm) == 0) {
                    if (isValid(password)) {
                        db.register(userName,email,password);
                        Toast.makeText(this, "Record Inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationPage.this, LoginPage.class));
                    } else {
                        Toast.makeText(this, "pass must contain at least 8 characters, having letter, digit and special symbol", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginHere.setOnClickListener(view -> {
            Intent i = new Intent(RegistrationPage.this, LoginPage.class);
            startActivity(i);
        });
    }

    /*--------------------------------------------------------------This is Check the Password corre---------------------------------------------------------------------------------------*/
    private boolean isValid(String passwordHere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordHere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordHere.length(); p++) {
                if (Character.isLetter(passwordHere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordHere.length(); r++) {
                if (Character.isDigit(passwordHere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordHere.length(); s++) {
                char c = passwordHere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            return f1 == 1 && f2 == 1 && f3 == 1;
        }
    }
}