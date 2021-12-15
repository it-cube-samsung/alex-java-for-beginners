package bullsandcows;

import java.util.Scanner;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");
        int length = in.nextInt();
        if(length > 9){
            System.out.println("Max of length is 9.");
            return;
        }

        StringBuilder secNum = generateNumber(length);
        StringBuilder guessNum;

        int turn = 1;
        in.nextLine();

        int cow;
        int bull = 0;

        System.out.println("Okay, let's start a game!");

        while(bull != secNum.length()){
            System.out.println("Turn " + turn + ":");
            guessNum = new StringBuilder(in.nextLine());

            bull = figureBull(secNum, guessNum);
            cow = figureCow(secNum, guessNum);

            printGrate(bull, cow);

            turn++;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    static StringBuilder generateNumber(int length){
        StringBuilder secNum = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            if(i == 0){
                secNum.append(random.nextInt(9) + 1);
                continue;
            }
            String ranDig = Integer.toString(random.nextInt(9) + 1);
            if(secNum.indexOf(ranDig) == -1)
                secNum.append(ranDig);
            else
                i--;
        }
        return secNum;
    }

    static void printGrate(int bull, int cow){
        if(bull != 0 && cow != 0){
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s).");
        }
        else if(bull != 0){
            System.out.println("Grade: " + bull + " bull(s).");
        }
        else if(cow != 0){
            System.out.println("Grade: " + cow + " cow(s).");
        }
        else {
            System.out.println("Grade: None.");
        }
    }

    static int figureCow(StringBuilder secNum, StringBuilder guessNum){
        int cow = 0;
        for (int i = 0; i < secNum.length(); i++) {
            String ch = Character.toString(secNum.charAt(i));
            if (guessNum.indexOf(ch) >= 0 && secNum.charAt(i) != guessNum.charAt(i)) {
                cow += 1;
            }
        }
        return cow;
    }
    static int figureBull(StringBuilder secNum, StringBuilder guessNum){
        int bull = 0;
        for (int i = 0; i < secNum.length(); i++) {
            if (secNum.charAt(i) == guessNum.charAt(i)) {
                bull += 1;
            }
        }
        return bull;
    }
}
