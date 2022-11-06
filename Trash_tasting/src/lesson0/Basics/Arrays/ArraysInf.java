package lesson0.Basics.Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysInf {

    /*

    Массивы - это последовательность элементов в строгом порядке, определенного типа, может быть и примитивного и
    ссылочного типа.
    int [] a = new int[5]; - массив int переменных, размером 5
    StringBuilder [] sbArray = new StringBuilder[3]; - массив из StringBuilder, состоящий из 3 элементов

    Этапы создания массива:
    1. Declaration;
    2. Allocation;
    3. Initialization (Может быть статической и динамической);

    1. int [] array; - declaration
    2. array = new int [5]; - allocation
    3. array[0] = 1; - initialization

    Объявление размерности массива может быть лишь единожды, либо как в примере выше, либо, если создание массива не
    разбивается на части
    int [] arr = {0,1,2,3,4}; - здесь все этапы совмещены в один
    Многомерные массивы могут быть разной длины, это достигается таким видом записи:
    int [][] twinArray = new int [3][]; - т.е. двумерный массив, состоящий из 3 одномерных массивов какой угодно длины
    int [][][] tripleArray = new int [2][3][]; - т.е. трехмерный массив, состоящий из 2 двумерных массивов, содержащий 3 одномерных массива различной длины

    int [] tripleArray [][] = new int[5][][]; - разрешенная запись
    int [][][] tripleArray = new int[5][][]; - разрешенная запись
    int [][] tripleArray [] = new int[5][][]; - разрешенная запись

    Класс Array - класс для взаимодействия и изменения массивов
    Из интересных методов:
    .sort()
    .asList()
    .stream()
    .toString()
    .binarySearch()
    .compare()
    .equals()







    */

    public static void main(String[] args) {
        Random random = new Random();

        int[][][] arr = new int[2][3][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    arr[i][j][k] = random.nextInt(0, 20);
                }
            }
        }
        System.out.println("Динамическая инициализация массива: \n");
        System.out.println(Arrays.deepToString(arr));

    }
}
