package com.example.gb_calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gb_calculator.R;
import com.example.gb_calculator.domain.CalculatorData;
import com.example.gb_calculator.domain.CalculatorImpl;
import com.example.gb_calculator.domain.Operation;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private CalculatorPresenter presenter;

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorImpl(), new CalculatorData());

        resultText = findViewById(R.id.text_result);

        findViewById(R.id.btn_clear).setOnClickListener(v -> presenter.onButtonClearClicked());

        findViewById(R.id.btn_0).setOnClickListener(v -> presenter.onButtonDigitClicked("0"));
        findViewById(R.id.btn_1).setOnClickListener(v -> presenter.onButtonDigitClicked("1"));
        findViewById(R.id.btn_2).setOnClickListener(v -> presenter.onButtonDigitClicked("2"));
        findViewById(R.id.btn_3).setOnClickListener(v -> presenter.onButtonDigitClicked("3"));
        findViewById(R.id.btn_4).setOnClickListener(v -> presenter.onButtonDigitClicked("4"));
        findViewById(R.id.btn_5).setOnClickListener(v -> presenter.onButtonDigitClicked("5"));
        findViewById(R.id.btn_6).setOnClickListener(v -> presenter.onButtonDigitClicked("6"));
        findViewById(R.id.btn_7).setOnClickListener(v -> presenter.onButtonDigitClicked("7"));
        findViewById(R.id.btn_8).setOnClickListener(v -> presenter.onButtonDigitClicked("8"));
        findViewById(R.id.btn_9).setOnClickListener(v -> presenter.onButtonDigitClicked("9"));
        findViewById(R.id.btn_dot).setOnClickListener(v -> presenter.onButtonDigitClicked("."));

        findViewById(R.id.btn_plus).setOnClickListener(v -> presenter.onButtonOperationClicked(Operation.ADD));
        findViewById(R.id.btn_minus).setOnClickListener(v -> presenter.onButtonOperationClicked(Operation.SUB));
        findViewById(R.id.btn_multiplication).setOnClickListener(v -> presenter.onButtonOperationClicked(Operation.MULT));
        findViewById(R.id.btn_division).setOnClickListener(v -> presenter.onButtonOperationClicked(Operation.DIV));
        findViewById(R.id.btn_res).setOnClickListener(v -> presenter.onButtonOperationClicked(Operation.NULL));

    }

    @Override
    public void showResult(String result) {
        resultText.setText(result);
    }
}