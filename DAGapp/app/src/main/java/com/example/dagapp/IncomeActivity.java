package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

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

    public void addIncome(View view) {
        // Get the input from user
        EditText incomeTitle = findViewById(R.id.incomeTitle);
        EditText incomeDate = findViewById(R.id.incomeDate);
        EditText incomeAmount = findViewById(R.id.incomeAmount);
        EditText incomeCategory = findViewById(R.id.incomeCategory);
        EditText incomeDescription = findViewById(R.id.incomeDescription);

        String title = incomeTitle.getText().toString();
        String date = incomeDate.getText().toString();
        String amount = incomeAmount.getText().toString();
        String category = incomeCategory.getText().toString();
        String description = incomeDescription.getText().toString();

        // Save to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("incomeTitle", title);
        editor.putString("incomeDate", date);
        editor.putString("incomeAmount", amount);
        editor.putString("incomeCategory", category);
        editor.putString("incomeDescription", description);
        editor.apply();

        Toast.makeText(this, "Income saved", Toast.LENGTH_SHORT).show();
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
}