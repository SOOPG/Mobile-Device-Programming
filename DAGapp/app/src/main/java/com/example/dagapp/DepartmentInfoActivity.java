package com.example.dagapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.widget.TextView;

public class DepartmentInfoActivity extends AppCompatActivity {

    // Constants for department identifiers
    public static final String DEPARTMENT_KEY = "department_key";
    public static final String DEPARTMENT_ART = "department_art";
    public static final String DEPARTMENT_RADIO = "department_radio";
    public static final String DEPARTMENT_PHOTO = "department_photo";
    public static final String DEPARTMENT_VIDEO = "department_video";
    public static final String DEPARTMENT_MARKETING = "department_marketing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_info);

        // Load Department Informations
        loadDepartmentInfo();

        // Set up click listeners for contact information
        setupContactClickListener(R.id.arts_head_contact);
        setupContactClickListener(R.id.radio_head_contact);
        setupContactClickListener(R.id.photo_head_contact);
        setupContactClickListener(R.id.video_head_contact);
        setupContactClickListener(R.id.marketing_head_contact);
    }

    // Navigates to contact app when user clicks on the contact number of respective department heads
    private void setupContactClickListener(int textViewId) {
        TextView contactView = findViewById(textViewId);
        contactView.setOnClickListener(v -> {
            String phoneNumber = contactView.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        });
    }

    // This method is called when the return button is clicked
    public void onReturnClicked(View view) {
        finish(); // Closes this page and return to Homepage
    }

    //Navigate to edit department page
    public void editArtDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        intent.putExtra(DEPARTMENT_KEY, DEPARTMENT_ART);
        startActivity(intent);
    }
    public void editRadioDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        intent.putExtra(DEPARTMENT_KEY, DEPARTMENT_RADIO);
        startActivity(intent);
    }
    public void editPhotoDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        intent.putExtra(DEPARTMENT_KEY, DEPARTMENT_PHOTO);
        startActivity(intent);
    }
    public void editVideoDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        intent.putExtra(DEPARTMENT_KEY, DEPARTMENT_VIDEO);
        startActivity(intent);
    }
    public void editMarketingDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        intent.putExtra(DEPARTMENT_KEY, DEPARTMENT_MARKETING);
        startActivity(intent);
    }

    //Need to change for all departments
    private void loadDepartmentInfo() {
        SharedPreferences prefs = getSharedPreferences("DepartmentInfo", MODE_PRIVATE);

        // Load and set Art Department Info
        setDepartmentInfo(prefs, R.id.arts_head_name, R.id.arts_head_contact, DEPARTMENT_ART);
        // Load and set Radio Department Info
        setDepartmentInfo(prefs, R.id.radio_head_name, R.id.radio_head_contact, DEPARTMENT_RADIO);
        // Load and set Photo Department Info
        setDepartmentInfo(prefs, R.id.photo_head_name, R.id.photo_head_contact, DEPARTMENT_PHOTO);
        // Load and set Video Department Info
        setDepartmentInfo(prefs, R.id.video_head_name, R.id.video_head_contact, DEPARTMENT_VIDEO);
        // Load and set Marketing Department Info
        setDepartmentInfo(prefs, R.id.marketing_head_name, R.id.marketing_head_contact, DEPARTMENT_MARKETING);
    }

    private void setDepartmentInfo(SharedPreferences prefs, int nameTextViewId, int contactTextViewId, String departmentKey) {
        String departmentHeadName = prefs.getString(departmentKey + "HeadName", "Default Name");
        String departmentContact = prefs.getString(departmentKey + "Contact", "Default Contact");

        TextView headNameTextView = findViewById(nameTextViewId);
        TextView contactTextView = findViewById(contactTextViewId);

        headNameTextView.setText(departmentHeadName);
        contactTextView.setText(departmentContact);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDepartmentInfo();
    }
}