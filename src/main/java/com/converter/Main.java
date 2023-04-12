package com.converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Type roman number");
            Scanner scanner = new Scanner(System.in);
            String romanNumber = scanner.next();
            System.out.println("Arabic value is " + romanToInt(romanNumber));
        }
    }

    public static int romanToInt(String s) {
        String strToProcess = s;
        int result = 0;
        while (strToProcess.length() > 0) {
            RomanNumber romanNumber = RomanNumber.valueOf(strToProcess.substring(0, 1));
            if (strToProcess.length() > 1) {
                RomanNumber nextRomanNumber = RomanNumber.valueOf(strToProcess.substring(1, 2));
                if (nextRomanNumber.ordinal() - romanNumber.ordinal() == 1 || nextRomanNumber.ordinal() - romanNumber.ordinal() == 2) {
                    result += nextRomanNumber.getArabicValue() - romanNumber.getArabicValue();
                    strToProcess = strToProcess.substring(2);
                    continue;
                }
            }
            result += romanNumber.getArabicValue();
            strToProcess = strToProcess.substring(1);
        }
        return result;
    }
}