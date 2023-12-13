package com.example.dagapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClubEventsActivity extends AppCompatActivity {

    EditText editTextEventArtsTitle, editTextEventArtsDate, editTextEventArtsStatus;
    EditText editTextEventRadioTitle, editTextEventRadioDate, editTextEventRadioStatus;
    EditText editTextEventPhotoTitle, editTextEventPhotoDate, editTextEventPhotoStatus;
    EditText editTextEventVideoTitle, editTextEventVideoDate, editTextEventVideoStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_events);

        // Initialize EditTexts
        editTextEventArtsTitle = findViewById(R.id.eventArtsTitle);
        editTextEventArtsDate = findViewById(R.id.eventArtsDate);
        editTextEventArtsStatus = findViewById(R.id.eventArtsStatus);

        editTextEventRadioTitle = findViewById(R.id.eventRadioTitle);
        editTextEventRadioDate = findViewById(R.id.eventRadioDate);
        editTextEventRadioStatus = findViewById(R.id.eventRadioStatus);

        editTextEventPhotoTitle = findViewById(R.id.eventPhotoTitle);
        editTextEventPhotoDate = findViewById(R.id.eventPhotoDate);
        editTextEventPhotoStatus = findViewById(R.id.eventPhotoStatus);

        editTextEventVideoTitle = findViewById(R.id.eventVideoTitle);
        editTextEventVideoDate = findViewById(R.id.eventVideoDate);
        editTextEventVideoStatus = findViewById(R.id.eventVideoStatus);

        // Load previously saved events
        loadEvents();
    }

    private void loadEvents() {
        // Load events from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("ClubEvents", MODE_PRIVATE);

        // Load all department events
        editTextEventArtsTitle.setText(prefs.getString("eventArtsTitle", ""));
        editTextEventArtsDate.setText(prefs.getString("eventArtsDate", ""));
        editTextEventArtsStatus.setText(prefs.getString("eventArtsStatus", ""));

        editTextEventRadioTitle.setText(prefs.getString("eventRadioTitle", ""));
        editTextEventRadioDate.setText(prefs.getString("eventRadioDate", ""));
        editTextEventRadioStatus.setText(prefs.getString("eventRadioStatus", ""));

        editTextEventPhotoTitle.setText(prefs.getString("eventPhotoTitle", ""));
        editTextEventPhotoDate.setText(prefs.getString("eventPhotoDate", ""));
        editTextEventPhotoStatus.setText(prefs.getString("eventPhotoStatus", ""));

        editTextEventVideoTitle.setText(prefs.getString("eventVideoTitle", ""));
        editTextEventVideoDate.setText(prefs.getString("eventVideoDate", ""));
        editTextEventVideoStatus.setText(prefs.getString("eventVideoStatus", ""));
    }

    public void addEvents(View view) {
        // Save events to SharedPreferences
        SharedPreferences prefs = getSharedPreferences("ClubEvents", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Save the arts department event
        editor.putString("eventArtsTitle", editTextEventArtsTitle.getText().toString());
        editor.putString("eventArtsDate", editTextEventArtsDate.getText().toString());
        editor.putString("eventArtsStatus", editTextEventArtsStatus.getText().toString());

        // Save the radio department event
        editor.putString("eventRadioTitle", editTextEventRadioTitle.getText().toString());
        editor.putString("eventRadioDate", editTextEventRadioDate.getText().toString());
        editor.putString("eventRadioStatus", editTextEventRadioStatus.getText().toString());

        // Save the photo department event
        editor.putString("eventPhotoTitle", editTextEventPhotoTitle.getText().toString());
        editor.putString("eventPhotoDate", editTextEventPhotoDate.getText().toString());
        editor.putString("eventPhotoStatus", editTextEventPhotoStatus.getText().toString());

        // Save the video department event
        editor.putString("eventVideoTitle", editTextEventVideoTitle.getText().toString());
        editor.putString("eventVideoDate", editTextEventVideoDate.getText().toString());
        editor.putString("eventVideoStatus", editTextEventVideoStatus.getText().toString());

        Toast.makeText(this, "Events saved", Toast.LENGTH_SHORT).show();
        editor.apply();
    }


    public void clearEvents(View view) {
        // Clear all events from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("ClubEvents", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.clear();
        editor.apply();
        // Clear the EditTexts
        editTextEventArtsTitle.setText("");
        editTextEventArtsDate.setText("");
        editTextEventArtsStatus.setText("");

        editTextEventRadioTitle.setText("");
        editTextEventRadioDate.setText("");
        editTextEventRadioStatus.setText("");

        editTextEventPhotoTitle.setText("");
        editTextEventPhotoDate.setText("");
        editTextEventPhotoStatus.setText("");

        editTextEventVideoTitle.setText("");
        editTextEventVideoDate.setText("");
        editTextEventVideoStatus.setText("");

        Toast.makeText(this, "Events cleared", Toast.LENGTH_SHORT).show();
    }

    public void onReturnClicked(View view) {
        // Handle the return button click
        finish();
    }
}