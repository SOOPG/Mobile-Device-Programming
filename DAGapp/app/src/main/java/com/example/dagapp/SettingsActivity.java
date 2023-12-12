package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText userRoleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // Initialize TextViews
        userNameEditText = findViewById(R.id.settingUserName);
        userRoleEditText = findViewById(R.id.settingUserRole);
        // Load the user settings
        loadUserSettings();
    }

    private void loadUserSettings() {
        SharedPreferences preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
        String userName = preferences.getString("UserName", "Soo Min Hao"); // Default value if none found
        String userRole = preferences.getString("UserRole", "Vice Pres."); // Default value if none found

        // Set the user settings to the TextViews
        userNameEditText.setText(userName);
        userRoleEditText.setText(userRole);
    }

    public void onSaveUserSettingsClicked(View view) {

        userNameEditText = findViewById(R.id.settingUserName); // User Name
        userRoleEditText = findViewById(R.id.settingUserRole); // User Role

        String userName = userNameEditText.getText().toString();
        String userRole = userRoleEditText.getText().toString();

        // Save to SharedPreferences
        SharedPreferences preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("UserName", userName);
        editor.putString("UserRole", userRole);
        editor.apply();

        // Optional by provide feedback to the user
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    //For return button
    public void onReturnClicked(View view) {
        finish();
    }

    public void onLogoutClicked(View view) {
        // Create an Intent to start MainActivity
        Intent intent = new Intent(this, MainActivity.class);

        // Set the Intent action to clear the back stack and create a new task
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        // Start MainActivity
        startActivity(intent);

        // Close the current activity and all others in the task (clear the back stack)
        finishAffinity();
    }
}