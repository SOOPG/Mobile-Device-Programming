package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RemindersActivity extends AppCompatActivity {

    private EditText reminder1EditText;
    private EditText reminder2EditText;
    private EditText reminder3EditText;
    private EditText reminder4EditText;
    private EditText reminder5EditText;
    private EditText reminder6EditText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        reminder1EditText = findViewById(R.id.reminder1);
        reminder2EditText = findViewById(R.id.reminder2);
        reminder3EditText = findViewById(R.id.reminder3);
        reminder4EditText = findViewById(R.id.reminder4);
        reminder5EditText = findViewById(R.id.reminder5);
        reminder6EditText = findViewById(R.id.reminder6);

        loadReminders();
    }

    private void loadReminders() {
        SharedPreferences prefs = getSharedPreferences("Reminders", MODE_PRIVATE);

        reminder1EditText.setText(prefs.getString("Reminder1", ""));
        reminder2EditText.setText(prefs.getString("Reminder2", ""));
        reminder3EditText.setText(prefs.getString("Reminder3", ""));
        reminder4EditText.setText(prefs.getString("Reminder4", ""));
        reminder5EditText.setText(prefs.getString("Reminder5", ""));
        reminder6EditText.setText(prefs.getString("Reminder6", ""));
    }

    public void addReminders(View view) {
        SharedPreferences prefs = getSharedPreferences("Reminders", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("Reminder1", reminder1EditText.getText().toString());
        editor.putString("Reminder2", reminder2EditText.getText().toString());
        editor.putString("Reminder3", reminder3EditText.getText().toString());
        editor.putString("Reminder4", reminder4EditText.getText().toString());
        editor.putString("Reminder5", reminder5EditText.getText().toString());
        editor.putString("Reminder6", reminder6EditText.getText().toString());

        editor.apply();

        // Provide feedback to the user
        Toast.makeText(this, "Reminders saved", Toast.LENGTH_SHORT).show();

        // Return to the previous screen
        finish();
    }

    public void onReturnClicked(View view) {
        finish(); // Closes this activity and returns to the previous one
    }
}
