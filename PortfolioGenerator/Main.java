package Assignments.PortfolioGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== PORTFOLIO GENERATOR ===\n");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter About You: ");
        String about = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.print("Enter skills (comma separated): ");
        String skills = sc.nextLine();

        System.out.print("Enter projects (comma separated): ");
        String projects = sc.nextLine();

        PortfolioData data = new PortfolioData(name, about, email, phone, skills, projects);
        PortfolioBuilder builder = new PortfolioBuilder();

        String fileName = "portfolio.html";
        builder.build(data, fileName);
        builder.open(fileName);

        System.out.println("\nPortfolio generated successfully!");
        sc.close();
    }

}
