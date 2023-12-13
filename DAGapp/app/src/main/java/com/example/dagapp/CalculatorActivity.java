package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        EditText editTextBankBalance = findViewById(R.id.bank_balance);
        editTextBankBalance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used
            }

            @Override
            public void afterTextChanged(Editable s) {
                saveBankBalance(s.toString());
            }
        });

        loadBankBalance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBankBalance();
    }

    private void saveBankBalance(String balance) {
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("bankBalance", balance);
        editor.apply();
    }

    private void loadBankBalance() {
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        String balance = sharedPreferences.getString("bankBalance", "0.00");
        EditText editTextBankBalance = findViewById(R.id.bank_balance);
        editTextBankBalance.setText(balance);
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