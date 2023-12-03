package com.example.dagapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to handle the click event
    public void onSignUpTextClicked(View view) {
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    public void onLoginButtonClicked(View view) {
        // This is where you would normally verify the credentials
        // For now, we'll just go straight to the home page

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}