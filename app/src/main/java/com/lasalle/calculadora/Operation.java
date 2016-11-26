package com.lasalle.calculadora;

import java.io.Serializable;

/**
 * Created by hamza on 20/11/2016.
 */

public class Operation implements Serializable{
    @Override
    public String toString() {
        return "Operation{" +
                "type='" + type + '\'' + ", operand=" + operand + ", operator=" + operator + ", result=" + result +
                '}';
    }

    private String type;
    private int operand;
    private int operator;
    private int result;




    public Operation(String type, int operand, int operator, int result) {
        this.type = type;
        this.operand = operand;
        this.operator = operator;
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOperand() {
        return operand;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

