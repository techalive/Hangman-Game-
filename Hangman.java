package HomeWork_1;

import java.util.Random;
import java.util.Scanner;

public class Hangman {

    static String[] passwords;
    static String pwdToGuess;
    static int numberOfPasswords;

    public static void main(String[] args) {

        generatePasswords();
        getPasswordsToScreen();
        getRandomPasswordFromTable();
        findProperPasswordFromQuerry();

    }

    private static void generatePasswords() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many passwords add to make book of passwords?: ");
        numberOfPasswords = scanner.nextInt();
        passwords = new String[numberOfPasswords];
        System.out.println("Make a passwords book. One from them will be to find!");
        System.out.println("Ready to start? Enter " + numberOfPasswords + " different passwords: ");
        scanner.nextLine();     //consumption of null character
        for (int i = 0; i < passwords.length; i++) {

            passwords[i] = scanner.nextLine();
        }
    }

    private static void getPasswordsToScreen() {
        System.out.println("OK. Got of these passwords. Keep it in secret: ");
        for (int i = 0; i < passwords.length; i++) {
            System.out.println(i + ".) " + passwords[i]);
        }
    }

    private static void getRandomPasswordFromTable() {
        int random = new Random().nextInt(passwords.length);
        pwdToGuess = passwords[random];
        System.out.println("Random password to guess is: " + pwdToGuess);
    }

    private static void findProperPasswordFromQuerry() {
        int livesInGame = 5;
        int scoreInGame = 0;

        do {
            System.out.println("Guess what is the password? Remember: Enter ONLY one letter AND don't guess the same letter twice! Put any letter from guessing password: ");
            Scanner scanner = new Scanner(System.in);
            String anyLetterFromGuessingPwd = scanner.nextLine();

            if (anyLetterFromGuessingPwd.length() > 1) {
                System.err.println("GAMEOVER");
                break;
            } else if (pwdToGuess.contains(anyLetterFromGuessingPwd)) {
                scoreInGame++;
                System.out.println("You are in good trace! Letter " + anyLetterFromGuessingPwd + " is in guessing password!!! You have now " + scoreInGame + " scores!");
                if (scoreInGame == pwdToGuess.length()) {
                    System.err.println("Congratulations! It was " + pwdToGuess.toUpperCase() + ". YOU WON THE GAME!!!");
                    break;
                }
            }

            if (!pwdToGuess.contains(anyLetterFromGuessingPwd) || anyLetterFromGuessingPwd.equals("")) {
                livesInGame--;
                System.out.println("You lost 1 lives. Now you have: " + livesInGame + " lives.");

            }

        }
        while (livesInGame > 0);
        System.err.println("GAMEOVER");
    }
}