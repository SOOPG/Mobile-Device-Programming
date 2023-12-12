package com.example.dagapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView userNameTextView;
    private TextView userRoleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize TextViews
        userNameTextView = findViewById(R.id.user_name);
        userRoleTextView = findViewById(R.id.user_title);
        // Load the user settings
        loadUserSettings();
    }

    protected void onResume() {
        super.onResume();
        // Load the user settings again in case they were changed in SettingsActivity
        loadUserSettings();
    }

    private void loadUserSettings() {
        SharedPreferences preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
        String userName = preferences.getString("UserName", "Soo Min Hao"); // Default value if none found
        String userRole = preferences.getString("UserRole", "Vice Pres."); // Default value if none found

        // Set the user settings to the TextViews
        userNameTextView.setText(userName);
        userRoleTextView.setText(userRole);
    }

    public void onDepartmentsClicked(View view) {
        Intent intent = new Intent(HomeActivity.this, DepartmentInfoActivity.class);
        startActivity(intent);
    }

    public void onEventsClicked(View view) {
        // Navigate to Events page
        Intent intent = new Intent(HomeActivity.this, ClubEventsActivity.class);
        startActivity(intent);
    }

    public void onFinanceClicked(View view) {
        // Navigate to Finance page
        Intent intent = new Intent(HomeActivity.this, FinanceMainActivity.class);
        startActivity(intent);
    }

    public void onReminderClicked(View view) {
        // Navigate to Reminder page
        Intent intent = new Intent(HomeActivity.this, RemindersActivity.class);
        startActivity(intent);
    }

    public void onInventoryClicked(View view) {
        // Navigate to Inventory page
        Intent intent = new Intent(HomeActivity.this, ClubInventoryActivity.class);
        startActivity(intent);
    }

    public static final int SETTINGS_REQUEST = 1; // Class constant
    public void onSettingsClicked(View view) {
        Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        startActivityForResult(intent, SETTINGS_REQUEST);
    }

}