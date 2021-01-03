package com.techelevator;

import java.util.TreeMap;

/*
 * TDD Roman Numeral - Lecture Final
 *
 * 1 = I, 5 = V, 10 = X, 50 = L, 100 = C, 500 = D, 1000 = M
 */
public class KataRomanNumeral {

    private String romanNumeral;
    private int    decimalValue;

    public KataRomanNumeral(int decimalValue) {
        this.decimalValue = decimalValue;
        romanNumeral      = null;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
    public int getDecimalValue() {
        return decimalValue;
    }
}



