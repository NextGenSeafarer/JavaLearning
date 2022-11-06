package GamesAndSmallPrograms.EncoderAndDecoder;

public class EncoderDecoderTest {
    public static void main(String[] args) {

/*
        Encoder - принимает txt файл со смешанными данными, словами, цифрами, символами
        Для цифр - прибавляет 5, умножает на 12, вычитает 1
        для букв - смещает их по ASCII таблице на 5 символов вперед, меняет нижний регистр на верхний
        для символов - смещает их на 3 назад по таблице

        Команды для userInput:
        p - to enter path
        e - to encode
        d - to decode
        exit - to exit
        E:\02.Java_projects\Testing_garbage\Trash_tasting\src\GamesAndSmallPrograms\EncoderAndDecoder\testFiles\test1.txt

*/


        UserInput.userIn();
        System.out.println(UserInput.getStringBuffer().toString());

    }
}
