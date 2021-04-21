package com.example.gb_calculator.ui;

import com.example.gb_calculator.domain.Calculator;
import com.example.gb_calculator.domain.Operation;

public class CalculatorPresenter {

    private CalculatorView view;

    private Calculator calculator;

    private Operation savedOperation = Operation.NULL;

    private String argOne = "";
    private String argTwo = "";

    private String textResult = "";

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onButtonClearClicked() {
        argOne = "";
        argTwo = "";
        textResult = "";
        savedOperation = null;

        view.showResult(String.valueOf(textResult));
    }

    public void onButtonDigitClicked(int digit) {
        argTwo += digit;

        view.showResult(String.valueOf(argTwo));
    }

    public void onButtonDotClicked() {
        argTwo += ".";

        view.showResult(String.valueOf(argTwo));
    }

    public void onButtonOperationClicked(Operation operation) {
        if (savedOperation != Operation.NULL) {
            double arg1 = Double.parseDouble(argOne);
            double arg2 = Double.parseDouble(argTwo);
            double result = calculator.binaryOperation(arg1, arg2, savedOperation);
            textResult = String.valueOf(result);
            view.showResult(textResult);
            argOne = textResult;
        } else {
            argOne = argTwo;
        }
        savedOperation = operation;
        argTwo = "";
    }

}
