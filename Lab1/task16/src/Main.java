import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> bookArrayList = new TreeSet<Book>();

        Book Book1 = new Book("book1");
        Book1.setAuthor("bauthor1");
        Book1.setPrice(100);
        Book1.setEdition(2);
        Book1.setISBN(123);

        System.out.println(Book1);

        Book Book2 = new Book("aook1");
        Book2.setAuthor("cauthor1");
        Book2.setPrice(200);
        Book2.setEdition(2);
        Book2.setISBN(135);

        System.out.println(Book2);

        Book Book3 = new Book("aaok1");
        Book3.setAuthor("author1");
        Book3.setPrice(50);
        Book3.setEdition(2);
        Book3.setISBN(100);

        System.out.println(Book3);

        bookArrayList.add(Book1);
        bookArrayList.add(Book2);
        bookArrayList.add(Book3);

        if (Book1.equals(Book2)){
            System.out.println("Equals");
        }
        else{
            System.out.println("NOT Equals");
        }

        // Print before sort
        System.out.println("");
        System.out.println("Before sort");
        for (Book h: bookArrayList) {
            System.out.println(h);
        }
        System.out.println("");
        System.out.println("After sort");

        // Sort by title
        List<Book> sSort = bookArrayList.stream().sorted(Comparator.comparing(b -> b.getTitle(b))).collect(Collectors.toList());
        System.out.println("");
        System.out.println("Sort by Title");
        for (Book h: sSort) {
            System.out.println(h);
        }

        // Sort by title & author
        sSort = bookArrayList.stream().sorted(Comparator.comparing(b -> b.getAuthor())).collect(Collectors.toList());
        System.out.println("");
        System.out.println("Sort by Title & Author");
        for (Book h: sSort) {
            System.out.println(h);
        }

        // Sort by author & title
        sSort = bookArrayList.stream().sorted(Comparator.comparing(b -> b.getTitle(b))).collect(Collectors.toList());
        System.out.println("");
        System.out.println("Sort by Author & Title");
        for (Book h: sSort) {
            System.out.println(h);
        }

        // Sort by author & title & price
        System.out.println("");
        System.out.println("Sort by Author & Title & Price");
        bookArrayList.stream().sorted(Book.comparatorBookPrice);

        for (Book h: bookArrayList) {
            System.out.println(h);
        }
    }
}
