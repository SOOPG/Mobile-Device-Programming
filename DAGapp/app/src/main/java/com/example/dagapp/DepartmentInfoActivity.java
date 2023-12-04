package com.example.dagapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class DepartmentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_info);
    }

    // This method is called when the return button is clicked
    public void onReturnClicked(View view) {
        finish(); // Closes this activity and returns to the previous one
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