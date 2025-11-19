package Assignments.ExpenseTracker;


import java.time.LocalDate;

public class Expense {
    private LocalDate date;
    private String category;
    private double amount;
    private String note;

    public Expense(LocalDate date, String category, double amount, String note) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }

    public LocalDate getDate() { return date; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getNote() { return note; }

    // Convert Expense to a text line to save in file
    public String toText() {
        return date + "|" + category + "|" + amount + "|" + note;
    }

    // Create an Expense object from a line in the file
    public static Expense fromText(String line) {
        String[] data = line.split("\\|");
        LocalDate d = LocalDate.parse(data[0]);
        String c = data[1];
        double a = Double.parseDouble(data[2]);
        String n = data[3];
        return new Expense(d, c, a, n);
    }

    @Override
    public String toString() {
        return date + "   " + category + "   ₹" + amount + "   " + note;
    }
}
