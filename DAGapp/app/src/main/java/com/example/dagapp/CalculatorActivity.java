package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editTextNumber1 = findViewById(R.id.inputCalculator);
        editTextNumber2 = findViewById(R.id.inputCalculator2);
        textViewResult = findViewById(R.id.outputCalculator);
    }

    public void onReturnClicked(View view) {
        finish();
    }

    // Addition
    public void onAddClicked(View view) {
        double num1 = Double.parseDouble(editTextNumber1.getText().toString());
        double num2 = Double.parseDouble(editTextNumber2.getText().toString());
        double result = num1 + num2;
        textViewResult.setText(String.valueOf(result));
    }

    // Subtraction
    public void onSubtractClicked(View view) {
        double num1 = Double.parseDouble(editTextNumber1.getText().toString());
        double num2 = Double.parseDouble(editTextNumber2.getText().toString());
        double result = num1 - num2;
        textViewResult.setText(String.valueOf(result));
    }

    // Multiplication
    public void onMultiplyClicked(View view) {
        double num1 = Double.parseDouble(editTextNumber1.getText().toString());
        double num2 = Double.parseDouble(editTextNumber2.getText().toString());
        double result = num1 * num2;
        textViewResult.setText(String.valueOf(result));
    }

    // Division
    public void onDivideClicked(View view) {
        double num1 = Double.parseDouble(editTextNumber1.getText().toString());
        double num2 = Double.parseDouble(editTextNumber2.getText().toString());
        // Check for division by zero
        if (num2 != 0) {
            double result = num1 / num2;
            textViewResult.setText(String.valueOf(result));
        } else {
            textViewResult.setText("Error");
        }
    }

    // Copy Result
    public void onCopyClicked(View view) {
        // Copy the result to clipboard
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Data", textViewResult.getText().toString());
        clipboard.setPrimaryClip(clip);
    }

    // Clear Inputs and Result
    public void onClearClicked(View view) {
        editTextNumber1.setText("");
        editTextNumber2.setText("");
        textViewResult.setText("");
    }
}