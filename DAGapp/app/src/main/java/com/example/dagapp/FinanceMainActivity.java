package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class FinanceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_main);

        EditText editTextBankBalance = findViewById(R.id.bank_balance);
        editTextBankBalance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used here
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used here
            }

            @Override
            public void afterTextChanged(Editable s) {
                saveBankBalance(s.toString());
            }
        });

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

    public void onCalculatorClicked(View view) {
        //Start calculator
        Intent intent = new Intent(FinanceMainActivity.this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void onExpensesClicked(View view) {
        //Start expenses
        Intent intent = new Intent(FinanceMainActivity.this, ExpensesActivity.class);
        startActivity(intent);
    }

    public void onIncomeClicked(View view) {
        //Start income
        Intent intent = new Intent(FinanceMainActivity.this, IncomeActivity.class);
        startActivity(intent);
    }

    public void onBudgetingClicked(View view) {
        Intent intent = new Intent(FinanceMainActivity.this, BudgetingActivity.class);
        startActivity(intent);
    }

    public void onHistoryClicked(View view) {
        Intent intent = new Intent(FinanceMainActivity.this, FinanceHistoryActivity.class);
        startActivity(intent);
    }

}