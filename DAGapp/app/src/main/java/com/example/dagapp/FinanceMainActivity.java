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
        Intent intent = new Intent(FinanceMainActivity.this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void onExpensesClicked(View view) {

    }

    public void onIncomeClicked(View view) {

    }

    public void onBudgetingClicked(View view) {

    }

    public void onHistoryClicked(View view) {

    }

}