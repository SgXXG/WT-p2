public class Main {
    public static void main(String[] args) {

        Book Book1 = new Book("book1");
        Book1.setAuthor("author1");
        Book1.setPrice(100);
        Book1.setEdition(2);

        System.out.println(Book1);

        Book Book2 = new Book("book1");
        Book2.setAuthor("author1");
        Book2.setPrice(200);
        Book2.setEdition(2);

        System.out.println(Book2);

        if (Book1.equals(Book2)){
            System.out.println("Equals");
        }
        else{
            System.out.println("NOT Equals");
        }

        Book Book3 = Book2.clone();
        System.out.println(Book3);
    }
}