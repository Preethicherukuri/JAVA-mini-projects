package Assignments.QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private ArrayList<ArrayList<Question>> levels;
    private Scanner sc;

    public Quiz() {
        sc = new Scanner(System.in);
        levels = new ArrayList<>();
        loadLevels();
    }

    private void loadLevels() {

        // ---------------- Level 1 ----------------
        ArrayList<Question> level1 = new ArrayList<>();
        level1.add(new Question(
                "Which keyword is used to define a class in Java?",
                new String[]{"define", "class", "struct", "object"},
                1
        ));
        level1.add(new Question(
                "Which symbol is used to end a Java statement?",
                new String[]{"Colon", "Comma", "Semicolon", "Period"},
                2
        ));
        level1.add(new Question(
                "Which method is the entry point in Java?",
                new String[]{"start()", "run()", "main()", "execute()"},
                2
        ));

        // ---------------- Level 2 ----------------
        ArrayList<Question> level2 = new ArrayList<>();
        level2.add(new Question(
                "Which data type is used for TRUE/FALSE?",
                new String[]{"boolean", "int", "char", "float"},
                0
        ));
        level2.add(new Question(
                "Which operator is used for equality check?",
                new String[]{"=", "==", "===", "!="},
                1
        ));
        level2.add(new Question(
                "Which loop runs at least once?",
                new String[]{"for", "while", "do-while", "foreach"},
                2
        ));

        // ---------------- Level 3 ----------------
        ArrayList<Question> level3 = new ArrayList<>();
        level3.add(new Question(
                "Which OOP principle bundles data and methods?",
                new String[]{"Inheritance", "Polymorphism", "Encapsulation", "Abstraction"},
                2
        ));
        level3.add(new Question(
                "Which keyword is used to create an object?",
                new String[]{"new", "make", "object", "create"},
                0
        ));
        level3.add(new Question(
                "Which method is used to convert string to int?",
                new String[]{"Integer.parse()", "Integer.parseInt()", "toInt()", "convert()"},
                1
        ));

        // ---------------- Level 4 ----------------
        ArrayList<Question> level4 = new ArrayList<>();
        level4.add(new Question(
                "Which concept allows method overriding?",
                new String[]{"Encapsulation", "Polymorphism", "Abstraction", "Final classes"},
                1
        ));
        level4.add(new Question(
                "Which keyword prevents inheritance?",
                new String[]{"final", "sealed", "static", "lock"},
                0
        ));
        level4.add(new Question(
                "Which exception occurs when accessing index out of range?",
                new String[]{"NullPointerException", "IOException", "IndexOutOfBoundsException", "ArithmeticException"},
                2
        ));

        // ---------------- Level 5 ----------------
        ArrayList<Question> level5 = new ArrayList<>();
        level5.add(new Question(
                "JVM stands for:",
                new String[]{"Java Virtual Machine", "Java Variable Method", "Joint Virtual Module", "None"},
                0
        ));
        level5.add(new Question(
                "Which collection does NOT allow duplicates?",
                new String[]{"ArrayList", "LinkedList", "HashSet", "Vector"},
                2
        ));
        level5.add(new Question(
                "Which keyword is used for multiple catch blocks?",
                new String[]{"final", "throw", "throws", "catch"},
                3
        ));

        // Add all levels to main list
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
    }

    public void startQuiz() {
        System.out.println("\n=== JAVA MULTI-LEVEL QUIZ GAME ===");

        int totalScore = 0;

        for (int i = 0; i < levels.size(); i++) {
            System.out.println("\n-----------------------------------");
            System.out.println("           LEVEL " + (i + 1));
            System.out.println("-----------------------------------");

            int score = playLevel(levels.get(i));

            System.out.println("\nLevel " + (i + 1) + " Score: " + score + "/3");

            totalScore += score;

            if (score < 2) {
                System.out.println("😢 You must score at least 2 to unlock next level!");
                break;
            } else {
                System.out.println("🔥 Level passed! Moving to next level...");
            }
        }

        System.out.println("\n===========================");
        System.out.println(" FINAL SCORE: " + totalScore + "/15");
        System.out.println("===========================");

        if (totalScore == 15)
            System.out.println("🏆 Perfect! Java Champion!");
        else if (totalScore >= 10)
            System.out.println("✨ Great! You're strong in Java!");
        else if (totalScore >= 5)
            System.out.println("🙂 Good attempt! Keep practicing!");
        else
            System.out.println("📚 Study more and try again!");
    }

    private int playLevel(ArrayList<Question> questions) {
        int score = 0;

        for (Question q : questions) {
            System.out.println("\n" + q.getQuestion());

            String[] opts = q.getOptions();
            for (int i = 0; i < opts.length; i++) {
                System.out.println((i + 1) + ". " + opts[i]);
            }

            System.out.print("Your answer: ");
            int ans = sc.nextInt();

            if (ans - 1 == q.getCorrectIndex()) {
                System.out.println("✔ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + opts[q.getCorrectIndex()]);
            }
        }

        return score;
    }
}
