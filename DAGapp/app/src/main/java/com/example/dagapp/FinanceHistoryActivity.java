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
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBankBalance();
        loadIncomeHistory();
        loadExpensesHistory();
        loadBudgetingHistory();
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

    public void clearFinanceHistory(View view) {
        TextView historyClearIncomeTitle = findViewById(R.id.recentIncomeHistoryTitle);
        TextView historyClearIncomeDate = findViewById(R.id.recentIncomeHistoryDate);
        TextView historyClearIncomeAmount = findViewById(R.id.recentIncomeHistoryAmount);
        TextView historyClearIncomeCategory = findViewById(R.id.recentIncomeHistoryCategory);
        TextView historyClearIncomeDescription = findViewById(R.id.recentIncomeHistoryDescription);

        historyClearIncomeTitle.setText("");
        historyClearIncomeDate.setText("");
        historyClearIncomeAmount.setText("");
        historyClearIncomeCategory.setText("");
        historyClearIncomeDescription.setText("");

        TextView historyClearExpensesTitle = findViewById(R.id.recentExpenseHistoryTitle);
        TextView historyClearExpensesDate = findViewById(R.id.recentExpenseHistoryDate);
        TextView historyClearExpensesAmount = findViewById(R.id.recentExpenseHistoryAmount);
        TextView historyClearExpensesCategory = findViewById(R.id.recentExpenseHistoryCategory);
        TextView historyClearExpensesDescription = findViewById(R.id.recentExpenseHistoryDescription);

        historyClearExpensesTitle.setText("");
        historyClearExpensesDate.setText("");
        historyClearExpensesAmount.setText("");
        historyClearExpensesCategory.setText("");
        historyClearExpensesDescription.setText("");

        TextView historyClearBudgetingTitle = findViewById(R.id.recentBudgetingHistoryTitle);
        TextView historyClearBudgetingDate = findViewById(R.id.recentBudgetingHistoryDate);
        TextView historyClearBudgetingAmount = findViewById(R.id.recentBudgetingHistoryAmount);
        TextView historyClearBudgetingCategory = findViewById(R.id.recentBudgetingHistoryCategory);
        TextView historyClearBudgetingDescription = findViewById(R.id.recentBudgetingHistoryDescription);

        historyClearBudgetingTitle.setText("");
        historyClearBudgetingDate.setText("");
        historyClearBudgetingAmount.setText("");
        historyClearBudgetingCategory.setText("");
        historyClearBudgetingDescription.setText("");
    }

    public void onReturnClicked(View view) {
        finish();
    }
}