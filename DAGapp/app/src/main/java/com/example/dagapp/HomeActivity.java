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
        Intent intent = new Intent(HomeActivity.this, DepartmentInfoActivity.class);
        startActivity(intent);
    }

    public void onEventsClicked(View view) {
        // Navigate to Events page
    }

    public void onFinanceClicked(View view) {
        // Navigate to Finance page
        Intent intent = new Intent(HomeActivity.this, FinanceMainActivity.class);
        startActivity(intent);
    }

    public void onReminderClicked(View view) {
        // Navigate to Reminder page
    }

    public void onInventoryClicked(View view) {
        // Navigate to Inventory page
    }

    public void onSettingsClicked(View view) {
        // Navigate to Settings page
        Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

}