package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ExpensesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

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

    public void addExpenses(View view) {
        // Get the input from user
        EditText expensesTitle = findViewById(R.id.expensesTitle);
        EditText expensesDate = findViewById(R.id.expensesDate);
        EditText expensesAmount = findViewById(R.id.expensesAmount);
        EditText expensesCategory = findViewById(R.id.expensesCategory);
        EditText expensesDescription = findViewById(R.id.expensesDescription);

        String title = expensesTitle.getText().toString();
        String date = expensesDate.getText().toString();
        String amount = expensesAmount.getText().toString();
        String category = expensesCategory.getText().toString();
        String description = expensesDescription.getText().toString();

        // Save to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("expensesTitle", title);
        editor.putString("expensesDate", date);
        editor.putString("expensesAmount", amount);
        editor.putString("expensesCategory", category);
        editor.putString("expensesDescription", description);
        editor.apply();

        Toast.makeText(this, "Expenses saved", Toast.LENGTH_SHORT).show();
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