package lesson0.Basics.Arrays;

public class ArraysHomeWork2 {


    public static void main(String[] args) {

        String[][] test = {{"Apple", "Samsung", "Asus", "Acer"}, {"HP", "Xiaomi", "Redmi"}};
        ArrayPrint.showArray(test);


    }

}

class ArrayPrint {
    public static void showArray(String[][] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    System.out.print("{" + arr[i][j] + "}");
                    break;
                }
                System.out.print("{" + arr[i][j] + "}" + ", ");
            }
            if (i != arr.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.print("}");
    }

}
