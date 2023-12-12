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
        // Load the reminders
        loadReminders();
    }

    private void loadUserSettings() {
        SharedPreferences preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
        String userName = preferences.getString("UserName", "Soo Min Hao"); // Default value if none found
        String userRole = preferences.getString("UserRole", "Vice Pres."); // Default value if none found

        // Set the user settings to the TextViews
        userNameTextView.setText(userName);
        userRoleTextView.setText(userRole);
    }

    private void loadReminders() {
        SharedPreferences prefs = getSharedPreferences("Reminders", MODE_PRIVATE);

        String reminder1 = prefs.getString("Reminder1", "Add your reminder 1");
        String reminder2 = prefs.getString("Reminder2", "Add your reminder 2");
        String reminder3 = prefs.getString("Reminder3", "Add your reminder 3");
        String reminder4 = prefs.getString("Reminder4", "Add your reminder 4");
        String reminder5 = prefs.getString("Reminder5", "Add your reminder 5");
        String reminder6 = prefs.getString("Reminder6", "Add your reminder 6");

        TextView reminderView1 = findViewById(R.id.reminderHome1);
        TextView reminderView2 = findViewById(R.id.reminderHome2);
        TextView reminderView3 = findViewById(R.id.reminderHome3);
        TextView reminderView4 = findViewById(R.id.reminderHome4);
        TextView reminderView5 = findViewById(R.id.reminderHome5);
        TextView reminderView6 = findViewById(R.id.reminderHome6);

        reminderView1.setText(reminder1);
        reminderView2.setText(reminder2);
        reminderView3.setText(reminder3);
        reminderView4.setText(reminder4);
        reminderView5.setText(reminder5);
        reminderView6.setText(reminder6);
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


    public void onSettingsClicked(View view) {
        Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
}