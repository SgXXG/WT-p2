import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> bookArrayList = new TreeSet<Book>();

        Book Book1 = new Book("book1");
        Book1.setAuthor("author1");
        Book1.setPrice(100);
        Book1.setEdition(2);
        Book1.setISBN(123);

        System.out.println(Book1);

        Book Book2 = new Book("aook1");
        Book2.setAuthor("author1");
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

        System.out.println("");
        System.out.println("Before sort");
        for (Book h: bookArrayList) {
            System.out.println(h);
        }

        System.out.println("");
        System.out.println("After sort");
        bookArrayList.stream().sorted(Book.comparatorBookPrice);

        for (Book h: bookArrayList) {
            System.out.println(h);
        }

    }
}
