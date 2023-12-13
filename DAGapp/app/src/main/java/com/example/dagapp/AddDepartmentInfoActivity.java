package com.example.dagapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddDepartmentInfoActivity extends AppCompatActivity {

    private EditText departmentHeadNameEditText;
    private EditText contactNumberEditText;

    // Department currently being edited
    private String currentDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_department_info);

        departmentHeadNameEditText = findViewById(R.id.editTextDepartmentHeadName);
        contactNumberEditText = findViewById(R.id.editTextContactNumber);

        // Get the department identifier passed from the previous activity
        currentDepartment = getIntent().getStringExtra(DepartmentInfoActivity.DEPARTMENT_KEY);
        if (currentDepartment == null) {
            Toast.makeText(this, "No department selected", Toast.LENGTH_LONG).show();
            finish(); // No department was passed, can't edit
            return;
        }
        loadDepartmentInfo();
    }

    //Load department informations
    private void loadDepartmentInfo() {
        SharedPreferences prefs = getSharedPreferences("DepartmentInfo", MODE_PRIVATE);
        String departmentHeadName = prefs.getString(currentDepartment + "HeadName", "");
        String contactNumber = prefs.getString(currentDepartment + "Contact", "");

        departmentHeadNameEditText.setText(departmentHeadName);
        contactNumberEditText.setText(contactNumber);
    }

    public void onEditDepartmentClicked(View view) {
        String departmentHeadName = departmentHeadNameEditText.getText().toString();
        String contactNumber = contactNumberEditText.getText().toString();

        // Save these strings to SharedPreferences
        SharedPreferences prefs = getSharedPreferences("DepartmentInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Use the currentDepartment value to create a unique key for each department
        editor.putString(currentDepartment + "HeadName", departmentHeadName);
        editor.putString(currentDepartment + "Contact", contactNumber);
        editor.apply();

        Toast.makeText(this, "Department info updated", Toast.LENGTH_SHORT).show();

        // After saving, finish this activity
        finish();
    }

    public void onReturnClicked(View view) {
        finish(); // To return to the previous screen
    }

}
