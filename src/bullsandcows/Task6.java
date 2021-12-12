package bullsandcows;

import java.util.Scanner;
import java.util.Random;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cow;
        int bull = 0;

        System.out.println("Input the length of the secret code:");
        String input1 = in.nextLine();
        int length;
        if(!input1.matches("\\d+")){
            System.out.println("Error: \"" + input1 +"\" isn't a valid number.");
            return;
        }
        length = Integer.parseInt(input1);
        if(length > 36){
            System.out.println("Max value of length is 36, please try again.");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");

        String input = in.nextLine();
        int possibleInt;
        if(!input.matches("\\d+")){
            System.out.println("Error: \" " + input +" \" isn't a valid number.");
            return;
        }
        possibleInt = Integer.parseInt(input);
        if(possibleInt > 36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }

        StringBuilder possibleSymbol = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz".substring(0, possibleInt));

        if(length > possibleInt){
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + possibleInt + " unique symbols.");
            return;
        }

        int turn = 1;

        StringBuilder helpSt = new StringBuilder();
        helpSt.append("*".repeat(Math.max(0, length)));

        if(possibleInt > 9){
            helpSt.append(" (0 - 9, a - ").append(possibleSymbol.charAt(possibleSymbol.length() - 1)).append(").");
        }
        else{
            helpSt.append(" (0 - ").append(possibleSymbol.charAt(possibleSymbol.length() - 1)).append(").");
        }

        StringBuilder secNum = generateNumber(length, possibleInt, possibleSymbol);
        StringBuilder guessNum;

        System.out.println("The secret is prepared: " + helpSt);
        System.out.println("Okay, let's start a game!");

        while(bull != secNum.length()){
            System.out.println("Turn " + turn + ":");
            guessNum = new StringBuilder(in.nextLine());

            if (guessNum.length() != secNum.length())
            {
                System.out.println("The length of guess number can not be longer than length of secret number!");
                continue;
            }

            bull = figureGrate(secNum, guessNum)[0];
            cow = figureGrate(secNum, guessNum)[1];

            printGrate(bull, cow);

            turn++;
            guessNum.setLength(0);
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }
    static StringBuilder generateNumber(int length, int possibleInt, StringBuilder possibleSymbol){
        StringBuilder secNum = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int ranDig = random.nextInt(possibleInt);
            secNum.append(possibleSymbol.charAt(ranDig));
            possibleSymbol.deleteCharAt(ranDig);
            possibleInt--;
        }
        return  secNum;
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

    static int[] figureGrate(StringBuilder secNum, StringBuilder guessNum){
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secNum.length(); i++) {
            String ch = Character.toString(secNum.charAt(i));
            if (secNum.charAt(i) == guessNum.charAt(i)) {
                bull += 1;
            } else if (guessNum.indexOf(ch) >= 0) {
                cow += 1;
            }
        }
        return new int[]{bull, cow};
    }
}
