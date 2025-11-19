package Assignments.ExpenseTracker;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static final String FILE = "Assignments/ExpenseTracker/expenses.txt";
    private static ExpenseManager manager = new ExpenseManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        manager.load(FILE); // load existing data

        while (true) {
            System.out.println("\n==== EXPENSE TRACKER ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Monthly Summary");
            System.out.println("4. Category Summary");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> addExpenseUI();
                case 2 -> viewAllUI();
                case 3 -> monthSummaryUI();
                case 4 -> categorySummaryUI();
                case 5 -> {
                    manager.save(FILE);
                    System.out.println("Saved! Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addExpenseUI() {
        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Category: ");
        String cat = sc.nextLine();

        System.out.print("Amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();

        System.out.print("Note: ");
        String note = sc.nextLine();

        Expense ex = new Expense(date, cat, amt, note);
        manager.addExpense(ex);

        manager.save(FILE);

        System.out.println("Added successfully!");
    }

    private static void viewAllUI() {
        System.out.println("\n--- ALL EXPENSES ---");
        for (Expense e : manager.getAll()) {
            System.out.println(e);
        }
    }

    private static void monthSummaryUI() {
        System.out.print("Enter month (1–12): ");
        int m = sc.nextInt();

        System.out.print("Enter year: ");
        int y = sc.nextInt();

        double total = manager.monthlyTotal(m, y);
        System.out.println("Total spent in " + m + "/" + y + " = ₹" + total);
    }

    private static void categorySummaryUI() {
        System.out.println("\n--- CATEGORY SUMMARY ---");
        Map<String, Double> map = manager.categoryWise();

        for (String cat : map.keySet()) {
            System.out.println(cat + " : ₹" + map.get(cat));
        }
    }
}
