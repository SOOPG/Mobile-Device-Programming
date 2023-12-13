package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FinanceHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_history);

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
        loadIncomeHistory();
        loadExpensesHistory();
        loadBudgetingHistory();
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

    private void loadIncomeHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        String title = sharedPreferences.getString("incomeTitle", "N/A");
        String date = sharedPreferences.getString("incomeDate", "N/A");
        String amount = sharedPreferences.getString("incomeAmount", "N/A");
        String category = sharedPreferences.getString("incomeCategory", "N/A");
        String description = sharedPreferences.getString("incomeDescription", "N/A");

        TextView historyTitle = findViewById(R.id.recentIncomeHistoryTitle);
        TextView historyDate = findViewById(R.id.recentIncomeHistoryDate);
        TextView historyAmount = findViewById(R.id.recentIncomeHistoryAmount);
        TextView historyCategory = findViewById(R.id.recentIncomeHistoryCategory);
        TextView historyDescription = findViewById(R.id.recentIncomeHistoryDescription);

        historyTitle.setText(title);
        historyDate.setText(date);
        historyAmount.setText(amount);
        historyCategory.setText(category);
        historyDescription.setText(description);
    }

    private void loadExpensesHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        String title = sharedPreferences.getString("expensesTitle", "N/A");
        String date = sharedPreferences.getString("expensesDate", "N/A");
        String amount = sharedPreferences.getString("expensesAmount", "N/A");
        String category = sharedPreferences.getString("expensesCategory", "N/A");
        String description = sharedPreferences.getString("expensesDescription", "N/A");

        TextView historyTitle = findViewById(R.id.recentExpenseHistoryTitle);
        TextView historyDate = findViewById(R.id.recentExpenseHistoryDate);
        TextView historyAmount = findViewById(R.id.recentExpenseHistoryAmount);
        TextView historyCategory = findViewById(R.id.recentExpenseHistoryCategory);
        TextView historyDescription = findViewById(R.id.recentExpenseHistoryDescription);

        historyTitle.setText(title);
        historyDate.setText(date);
        historyAmount.setText(amount);
        historyCategory.setText(category);
        historyDescription.setText(description);
    }

    private void loadBudgetingHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        String title = sharedPreferences.getString("budgetingTitle", "N/A");
        String date = sharedPreferences.getString("budgetingDate", "N/A");
        String amount = sharedPreferences.getString("budgetingAmount", "N/A");
        String category = sharedPreferences.getString("budgetingCategory", "N/A");
        String description = sharedPreferences.getString("budgetingDescription", "N/A");

        TextView historyTitle = findViewById(R.id.recentBudgetingHistoryTitle);
        TextView historyDate = findViewById(R.id.recentBudgetingHistoryDate);
        TextView historyAmount = findViewById(R.id.recentBudgetingHistoryAmount);
        TextView historyCategory = findViewById(R.id.recentBudgetingHistoryCategory);
        TextView historyDescription = findViewById(R.id.recentBudgetingHistoryDescription);

        historyTitle.setText(title);
        historyDate.setText(date);
        historyAmount.setText(amount);
        historyCategory.setText(category);
        historyDescription.setText(description);
    }


    // Clear all the finance history
    public void clearFinanceHistory(View view) {
        clearFinanceHistoryViews(); // Clear TextViews
        clearFinanceHistoryData(); // Clear SharedPreferences
    }

    // Method to clear SharedPreferences data
    private void clearFinanceHistoryData() {
        SharedPreferences sharedPreferences = getSharedPreferences("FinanceData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("incomeTitle");
        editor.remove("incomeDate");
        editor.remove("incomeAmount");
        editor.remove("incomeCategory");
        editor.remove("incomeDescription");

        editor.remove("expensesTitle");
        editor.remove("expensesDate");
        editor.remove("expensesAmount");
        editor.remove("expensesCategory");
        editor.remove("expensesDescription");

        editor.remove("budgetingTitle");
        editor.remove("budgetingDate");
        editor.remove("budgetingAmount");
        editor.remove("budgetingCategory");
        editor.remove("budgetingDescription");

        editor.apply();
    }


    private void clearFinanceHistoryViews() {
        // Clear the text views
        ((TextView) findViewById(R.id.recentIncomeHistoryTitle)).setText("N/A");
        ((TextView) findViewById(R.id.recentIncomeHistoryDate)).setText("N/A");
        ((TextView) findViewById(R.id.recentIncomeHistoryAmount)).setText("N/A");
        ((TextView) findViewById(R.id.recentIncomeHistoryCategory)).setText("N/A");
        ((TextView) findViewById(R.id.recentIncomeHistoryDescription)).setText("N/A");

        ((TextView) findViewById(R.id.recentExpenseHistoryTitle)).setText("N/A");
        ((TextView) findViewById(R.id.recentExpenseHistoryDate)).setText("N/A");
        ((TextView) findViewById(R.id.recentExpenseHistoryAmount)).setText("N/A");
        ((TextView) findViewById(R.id.recentExpenseHistoryCategory)).setText("N/A");
        ((TextView) findViewById(R.id.recentExpenseHistoryDescription)).setText("N/A");

        ((TextView) findViewById(R.id.recentBudgetingHistoryTitle)).setText("N/A");
        ((TextView) findViewById(R.id.recentBudgetingHistoryDate)).setText("N/A");
        ((TextView) findViewById(R.id.recentBudgetingHistoryAmount)).setText("N/A");
        ((TextView) findViewById(R.id.recentBudgetingHistoryCategory)).setText("N/A");
        ((TextView) findViewById(R.id.recentBudgetingHistoryDescription)).setText("N/A");
    }

    public void onReturnClicked(View view) {
        finish();
    }
}