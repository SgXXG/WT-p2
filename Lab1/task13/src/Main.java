public class Main {
    public static void main(String[] args) {

        ProgrammerBook Book1 = new ProgrammerBook("book1");
        Book1.setLanguage("Eng");
        Book1.setLevel(2);

        System.out.println(Book1);

        ProgrammerBook Book2 = new ProgrammerBook("book1");
        Book2.setLanguage("Rus");
        Book2.setLevel(1);

        System.out.println(Book2);

        if (Book1.equals(Book2)){
            System.out.println("Equals");
        }
        else{
            System.out.println("NOT Equals");
        }

    }
}

