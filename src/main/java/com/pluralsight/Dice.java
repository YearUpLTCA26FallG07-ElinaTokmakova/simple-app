package com.pluralsight;

public class Dice {

    int maxValue = 6;
    int minValue = 1;

    public int roll() {

        int randomNumber = (int)(Math.random() * (maxValue - minValue + 1)) + minValue;

        return randomNumber;
    }
}
