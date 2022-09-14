public class Book implements Cloneable {
    private String title;
    private String author;
    private Integer price;
    private static Integer edition;

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

    @Override
    public String toString() {
        return "Book{ " + "title: " + title + ", author: " + author + ", price: " + price + ", edition: " + edition + '}';
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

        return result;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
