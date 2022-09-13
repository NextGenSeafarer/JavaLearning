package lesson6.LambdaExpressions.lambdaSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SeafarersSorting {
    private String name;
    private String surname;
    private String nationality;
    private int id;
    private String position;


    public SeafarersSorting(String name, String surname, String nationality, int id, String position) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.id = id;
        this.position = position;
    }

    @Override
    public String toString() {
        return "SeafarersSorting{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", id=" + id +
                ", position=" + position +
                '}';
    }


    public static void main(String[] args) {

        ArrayList<SeafarersSorting> seafarersList = new ArrayList<>();
        seafarersList.add(new SeafarersSorting("Ilia", "Poch", "Rus", 21232, "2nd Eng"));
        seafarersList.add(new SeafarersSorting("Cabayan", "Any", "Fil", 12030, "MTM"));
        seafarersList.add(new SeafarersSorting("Krokazhanin", "Obichnii", "Cr", 18000, "Wiper"));
        seafarersList.add(new SeafarersSorting("Dmitrii", "Lunch", "Brit", 13434, "CE"));

        Collections.sort(seafarersList, new Comparator<SeafarersSorting>() {
            @Override
            public int compare(SeafarersSorting sailor1, SeafarersSorting sailor2) {
                return sailor1.id - sailor2.id;
            }
        });
        System.out.println(seafarersList);
        // Имплементация через анонимный класс с 1 функциональным интерфейсом (метод compare принимает в себя 2 объекта sailor1 и sailor2)
        // далее напишем то же самое через лямбда выражение
        System.out.println("--------------------------------------------------------------------");

        Collections.sort(seafarersList, (sailor1, sailor2) -> sailor1.id - sailor2.id); // самая краткая форма
        System.out.println(seafarersList);
        System.out.println("--------------------------------------------------------------------");
        Collections.sort(seafarersList, (SeafarersSorting sailor1, SeafarersSorting sailor2) -> {
            return sailor1.id - sailor2.id;
        });
        // форма длиннее, с наличием типа передаваемого объекта
        System.out.println(seafarersList);
        System.out.println("--------------------------------------------------------------------");
        // один и тот же результат


    }


}
