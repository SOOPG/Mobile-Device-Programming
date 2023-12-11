package com.example.dagapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.widget.TextView;

public class DepartmentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_info);

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
        startActivity(intent);
    }
    public void editRadioDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        startActivity(intent);
    }
    public void editPhotoDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        startActivity(intent);
    }
    public void editVideoDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        startActivity(intent);
    }
    public void editMarketingDepartment(View view) {
        Intent intent = new Intent(DepartmentInfoActivity.this, AddDepartmentInfoActivity.class);
        startActivity(intent);
    }
}