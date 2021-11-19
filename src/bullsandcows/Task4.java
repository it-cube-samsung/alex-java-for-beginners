package bullsandcows;

import java.util.Scanner;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        StringBuilder secNum = new StringBuilder();
        StringBuilder guessNum = new StringBuilder();

        System.out.println("Please, enter the secret code's length:");
        int length = in.nextInt();

        if(length > 9){
            System.out.println("Max of length is 9.");
            return;
        }

        int turn = 1;

        int cow;
        int bull = 0;

        for (int i = 0; i < length; i++) {
            if(i == 0){
                secNum.append(random.nextInt(9) + 1);
                continue;
            }
            String ranDig = Integer.toString(random.nextInt(9) + 1);
            if(secNum.indexOf(ranDig) == -1){
                secNum.append(ranDig);
            }
            else{
                i--;
            }
        }

        System.out.println("Okay, let's start a game!");

        while(bull != secNum.length()){
            bull = 0;
            cow = 0;

            System.out.println("Turn " + turn + ":");
            guessNum.append(in.nextLine());

            for (int i = 0; i < secNum.length(); i++) {
                for (int j = 0; j < guessNum.length(); j++) {
                    if(secNum.charAt(i) == guessNum.charAt(j)){
                        cow = i != j? cow + 1 : cow;
                        bull = i == j? bull + 1 : bull;
                    }
                }
            }

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

            turn++;
            guessNum.setLength(0);
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }
}
