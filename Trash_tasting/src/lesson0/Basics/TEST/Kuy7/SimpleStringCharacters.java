package lesson0.Basics.TEST.Kuy7;

import java.util.Arrays;

public class SimpleStringCharacters{


    public static void main(String ... args){

        System.out.println(Arrays.toString(SimpleStringCharacters.countedAmount(args[0])));


    }

    static int[] countedAmount(String input){

        int upperCase = input.replaceAll("[^A-Z]","").length();
        int lowerCase = input.replaceAll("[^a-z]","").length();
        int numbers = input.replaceAll("[^0-9]","").length();
        int spec = input.replaceAll("\\w","").length();
        return new int [] {upperCase, lowerCase, numbers, spec};



    }


}