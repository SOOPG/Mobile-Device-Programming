package com.example.dagapp;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class AddDepartmentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_department_info);
    }

    public void onReturnClicked(View view) {
        finish(); // To return to the previous screen
    }

    public void onAddClicked(View view) {
        // Code to handle adding the department head's info
    }
}
