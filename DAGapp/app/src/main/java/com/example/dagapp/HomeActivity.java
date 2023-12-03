package com.example.dagapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onDepartmentsClicked(View view) {
        // Navigate to Departments click event
    }

    public void onEventsClicked(View view) {
        // Navigate to Events page
    }

    public void onFinanceClicked(View view) {
        // Navigate to Finance page
    }

    public void onReminderClicked(View view) {
        // Navigate to Reminder page
    }

    public void onInventoryClicked(View view) {
        // Navigate to Inventory page
    }

    public void onSettingsClicked(View view) {
        // Navigate to Settings click event
    }

}