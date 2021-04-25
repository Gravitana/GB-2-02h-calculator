package com.example.gb_calculator.ui;

import com.example.gb_calculator.domain.Calculator;
import com.example.gb_calculator.domain.CalculatorData;
import com.example.gb_calculator.domain.Operation;

public class CalculatorPresenter {

    private CalculatorView view;

    private Calculator calculator;

    private CalculatorData data;

    private String textResult = "";

    public CalculatorPresenter(CalculatorView view, Calculator calculator, CalculatorData data) {
        this.view = view;
        this.calculator = calculator;
        this.data = data;
    }

    public void onButtonClearClicked() {
        data.reset();
        textResult = "";
        view.showResult(textResult);
    }

    public void onButtonDigitClicked(String digit) {
        textResult = data.inputDigit(digit);
        view.showResult(textResult);
    }

    public void onButtonOperationClicked(Operation operation) {
        if (data.hasArgOne() && data.hasOperation()) {
            double result = calculator.binaryOperation(data.getArgOne(), data.getArgTwo(), data.getOperation());
            textResult = String.valueOf(result);
            data.setDigits(textResult);
        }
        data.inputOperation(operation);
        view.showResult(textResult);
    }

}
