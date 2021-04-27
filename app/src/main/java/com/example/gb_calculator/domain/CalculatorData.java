package com.example.gb_calculator.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculatorData implements Parcelable {

    private Operation operation;

    private String argOne;
    private String argTwo;
    private String result;

    public CalculatorData() {
        reset();
    }

    protected CalculatorData(Parcel in) {
        argOne = in.readString();
        argTwo = in.readString();
        result = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(argOne);
        dest.writeString(argTwo);
        dest.writeString(result);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CalculatorData> CREATOR = new Creator<CalculatorData>() {
        @Override
        public CalculatorData createFromParcel(Parcel in) {
            return new CalculatorData(in);
        }

        @Override
        public CalculatorData[] newArray(int size) {
            return new CalculatorData[size];
        }
    };

    public void reset() {
        operation = Operation.NULL;
        argOne = "0";
        argTwo = "";
        result = "0";
    }

    public void inputDigit(String digit) {
        argTwo += digit;
        result = argTwo;
    }

    public void setDigits(String digits) {
        argTwo = digits;
        result = argTwo;
    }

    public void inputOperation(Operation operation) {
        if (this.hasArgTwo()) {
            argOne = argTwo;
        }
        this.operation = operation;
        argTwo = "";
        result = argOne;
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

    public String getResult() {
        return result;
    }

    public boolean hasArgTwo() {
        return !argTwo.equals("");
    }

    public boolean hasOperation() {
        return operation != Operation.NULL;
    }
}
