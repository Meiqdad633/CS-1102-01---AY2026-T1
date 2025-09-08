import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner input = new Scanner(System.in);
        
        // Initialize variables
        int score = 0;
        String answer;

        // Question 1
        System.out.println("1. What is the capital of France?");
        System.out.println("A) Berlin  B) Madrid  C) Paris  D) Rome");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();
        switch(answer) {
            case "C": score++; break;
            case "A": case "B": case "D": break;
            default: System.out.println("Invalid input."); break;
        }

        // Question 2
        System.out.println("\n2. Which planet is known as the Red Planet?");
        System.out.println("A) Earth  B) Mars  C) Jupiter  D) Venus");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();
        if(answer.equals("B")) {
            score++;
        } else if(!answer.equals("A") && !answer.equals("C") && !answer.equals("D")) {
            System.out.println("Invalid input.");
        }

        // Question 3
        System.out.println("\n3. What is 5 + 7?");
        System.out.println("A) 10  B) 11  C) 12  D) 13");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();
        if(answer.equals("C")) {
            score++;
        } else if(!answer.equals("A") && !answer.equals("B") && !answer.equals("D")) {
            System.out.println("Invalid input.");
        }

        // Question 4
        System.out.println("\n4. Which language is used for Android development?");
        System.out.println("A) Java  B) Python  C) C#  D) Swift");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();
        if(answer.equals("A")) {
            score++;
        } else if(!answer.equals("B") && !answer.equals("C") && !answer.equals("D")) {
            System.out.println("Invalid input.");
        }

        // Question 5
        System.out.println("\n5. Who wrote 'Romeo and Juliet'?");
        System.out.println("A) Charles Dickens  B) William Shakespeare  C) Mark Twain  D) Jane Austen");
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = input.nextLine().toUpperCase();
        if(answer.equals("B")) {
            score++;
        } else if(!answer.equals("A") && !answer.equals("C") && !answer.equals("D")) {
            System.out.println("Invalid input.");
        }

        // Calculate and display final score
        double percentage = (score / 5.0) * 100;
        System.out.println("\nYour final score is: " + score + "/5 (" + percentage + "%)");

        input.close();
    }
}
