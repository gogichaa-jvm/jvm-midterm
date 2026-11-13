import java.io.*;
import java.util.*;

public class LibraryProcessing {
    private final String fileName = "books.txt";

    public void addBook(LibraryBook book) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(book.getTitle() + ";" + book.getAuthor() + ";" + book.getIsbn() + System.lineSeparator());
            System.out.println("Book added");
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public void printBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) System.out.println(line);
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public void findBookByIsbn(String isbn) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", -1);
                if (parts.length == 3 && parts[2].equals(isbn)) {
                    System.out.println("Found: " + line);
                    return;
                }
            }
            System.out.println("Book not found");
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    public void deleteBookByTitleOrIndex(String titleOrIndex) {
        ArrayList<String> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) books.add(line);
        } catch (IOException e) { System.out.println(e.getMessage()); return; }
        int index = -1;
        try {
            int number = Integer.parseInt(titleOrIndex);
            if (number >= 1 && number <= books.size()) index = number - 1;
        } catch (NumberFormatException e) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).split(";", -1)[0].equalsIgnoreCase(titleOrIndex)) { index = i; break; }
            }
        }
        if (index < 0) { System.out.println("Book not found"); return; }
        books.remove(index);
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String book : books) writer.write(book + System.lineSeparator());
            System.out.println("Book deleted");
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }
}
