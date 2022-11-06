package GamesAndSmallPrograms.EncoderAndDecoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Encoder {

    private static String encodingString;
    private static List<String> list;

    public static String letsEncode(String encodingString) {
        list = new ArrayList<>();
        for (int i = 0; i < encodingString.length(); i++) {
            list.add(encodingString.substring(i, i + 1));
        }


        list = list.stream().map(x ->
        {
            if (x.matches("\\d")) {
                System.out.println("NUMBER");
                x = String.valueOf((Integer.parseInt(x) + 5) * 12 - 1);

            }
            ;
            if (x.matches("[A-Za-zА-Яа-я]")) {
                System.out.println("LETTER");
            }
            ;
            return x;
        }).collect(Collectors.toList());

        return list.toString();
    }


}
