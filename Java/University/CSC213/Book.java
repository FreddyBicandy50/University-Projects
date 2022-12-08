import java.util.Arrays;

public class Book {
    String name;
    int nbPages;
    String[] authors = new String[10];
    int authorsIndex = 0;

    public Book(String n, int nb) {
        this.name = n;
        this.nbPages = nb;
    }

    public Book(String n, int nb, String[] authors) {
        this.name = n;
        this.nbPages = nb;
        this.authors = Arrays.copyOf(authors, authors.length);
        authorsIndex = authors.length - 1;
    }

    public void addAuthor(String author) {
        authors[authorsIndex] = author;
        authorsIndex++;
    }

    public void deleteAuthor(String author) {
        String[] arr_new = new String[authors.length - 1];
        for (int i = 0, k = 0; i < this.authors.length; i++, k++) {
            if (this.authors[i].equals(author)) {
                k--;
                continue;
            }
            arr_new[k] = this.authors[i];
        }
        this.authors = Arrays.copyOf(arr_new, arr_new.length);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", nbPages=" + nbPages +
                ", authors=" + Arrays.toString(authors) +
                ", authorsIndex=" + authorsIndex +
                '}';
    }

}