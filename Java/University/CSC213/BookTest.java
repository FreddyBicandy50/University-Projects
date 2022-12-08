import java.util.Scanner;
public class BookTest {
    public static void main(String[] args) {
        String[] arr = { "Freddy", "Charbel", "Elie" };
        Book book = new Book("hello", 500, arr);
        System.out.println(book.toString());
        book.deleteAuthor("Charbel");
        System.out.println(book.toString());
    }
}