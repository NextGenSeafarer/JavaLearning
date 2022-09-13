package GamesAndSmallPrograms.RockPaperScissors;

public class RockPaperScissorsTest {
/*
    Классическая игра камень, ножницы, бумага.
    Игра против компьютера, где игра идет до ввода exit в консоль
    При этом можно посмотреть счет вводом в консоль score, автоматически выводится после завершения программы (exit)
    0 - rock
    1 - paper
    2 - scissors
*/

    public static void main(String[] args) {
        UserInputRockPaperScissors userInputRockPaperScissors = new UserInputRockPaperScissors();
        RockPaperScissorsText.textToShowBeginning();

        while (true) {
            userInputRockPaperScissors.userInputCheck();
            if (userInputRockPaperScissors.isNeedToFinish()) {
                RockPaperScissorsText.textToShowIfEnd();
                return;
            }
            WinnerCheck.winnerShow();
        }

    }
}
