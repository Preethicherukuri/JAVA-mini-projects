package Assignments.ExpenseTracker;


import java.io.*;
import java.util.*;


public class ExpenseManager {

    private List<Expense> list = new ArrayList<>();

    // Load expenses from file
    public void load(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                Expense e = Expense.fromText(line);
                list.add(e);
            }

        } catch (IOException e) {
            System.out.println("No previous file found. A new file will be created.");
        }
    }

    // Save all expenses to file
    public void save(String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Expense e : list) {
                bw.write(e.toText());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Add a new expense
    public void addExpense(Expense e) {
        list.add(e);
    }

    // Return all expenses
    public List<Expense> getAll() {
        return list;
    }

    // Monthly summary total
    public double monthlyTotal(int month, int year) {

        return list.stream()
                .filter(e -> e.getDate().getMonthValue() == month &&
                             e.getDate().getYear() == year)
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // Category-wise totals
    public Map<String, Double> categoryWise() {

        Map<String, Double> map = new HashMap<>();

        for (Expense e : list) {
            map.put(e.getCategory(),
                    map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }
        return map;
    }
}
