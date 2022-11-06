package lesson0.Basics.StringAndStringBuilder;

public class StringHomework {

    public static void email(String input) {

        String[] split = input.split(";");
        for (String s: split){
            System.out.println(s.replaceAll("\\w+@","").replaceAll("\\.\\w+","").strip());
        }

    }

    public static void main(String[] args) {
        email("ya@yahoo.com; on@mail.ru    ;    ona@gmail.com");

    }

}
