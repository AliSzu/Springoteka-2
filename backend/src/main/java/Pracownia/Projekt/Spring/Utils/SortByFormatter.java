package Pracownia.Projekt.Spring.Utils;

public class SortByFormatter {
    public static String bookCopySortFormatter(String sort) {
        if (sort.equals("author")) {
            return "book.author.name";
        } else if (sort.equals("title")) {
            return "book.title";
        }
        return sort;
    }
}
