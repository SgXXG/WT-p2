public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private Integer price;
    private static Integer edition;
    private Integer isbn;

    public Book(String name){
        this.title = name;
    }

    public String getTitle(){ return title; }
    public void setTitle(String name) {this.title = name;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public int getEdition() { return edition; }
    public void setEdition(int edition) {this.edition = edition; }

    public int getISBN() { return isbn; }
    public void setISBN(int isbn) {this.isbn = isbn; }

    @Override
    public String toString() {
        return "Book{ " + "title: " + title + ", author: " + author + ", price: " + price + ", edition: " + edition + ", isbn: " + isbn + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title):book.title != null) return false;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;

        if (price != null ? !price.equals(book.price) : book.price != null) return false;

        if (edition != null ? !edition.equals(book.edition) : book.edition != null) return false;

        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + price;
        result = prime * result + edition;
        result = prime * result + isbn;

        return result;
    }

    public int compareTo(Book anotherBook)
    {
        if (this.isbn == anotherBook.isbn) {
            return 0;
        } else if (this.isbn < anotherBook.isbn) {
            return -1;
        } else {
            return 1;
        }
    }
}
