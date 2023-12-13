package com.example.dagapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClubInventoryActivity extends AppCompatActivity {

    // Define EditText fields
    private EditText equipmentNameCamera1, equipmentNameCamera2, equipmentNameCamera3, equipmentNameCamera4, equipmentNameCamera5;
    private EditText equipmentNameAudio1, equipmentNameAudio2, equipmentNameAudio3, equipmentNameAudio4, equipmentNameAudio5;
    private EditText equipmentNameTripod1, equipmentNameTripod2, equipmentNameTripod3, equipmentNameTripod4, equipmentNameTripod5;
    private EditText equipmentNameLighting1, equipmentNameLighting2, equipmentNameLighting3, equipmentNameLighting4, equipmentNameLighting5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_inventory);

        equipmentNameCamera1 = findViewById(R.id.equipmentNameCamera1);
        equipmentNameCamera2 = findViewById(R.id.equipmentNameCamera2);
        equipmentNameCamera3 = findViewById(R.id.equipmentNameCamera3);
        equipmentNameCamera4 = findViewById(R.id.equipmentNameCamera4);
        equipmentNameCamera5 = findViewById(R.id.equipmentNameCamera5);

        equipmentNameAudio1 = findViewById(R.id.equipmentNameAudio1);
        equipmentNameAudio2 = findViewById(R.id.equipmentNameAudio2);
        equipmentNameAudio3 = findViewById(R.id.equipmentNameAudio3);
        equipmentNameAudio4 = findViewById(R.id.equipmentNameAudio4);
        equipmentNameAudio5 = findViewById(R.id.equipmentNameAudio5);

        equipmentNameTripod1 = findViewById(R.id.equipmentNameTripod1);
        equipmentNameTripod2 = findViewById(R.id.equipmentNameTripod2);
        equipmentNameTripod3 = findViewById(R.id.equipmentNameTripod3);
        equipmentNameTripod4 = findViewById(R.id.equipmentNameTripod4);
        equipmentNameTripod5 = findViewById(R.id.equipmentNameTripod5);

        equipmentNameLighting1 = findViewById(R.id.equipmentNameLighting1);
        equipmentNameLighting2 = findViewById(R.id.equipmentNameLighting2);
        equipmentNameLighting3 = findViewById(R.id.equipmentNameLighting3);
        equipmentNameLighting4 = findViewById(R.id.equipmentNameLighting4);
        equipmentNameLighting5 = findViewById(R.id.equipmentNameLighting5);

        // Load Inventory
        loadInventory();
    }

    private void loadInventory() {
        // Retrieve saved data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("ClubInventory", MODE_PRIVATE);

        // Load camera equipment data
        equipmentNameCamera1.setText(sharedPreferences.getString("camera1", ""));
        equipmentNameCamera2.setText(sharedPreferences.getString("camera2", ""));
        equipmentNameCamera3.setText(sharedPreferences.getString("camera3", ""));
        equipmentNameCamera4.setText(sharedPreferences.getString("camera4", ""));
        equipmentNameCamera5.setText(sharedPreferences.getString("camera5", ""));

        // Load audio equipment data
        equipmentNameAudio1.setText(sharedPreferences.getString("audio1", ""));
        equipmentNameAudio2.setText(sharedPreferences.getString("audio2", ""));
        equipmentNameAudio3.setText(sharedPreferences.getString("audio3", ""));
        equipmentNameAudio4.setText(sharedPreferences.getString("audio4", ""));
        equipmentNameAudio5.setText(sharedPreferences.getString("audio5", ""));

        // Load tripod equipment data
        equipmentNameTripod1.setText(sharedPreferences.getString("tripod1", ""));
        equipmentNameTripod2.setText(sharedPreferences.getString("tripod2", ""));
        equipmentNameTripod3.setText(sharedPreferences.getString("tripod3", ""));
        equipmentNameTripod4.setText(sharedPreferences.getString("tripod4", ""));
        equipmentNameTripod5.setText(sharedPreferences.getString("tripod5", ""));

        // Load lighting equipment data
        equipmentNameLighting1.setText(sharedPreferences.getString("lighting1", ""));
        equipmentNameLighting2.setText(sharedPreferences.getString("lighting2", ""));
        equipmentNameLighting3.setText(sharedPreferences.getString("lighting3", ""));
        equipmentNameLighting4.setText(sharedPreferences.getString("lighting4", ""));
        equipmentNameLighting5.setText(sharedPreferences.getString("lighting5", ""));
    }

    public void updateInventory(View view) {
        // Retrieve data from EditTexts and store in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("ClubInventory", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save camera equipment data
        editor.putString("camera1", equipmentNameCamera1.getText().toString());
        editor.putString("camera2", equipmentNameCamera2.getText().toString());
        editor.putString("camera3", equipmentNameCamera3.getText().toString());
        editor.putString("camera4", equipmentNameCamera4.getText().toString());
        editor.putString("camera5", equipmentNameCamera5.getText().toString());

        // Save audio equipment data
        editor.putString("audio1", equipmentNameAudio1.getText().toString());
        editor.putString("audio2", equipmentNameAudio2.getText().toString());
        editor.putString("audio3", equipmentNameAudio3.getText().toString());
        editor.putString("audio4", equipmentNameAudio4.getText().toString());
        editor.putString("audio5", equipmentNameAudio5.getText().toString());

        // Save tripod equipment data
        editor.putString("tripod1", equipmentNameTripod1.getText().toString());
        editor.putString("tripod2", equipmentNameTripod2.getText().toString());
        editor.putString("tripod3", equipmentNameTripod3.getText().toString());
        editor.putString("tripod4", equipmentNameTripod4.getText().toString());
        editor.putString("tripod5", equipmentNameTripod5.getText().toString());

        // Save lighting equipment data
        editor.putString("lighting1", equipmentNameLighting1.getText().toString());
        editor.putString("lighting2", equipmentNameLighting2.getText().toString());
        editor.putString("lighting3", equipmentNameLighting3.getText().toString());
        editor.putString("lighting4", equipmentNameLighting4.getText().toString());
        editor.putString("lighting5", equipmentNameLighting5.getText().toString());

        // Commit changes to SharedPreferences
        Toast.makeText(this, "Inventory Updated", Toast.LENGTH_SHORT).show();
        editor.apply();
    }

    public void onReturnClicked(View view) {
        // Handle the return button click
        finish();
    }

}