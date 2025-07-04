import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String content;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private char correctAns;

    Question(String content, String option1, String option2, String option3, String option4, char correctAns) {
        this.content = content;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = Character.toUpperCase(correctAns);
    }

    public void displayQuestion() {
        System.out.println("\n" + content);
        System.out.println("A. " + option1);
        System.out.println("B. " + option2);
        System.out.println("C. " + option3);
        System.out.println("D. " + option4);
    }

    public boolean isCorrect(char ans) {
        return Character.toUpperCase(ans) == correctAns;
    }

    public char getCorrectAns() {
        return correctAns;
    }

    public String getCorrectOption() {
        switch (correctAns) {
            case 'A':
                return option1;
            case 'B':
                return option2;
            case 'C':
                return option3;
            case 'D':
                return option4;
            default:
                return "";
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();

        // 10 Java-based Questions
        questions.add(new Question("1. Java programming language was developed by?", "James Gosling", "Dennis Ritchie",
                "Bjarne Stroustrup", "Guido van Rossum", 'A'));
        questions.add(new Question("2. What is the size of int in Java?", "2 bytes", "4 bytes", "8 bytes",
                "Depends on OS", 'B'));
        questions.add(
                new Question("3. Which of the following is not a Java keyword?", "class", "new", "goto", "main", 'D'));
        questions.add(new Question("4. What does JVM stand for?", "Java Variable Method", "Java Virtual Machine",
                "Java Verified Mode", "Java Visual Maker", 'B'));
        questions.add(new Question("5. Which of these is used to create objects in Java?", "new", "class", "this",
                "void", 'A'));
        questions.add(new Question("6. Which method is the entry point of a Java program?", "start()", "run()",
                "main()", "init()", 'C'));
        questions.add(new Question("7. Which of the following is not a primitive data type in Java?", "int", "float",
                "String", "boolean", 'C'));
        questions.add(new Question("8. What is the default value of a boolean variable in Java?", "true", "false",
                "null", "0", 'B'));
        questions.add(new Question("9. Which of these packages contains the Scanner class?", "java.io", "java.util",
                "java.lang", "java.net", 'B'));
        questions.add(new Question("10. Which operator is used to compare two values?", "=", "==", "!=", "<>", 'B'));

        int score = 0;

        System.out.println("Welcome to the Java Quiz!");
        System.out.println("Choose the correct option (A, B, C, D).");

        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer: ");
            char ans = sc.next().charAt(0);

            if (q.isCorrect(ans)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. Correct Answer: " + q.getCorrectAns() + ". " + q.getCorrectOption());
            }
        }

        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());

        sc.close();
    }
}
