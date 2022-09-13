package GamesAndSmallPrograms.MyFirstCalculatorArabicAndRomeNumbers;

import java.util.ArrayList;
import java.util.HashMap;

class ArabicAndRimNumbers {
    static final ArrayList<String> arabicNumbers = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            arabicNumbers.add(String.valueOf(i));
        }
    }

    static final HashMap<String, Integer> rimNumbers = new HashMap<>();

    static {
        rimNumbers.put("I", 1);
        rimNumbers.put("II", 2);
        rimNumbers.put("III", 3);
        rimNumbers.put("IV", 4);
        rimNumbers.put("V", 5);
        rimNumbers.put("VI", 6);
        rimNumbers.put("VII", 7);
        rimNumbers.put("VIII", 8);
        rimNumbers.put("IX", 9);
        rimNumbers.put("X", 10);
    }

    static final String[] listFrom1to100 = {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

}
