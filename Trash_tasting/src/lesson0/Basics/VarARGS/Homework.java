package lesson0.Basics.VarARGS;


import java.util.Arrays;

public class Homework {

    public static void main(String... args) {


        System.out.println("Args len: " + args.length);
        Homework hw = new Homework();
        String[] str1 = {"samsung", "xiaomi"};
        String[] str2 = {"apple", "hp"};
        String[] str3 = {"macBook", "xiaomiPad", "iPhone"};
        String[] s = hw.abc(str1, str2, str3);
        String[] result = Arrays.copyOf(s, s.length);

        for (int i = 0; i < s.length; i++) {
            for (String arg : args) {
                if (s[i].equals(arg)) {
                    result[i] = null;
                }
            }
        }

        for (String st : result) {
            System.out.println(st);
        }


    }

    public String[] abc(String[]... str) {

        int len = 0;

        for (String[] strings : str) {
            len += strings.length;
        }

        String[] array = new String[len];
        int a = 0;

        for (String[] strings : str) {
            for (String string : strings) {
                array[a] = string;
                a++;
            }
        }

        return array;
    }


}

