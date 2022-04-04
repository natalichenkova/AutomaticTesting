package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Triangle {

    private int a;
    private int b;
    private int c;
    
    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must be positive");
        }
    }

    private void checkOneSideIsSmallerThanSumOfOthers() {
        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalArgumentException("One side can't be greater than sum of others");
        }
    }

    public int countPerimeter() {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        return a + b + c;
    }
    
    public double countArea() {
        checkSidesArePositive();
        checkOneSideIsSmallerThanSumOfOthers();
        double p = (a + b + c) / 2.00;
        double s = Math.sqrt (p * (p - a) * (p - b) * (p - c));
        return Math.ceil (s * 100) / 100;


    }
    
    
}

