package bullsandcows;

import java.util.Scanner;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        StringBuilder secNum = new StringBuilder();
        StringBuilder guessNum = new StringBuilder();

        int cow;
        int bull = 0;


        System.out.println("Input the length of the secret code:");
        int length = in.nextInt();

        System.out.println("Input the number of possible symbols in the code:");

        int possibleInt = in.nextInt();
        StringBuilder possibleSymbol = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz".substring(0, possibleInt));

        in.nextLine();
        int turn = 1;

        StringBuilder helpSt = new StringBuilder();
        helpSt.append("*".repeat(Math.max(0, length)));

        if(possibleInt > 9){
            helpSt.append(" (0 - 9, a - ").append(possibleSymbol.charAt(possibleSymbol.length() - 1)).append(").");
        }
        else{
            helpSt.append(" (0 - ").append(possibleSymbol.charAt(possibleSymbol.length() - 1)).append(").");
        }

        for (int i = 0; i < length; i++) {
            int ranDig = random.nextInt(possibleInt);
            secNum.append(possibleSymbol.charAt(ranDig));
            possibleSymbol.deleteCharAt(ranDig);
            possibleInt--;
        }

        System.out.println("The secret is prepared: " + helpSt);
        System.out.println("Okay, let's start a game!");

        while(bull != secNum.length()){
            bull = 0;
            cow = 0;

            System.out.println("Turn " + turn + ":");
            guessNum.append(in.nextLine());

            for (int i = 0; i < secNum.length(); i++) {
                String ch = Character.toString(secNum.charAt(i));
                if (secNum.charAt(i) == guessNum.charAt(i)) {
                    bull += 1;
                } else if (guessNum.indexOf(ch) >= 0) {
                    cow += 1;
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
