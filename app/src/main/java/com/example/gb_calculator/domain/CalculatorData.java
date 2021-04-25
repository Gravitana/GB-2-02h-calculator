package com.example.gb_calculator.domain;

public class CalculatorData {

    private Operation operation;

    private String argOne;
    private String argTwo;

    public CalculatorData() {
        this.reset();
    }

    public void reset() {
        this.operation = Operation.NULL;
        this.argOne = "";
        this.argTwo = "";
    }

    public String inputDigit(String digit) {
        argTwo += digit;
        return argTwo;
    }

    public void setDigits(String digits) {
        argTwo = digits;
    }

    public void inputOperation(Operation operation) {
        if (this.hasArgTwo()) {
            argOne = argTwo;
        }
        this.operation = operation;
        argTwo = "";
    }

    public Operation getOperation() {
        return operation;
    }

    public Double getArgOne() {
        return Double.parseDouble(argOne);
    }

    public Double getArgTwo() {
        return Double.parseDouble(argTwo);
    }

    public boolean hasArgOne() {
        return !argOne.equals("");
    }

    public boolean hasArgTwo() {
        return !argTwo.equals("");
    }

    public boolean hasOperation() {
        return operation != Operation.NULL;
    }
}
