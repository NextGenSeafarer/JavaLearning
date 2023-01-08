package lesson0.Basics.OOP;

public class Encapsulation {

    /*

    Encapsulation - один из принципов ООП, заключающийся в сокрытии данных и логики работы класса.
    Сокрытие может происходить за счет применения access modifiers (private в основном),
    передачи копии поля, вместо оригинального значения (применимо для геттеров mutable классов)
    Например, если имя в классе задается StringBuilder, тогда возвращая значение StringBuilder - его можно будет
    изменить в геттере, чего лучше избегать, поэтому:
    Если return type метода get является mutable - лучше возвращать копию.


    */


    public static void main(String[] args) {
        Human h1 = new Human();
        h1.setName(new StringBuilder("Ilia"));
        //System.out.println(h1.getName().append("!!!!!"));
        System.out.println(h1.getName2().append("222222"));
        System.out.println(h1.getName2());

    }

}

class Human {
    private StringBuilder name;

    public void setName(StringBuilder name) {
        this.name = name;
    }

    public StringBuilder getName() { // <- через такой геттер можно изменить имя, поэтому смысла от инкапсуляции нет
        return name;
    }

    public StringBuilder getName2() { // <- через такой геттер можно изменить только копию нашего поля, но само поле будет защищено
        StringBuilder sb = new StringBuilder(name);
        return sb;
    }

}