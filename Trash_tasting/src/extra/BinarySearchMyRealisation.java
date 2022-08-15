package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BinarySearchMyRealisation {

    public static void main(String[] args) {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arrayLen = 0;

        System.out.println("Enter Array length: ");
        while (true) {
            try {
                arrayLen = Integer.parseInt(reader.readLine());
                if (arrayLen < 0) {
                    System.out.println("Cannot be less then 0!");
                    continue;
                }
                break;
            } catch (IOException e) {
                System.err.println("NUMBER PLEASE");
            }
        }
        Random random = new Random();
        int[] myArray = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            int rand = random.nextInt(0, 250);
            myArray[i] = rand * rand;
        }
        Arrays.sort(myArray);
        System.out.println(Arrays.toString(myArray));

        System.out.println("Enter you number to find: ");
        int toFind = 0;
        while (true) {
            try {
                toFind = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException e) {
                System.err.println("NUMBER PLEASE");
            }
        }
        int low = 0;
        int high = myArray.length;
        int counter = 0;
        System.out.println("Try to find : " + toFind);

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = myArray[mid];
            if (guess == toFind) {
                counter++;
                System.out.println("I found!" + mid);
                break;
            }
            if (guess > toFind) {
                counter++;
                high = mid - 1;
                continue;
            } else if (guess < toFind) {
                counter++;
                low = mid + 1;
                continue;
            }
            System.out.println("NOT EXIST!");


        }
        System.out.println("ATTEMPTS : " + counter);


    }


}
