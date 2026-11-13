import java.io.*;
import java.util.*;

public class Todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "todo_list.txt";
        int added = 0;
        ArrayList<String> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) tasks.add(line);
        } catch (FileNotFoundException e) {
            System.out.println("No previous tasks");
        } catch (IOException e) { System.out.println(e.getMessage()); }
        System.out.println("Existing tasks: " + tasks.size());

        while (true) {
            System.out.println("Enter task, delete or exit:");
            String text = scanner.nextLine();
            if (text.equalsIgnoreCase("exit")) {
                System.out.println("Tasks added this run: " + added);
                break;
            }
            if (text.trim().isEmpty()) {
                System.out.println("Task cannot be empty");
                continue;
            }
            if (text.equalsIgnoreCase("delete")) {
                try {
                    for (int i = 0; i < tasks.size(); i++) System.out.println((i + 1) + ". " + tasks.get(i));
                    System.out.println("Enter index (starting from 1):");
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index < 1 || index > tasks.size()) {
                        System.out.println("Invalid index");
                        continue;
                    }
                    tasks.remove(index - 1);
                    try (FileWriter writer = new FileWriter(fileName)) {
                        for (String task : tasks) writer.write(task + System.lineSeparator());
                    }
                    System.out.println("Task deleted");
                } catch (NumberFormatException e) {
                    System.out.println("Index must be a number");
                } catch (IOException e) { System.out.println(e.getMessage()); }
                continue;
            }
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(text + System.lineSeparator());
                tasks.add(text);
                added++;
                System.out.println("Task added");
            } catch (IOException e) { System.out.println(e.getMessage()); }
        }
        scanner.close();
    }
}
