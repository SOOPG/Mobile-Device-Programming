package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BudgetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgeting);

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

    public void addBudgeting(View view) {
        // Get the input from user
        EditText titleEditText = findViewById(R.id.budgetingTitle);
        EditText dateEditText = findViewById(R.id.budgetingDate);
        EditText amountEditText = findViewById(R.id.budgetingAmount);
        EditText categoryEditText = findViewById(R.id.budgetingCategory);
        EditText descriptionEditText = findViewById(R.id.budgetingDescription);

        String title = titleEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String amount = amountEditText.getText().toString();
        String category = categoryEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        // Save to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("budgetingTitle", title);
        editor.putString("budgetingDate", date);
        editor.putString("budgetingAmount", amount);
        editor.putString("budgetingCategory", category);
        editor.putString("budgetingDescription", description);
        editor.apply();

        Toast.makeText(this, "Budgeting saved", Toast.LENGTH_SHORT).show();
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