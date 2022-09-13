package GamesAndSmallPrograms.MyFirstCalculatorArabicAndRomeNumbers;

class letsCalculate {
    private int firstNumber;
    private int secondNumber;
    private int result;
    private String operation;
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }



    public int resultOfCalculation() {
        switch (operation) {
            case "+" -> result = getFirstNumber() + getSecondNumber();
            case "-" -> result = getFirstNumber() - getSecondNumber();
            case "*" -> result = getFirstNumber() * getSecondNumber();
            case "/" -> result = getFirstNumber() / getSecondNumber();
        }
        return result;
    }

}
