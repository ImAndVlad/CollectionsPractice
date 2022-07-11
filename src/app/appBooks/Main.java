package app.appBooks;

import java.util.*;

public class Main {

    static Map<String, List<Book>> mapBooks;

    public static void main(String[] args) {
        System.out.println("---MINI LIBRARY---");

        mapBooks = new HashMap<>();
        mapBooks.put("Bruce Eckel", booksEckel());
        mapBooks.put("Robert Martin", booksMartin());
        mapBooks.put("Arthur Conan-Doyle", booksConanDoyle());

        System.out.println("Books:" + listBooksByAuthors(mapBooks));
    }

    // method that returns a list of books by author
    private static Set<Book> listBooksByAuthors(Map<String, List<Book>> map) {
        Set<Book> books = new HashSet<>();
        switch (getNum()) {
            case 1 -> books.addAll(map.get("Bruce Eckel"));
            case 2 -> books.addAll(map.get("Robert Martin"));
            case 3 -> books.addAll(map.get("Arthur Conan-Doyle"));
            default -> listBooksByAuthors(mapBooks);
        }
        return books;
    }

    // menu
    private static int getNum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Enter a number to select an author
                1 - Bruce Eckel
                2 - Robert Martin
                3 - Arthur Conan-Doyle
                ENTER:\040
                """);

        return scanner.nextInt();
    }

    // list 1
    private static List<Book> booksEckel() {
        List<Book> listEckel = new ArrayList<>();
        listEckel.add(new Book("Thinking in Java"));
        listEckel.add(new Book("Thinking in C++"));
        listEckel.add(new Book("Atomic Kotlin"));

        return listEckel;
    }

    // list 2
    private static List<Book> booksMartin() {
        List<Book> listMartin = new ArrayList<>();
        listMartin.add(new Book("The Perfect Programmer"));
        listMartin.add(new Book("Clean Code"));
        listMartin.add(new Book("The Art of Software Development"));
        listMartin.add(new Book("Clean Architecture"));

        return listMartin;
    }

    // list 3
    private static List<Book> booksConanDoyle() {
        List<Book> listConanDoyle = new ArrayList<>();
        listConanDoyle.add(new Book("The Memoirs of Sherlock Holmes"));
        listConanDoyle.add(new Book("The Hound of the Baskervilles"));
        listConanDoyle.add(new Book("Lost World"));
        listConanDoyle.add(new Book("The Sign of the Four"));
        listConanDoyle.add(new Book("The Stark Munro Letters"));

        return listConanDoyle;
    }
}
