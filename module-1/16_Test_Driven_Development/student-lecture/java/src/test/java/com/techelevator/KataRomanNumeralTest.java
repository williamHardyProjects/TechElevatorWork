package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * Unit Tests for Roman Numeral Class
 */
public class KataRomanNumeralTest {

    /************************************************************************************************************
     * V1.0 - Test for single digit Roman Numeral conversion
     ************************************************************************************************************/

    @Test
    public void convert_To_Single_Digit_Roman_Numeral() {
        assertEquals("Decimal value    1 not converted to I correctly", "I", new KataRomanNumeral(1).getRomanNumeral());
        assertEquals("Decimal value    5 not converted to V correctly", "V", new KataRomanNumeral(5).getRomanNumeral());
        assertEquals("Decimal value   10 not converted to X correctly", "X", new KataRomanNumeral(10).getRomanNumeral());
        assertEquals("Decimal value   50 not converted to L correctly", "L", new KataRomanNumeral(50).getRomanNumeral());
        assertEquals("Decimal value  100 not converted to C correctly", "C", new KataRomanNumeral(100).getRomanNumeral());
        assertEquals("Decimal value  500 not converted to D correctly", "D", new KataRomanNumeral(500).getRomanNumeral());
        assertEquals("Decimal value 1000 not converted to M correctly", "M", new KataRomanNumeral(1000).getRomanNumeral());
    }

    /************************************************************************************************************
     *  V2.0 -Test for multi digit Roman Numeral conversion - no edge cases (IV, IX, XC, etc)
     ************************************************************************************************************/
    @Test
    public void convert_Multi_Digit_Roman_Numeral_Value() {
        assertEquals("Decimal value  6 not converted to VI    correctly", "VI",   new KataRomanNumeral(6).getRomanNumeral());
        assertEquals("Decimal value  7 not converted to VII   correctly", "VII",  new KataRomanNumeral(7).getRomanNumeral());
        assertEquals("Decimal value  8 not converted to VIII  correctly", "VIII", new KataRomanNumeral(8).getRomanNumeral());
        assertEquals("Decimal value 11 not converted to XI    correctly", "XI",   new KataRomanNumeral(11).getRomanNumeral());
        assertEquals("Decimal value 12 not converted to XII   correctly", "XII",  new KataRomanNumeral(12).getRomanNumeral());
        assertEquals("Decimal value 13 not converted to XIII  correctly", "XIII", new KataRomanNumeral(13).getRomanNumeral());
        assertEquals("Decimal value 51 not converted to LI    correctly", "LI",   new KataRomanNumeral(51).getRomanNumeral());
        assertEquals("Decimal value 52 not converted to LII   correctly", "LII",  new KataRomanNumeral(52).getRomanNumeral());
        assertEquals("Decimal value 53 not converted to LIII  correctly", "LIII", new KataRomanNumeral(53).getRomanNumeral());
        assertEquals("Decimal value 99 not converted to XCIX  correctly", "XCIX", new KataRomanNumeral(99).getRomanNumeral());
        assertEquals("Decimal value 40 not converted to XL    correctly", "XL",   new KataRomanNumeral(40).getRomanNumeral());

    }

    /************************************************************************************************************
     *  V3.0 - Test for multiples of 10, 100, 1000 - no edge cases (XL, XC, CD, CM)
     ************************************************************************************************************/
    @Test
    public void convert_Multiples_of_10_to_RomanNumerals() {
        assertEquals("Decimal value   10 not converted to   X correctly",   "X", new KataRomanNumeral( 10).getRomanNumeral());
        assertEquals("Decimal value   20 not converted to  XX correctly",  "XX", new KataRomanNumeral( 20).getRomanNumeral());
        assertEquals("Decimal value   30 not converted to  XX correctly", "XXX", new KataRomanNumeral( 30).getRomanNumeral());
        assertEquals("Decimal value   60 not converted to  LX correctly",  "LX", new KataRomanNumeral( 60).getRomanNumeral());
        assertEquals("Decimal value  110 not converted to  CX correctly",  "CX", new KataRomanNumeral(110).getRomanNumeral());
        assertEquals("Decimal value  250 not converted to CCL correctly", "CCL", new KataRomanNumeral(250).getRomanNumeral());
        assertEquals("Decimal value  510 not converted to  DX correctly",  "DX", new KataRomanNumeral(510).getRomanNumeral());
        assertEquals("Decimal value  550 not converted to  DL correctly",  "DL", new KataRomanNumeral(550).getRomanNumeral());
        assertEquals("Decimal value 1010 not converted to  DL correctly",  "DL", new KataRomanNumeral(550).getRomanNumeral());
        assertEquals("Decimal value 1300 not converted to  DL correctly",  "DL", new KataRomanNumeral(550).getRomanNumeral());

    }

    /************************************************************************************************************
     * V4.0 - Test for multi digit Roman Numeral conversion - edge cases (IV, IX, XL, XC, etc)
     ************************************************************************************************************/
    @Test
    public void convert_Multi_Digit_Roman_Numeral_Value_Edge_Cases() {
        assertEquals("Decimal value    4 not converted to IV      correctly", "IV",      new KataRomanNumeral(   4).getRomanNumeral());
        assertEquals("Decimal value    9 not converted to IX      correctly", "IX",      new KataRomanNumeral(   9).getRomanNumeral());
        assertEquals("Decimal value   40 not converted to XL      correctly", "XL",      new KataRomanNumeral(  40).getRomanNumeral());
        assertEquals("Decimal value   90 not converted to XC      correctly", "XC",      new KataRomanNumeral(  90).getRomanNumeral());
        assertEquals("Decimal value  900 not converted to CM      correctly", "CM",      new KataRomanNumeral( 900).getRomanNumeral());
        assertEquals("Decimal value   99 not converted to XCIX    correctly", "XCIX",    new KataRomanNumeral(  99).getRomanNumeral());
        assertEquals("Decimal value 1999 not converted to MCMXCIX correctly", "MCMXCIX", new KataRomanNumeral(1999).getRomanNumeral());
        assertEquals("Decimal value 2019 not converted to MMXIX   correctly", "MMXIX",   new KataRomanNumeral(2019).getRomanNumeral());

        /************************************************************************************************************
         *  v5.0 - Test to be sure ctor did not change the decimal value passed to it
         ************************************************************************************************************/

        assertEquals("Decimal value changed by ctor", 40,   new KataRomanNumeral(40).getDecimalValue());
        assertEquals("Decimal value changed by ctor", 2019, new KataRomanNumeral(2019).getDecimalValue());
    }

}