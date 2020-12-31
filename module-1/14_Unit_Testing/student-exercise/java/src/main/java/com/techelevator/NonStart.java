package com.techelevator;

public class NonStart {

    /*
     Given 2 strings, return their concatenation, except omit the first char of each. The strings will
     be at least length 1.
     Note: (this can be interpreted as both strings will have length 1)
     Note: (the program is written as if the interpretation should be both strings together
     with have length at least 1);
     GetPartialString("Hello", "There") → "ellohere"
     GetPartialString("java", "code") → "avaode"
     GetPartialString("shotl", "java") → "hotlava"
     */
    public String getPartialString(String a, String b) {
        if (a.length() == 0) {
            return b.substring(1);
        } else if (b.length() == 0) {
            return a.substring(1);
        } else {
            return a.substring(1) + b.substring(1);
        }
    }
}
