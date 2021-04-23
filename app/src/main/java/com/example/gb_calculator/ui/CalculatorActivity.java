package com.example.gb_calculator.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gb_calculator.R;
import com.example.gb_calculator.domain.CalculatorData;
import com.example.gb_calculator.domain.CalculatorImpl;
import com.example.gb_calculator.domain.Operation;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private static final String ARG_RESULT = "ARG_RESULT";

    private CalculatorPresenter presenter;

    private TextView resultText;

    private CalculatorData data;

    private final int[] digitButtonIds = new int[]{R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.text_result);

        if (savedInstanceState == null) {
            data = new CalculatorData();
        } else {
            data = savedInstanceState.getParcelable("ARG_RESULT");
            showResult(data.getResult());
        }

        presenter = new CalculatorPresenter(this, new CalculatorImpl(), data);

        findViewById(R.id.btn_clear).setOnClickListener(v -> presenter.onButtonClearClicked());

        for (int i = 0; i < digitButtonIds.length; i++) {
            int index = i;
            findViewById(digitButtonIds[i]).setOnClickListener(v -> presenter.onButtonDigitClicked(String.valueOf(index)));
        }
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(ARG_RESULT, data);
        super.onSaveInstanceState(outState);
    }
}