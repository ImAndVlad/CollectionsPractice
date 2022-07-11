package app.appCats;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String address;
    static List<Cat> cats;
    static int num;

    public static void main(String[] args) {
        address = "the homeless";
        Cat cat1 = new Cat(address);
        cat1.name = "Cat1";

        Cat cat2 = new Cat(address);
        cat2.name = "Cat2";

        Cat cat3 = new Cat(address);
        cat3.name = "Cat3";

        Cat cat4 = new Cat(address);
        cat4.name = "Cat4";

        Cat cat5 = new Cat(address);
        cat5.name = "Cat5";

        cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        System.out.println("---CATS LIST---");
        System.out.println(cats);

        System.out.println(eat(cats));
    }

    public static List<Cat> eat(List<Cat> list) {
        showMenu();

        for (Cat cat : list) {
            cat.address = address;
        }
        return list;
    }

    private static void showMenu() {
        switch (getNum()) {
            case 1 -> address = "Kyiv";
            case 2 -> address = "Odesa";
            case 3 -> address = "Kharkiv";
            default -> eat(cats);
        }
    }

    private static int getNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                ---
                Enter a number to select the city
                1 - Kyiv
                2 - Odesa
                3 - Kharkiv
                Enter:\040
                """);
        return num = sc.nextInt();
    }
}
