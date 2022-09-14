public class ProgrammerBook extends Book {

    public ProgrammerBook(String name) {
        super(name);
    }

    private String language;
    private Integer level;

    public String getLanguage(){ return language; }
    public void setLanguage(String language) {this.language= language;}

    public int getLevel() {return level;}
    public void setLevel(int level) {this.level= level;}

    @Override
    public String toString() {
        return "Book{ " + "language: " + language + ", level: " + level +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProgrammerBook programmerBook = (ProgrammerBook) o;

        if (language != null ? !language.equals(programmerBook.language):programmerBook.language != null) return false;

        if (level != null ? !level.equals(programmerBook.level) : programmerBook.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + level;

        return result;
    }
}
