package Assignments.ToDoList;

import java.io.*;
import java.util.*;


public class Main {

    private static HashMap<Integer, Task> tasks = new HashMap<>();
    private static ArrayList<Integer> order = new ArrayList<>();
    private static int currentId = 1;

    private static final String FILE_PATH = "Assignments/ToDoList/tasks.txt";

    public static void main(String[] args) {
        loadTasks();
        showMenu();
    }

    // ---------------- MENU ----------------
    public static void showMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TO-DO LIST MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Save Tasks");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addTask(sc);
                case 2 -> viewTasks();
                case 3 -> updateTask(sc);
                case 4 -> deleteTask(sc);
                case 5 -> markCompleted(sc);
                case 6 -> saveTasks();
                case 7 -> { saveTasks(); System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ---------------- CRUD OPERATIONS ----------------

    public static void addTask(Scanner sc) {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter task description: ");
        String description = sc.nextLine();

        Task task = new Task(currentId, title, description, false);
        tasks.put(currentId, task);
        order.add(currentId);

        System.out.println("Task added successfully with ID: " + currentId);
        currentId++;
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\n===== YOUR TASKS =====");
        for (int id : order) {
            System.out.println(tasks.get(id));
        }
    }

    public static void updateTask(Scanner sc) {
        System.out.print("Enter Task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!tasks.containsKey(id)) {
            System.out.println("Task not found.");
            return;
        }

        Task task = tasks.get(id);

        System.out.print("Enter new title: ");
        task.title = sc.nextLine();

        System.out.print("Enter new description: ");
        task.description = sc.nextLine();

        System.out.println("Task updated successfully.");
    }

    public static void deleteTask(Scanner sc) {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!tasks.containsKey(id)) {
            System.out.println("Task not found.");
            return;
        }

        tasks.remove(id);
        order.remove((Integer) id);

        System.out.println("Task deleted successfully.");
    }

    public static void markCompleted(Scanner sc) {
        System.out.print("Enter Task ID to mark as completed: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!tasks.containsKey(id)) {
            System.out.println("Task not found.");
            return;
        }

        tasks.get(id).completed = true;
        System.out.println("Task marked as completed!");
    }

    // ---------------- FILE I/O ----------------

    public static void loadTasks() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No existing tasks file found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String description = parts[2];
                boolean completed = parts[3].equalsIgnoreCase("Completed");

                Task task = new Task(id, title, description, completed);
                tasks.put(id, task);
                order.add(id);

                currentId = Math.max(currentId, id + 1);
            }

            System.out.println("Tasks loaded successfully.");

        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public static void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {

            for (int id : order) {
                Task t = tasks.get(id);

                writer.println(
                        t.id + "|" +
                        t.title + "|" +
                        t.description + "|" +
                        (t.completed ? "Completed" : "Pending")
                );
            }

            System.out.println("Tasks saved successfully!");

        } catch (Exception e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}

