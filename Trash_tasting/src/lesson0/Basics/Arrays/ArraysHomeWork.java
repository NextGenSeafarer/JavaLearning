package lesson0.Basics.Arrays;

import java.util.Arrays;

public class ArraysHomeWork {


    public static void main(String[] args) {

        int[] test = {15,16,19,22,47,-54,-66,-100,1,2};

        System.out.println(Arrays.toString(ArraySorting.sorting(test)));

    }


}

class ArraySorting {

    public static int[] sorting(int[] array) {

        int inter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    inter = array[i];
                    array[i] = array[j];
                    array[j] = inter;
                }
                if(array[j] < array[i]){
                    inter = array[j];
                    array[j] = array[i];
                    array[i] = inter;
                }
            }
        }
        return array;


    }


}
