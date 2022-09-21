import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class myComparator implements Comparator<Book>, myNewComparator {
    private ArrayList<Book> books;

/*
    public void compareTo(Book b1, Book b2) {
        int comparedResult = b1.compareTo(b2);

        if (comparedResult > 0) {
            System.out.println(b1 + " less" + b2);
        } else if (comparedResult < 0) {
            System.out.println(b1 + " more " + b2);
        } else {
            System.out.println(b1 + " is equal to " + b2);
        }
    }
*/

    @Override
    public int compare(ArrayList<Book> books) {
        ArrayList<String> titleList = new ArrayList<String>();

        for (Book b: books) {
            titleList.add(b.getTitle(b));
        }

        Collections.sort(titleList);

        System.out.println("Sorted by the title: ");
        for (String bb: titleList) {
            System.out.print(bb + " ");
        }
        System.out.println("");
        System.out.println("Sorted by the title and author: ");

        for (Book b: books) {
            titleList.add(b.getAuthor());
        }

        Collections.sort(titleList);

        System.out.println("Sorted by the title: ");
        for (String bb: titleList) {
            System.out.print(bb + " ");
        }
        System.out.println("");
        System.out.println("Sorted by the title and author: ");

        return 0;
    }

}
