package com.lasalle.calculadora;

/**
 * Created by hamza on 26/11/2016.
 */

public class MathOperations {

    public  int sum(int a, int b) throws MyOverflowException {
        long r = (long) a + b;
        return checkInt(a, b, r);
    }


    public  int multiplicar(int a, int b) throws MyOverflowException {
        long r = (long) a * b;
        return checkInt(a, b, r);
    }

    public  int restar(int a,int b) throws  MyOverflowException{
        long r=(long) a - b;
        return  checkInt(a,b,r);
    }


    private int checkInt(int a, int b, long r) throws MyOverflowException {
        if ( r < Integer.MIN_VALUE ||  r> Integer.MAX_VALUE )
            throw new MyOverflowException(a,b);
        return (int) r;
    }


    public class MyOverflowException extends Exception {
        public MyOverflowException(int a, int b) {
            super("Error");
        }
    }
}
