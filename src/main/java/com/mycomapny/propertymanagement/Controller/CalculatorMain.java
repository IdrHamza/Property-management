package com.mycomapny.propertymanagement.Controller;

public class CalculatorMain {
    public static void main(String[] args){
        CalculatorController cc=new CalculatorController();
        double result=cc.add(3.0,4.0,5.0);
        System.out.println(result);

    }
}
