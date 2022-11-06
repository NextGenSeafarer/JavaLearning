package lesson0.Basics.StringAndStringBuilder;

public class StringBuilderHomeWork {


    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Privet");
        StringBuilder sb2 = new StringBuilder("Privet");
        EqualsForStringBuilder check = new EqualsForStringBuilder();
        System.out.println("Is sb & sb2 equals? : " + check.isEqual(sb, sb2));

    }


}

class EqualsForStringBuilder {
    public boolean isEqual(StringBuilder sb1, StringBuilder sb2) {
        return sb1.toString().equals(sb2.toString());
    }


}