package com.example.gb_calculator.ui;

import com.example.gb_calculator.domain.Calculator;
import com.example.gb_calculator.domain.CalculatorData;
import com.example.gb_calculator.domain.Operation;

public class CalculatorPresenter {

    private CalculatorView view;

    private Calculator calculator;

    private CalculatorData data;

    public CalculatorPresenter(CalculatorView view, Calculator calculator, CalculatorData data) {
        this.view = view;
        this.calculator = calculator;
        this.data = data;
    }

    public void onButtonClearClicked() {
        data.reset();
        view.showResult(data.getResult());
    }

    public void onButtonDigitClicked(String digit) {
        data.inputDigit(digit);
        view.showResult(data.getResult());
    }

    public void onButtonOperationClicked(Operation operation) {
        if (data.hasOperation()) {
            double result = calculator.binaryOperation(data.getArgOne(), data.getArgTwo(), data.getOperation());
            data.setDigits(String.valueOf(result));
        }
        data.inputOperation(operation);
        view.showResult(data.getResult());
    }

}
