public class Main {
    public static void main(String[] args) { task2(); }
    public static void task2() {
        LibraryProcessing library = new LibraryProcessing();
        library.addBook(new LibraryBook("Java Basics", "Teacher", "123"));
        library.printBooks();
        library.findBookByIsbn("123");
        library.deleteBookByTitleOrIndex("Java Basics");
    }
}
