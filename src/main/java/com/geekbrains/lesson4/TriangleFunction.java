package com.geekbrains.lesson4;

public class TriangleFunction {
    public static double calculaterHalfPerimeter(int a, int b, int c){
        return (a + b + c) / 2.0;
    }
    public static double TriangleArea(int a, int b, int c){
        double result = calculaterHalfPerimeter(a, b, c);
        return Math.sqrt(result * (result - a) * (result - b) * (result - c));
    }
}
