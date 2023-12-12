package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;
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
    }

    public void onSaveUserSettingsClicked(View view) {

        userNameEditText = findViewById(R.id.settingUserName); // Your user name EditText ID
        userRoleEditText = findViewById(R.id.settingUserRole); // Your user role EditText ID

        String userName = userNameEditText.getText().toString();
        String userRole = userRoleEditText.getText().toString();


        // Save to SharedPreferences
        SharedPreferences preferences = getSharedPreferences("UserSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("UserName", userName);
        editor.putString("UserRole", userRole);
        editor.apply(); // or editor.commit();

        // Optional by provide feedback to the user
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    //For return button
    public void onReturnClicked(View view) {
        finish();
    }
}