package com.example.dagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinanceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_main);
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