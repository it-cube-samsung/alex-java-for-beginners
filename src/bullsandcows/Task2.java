package bullsandcows;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String secretNum = "9305";
        String guessNum = in.nextLine();

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < secretNum.length(); i++) {
            for (int j = 0; j < guessNum.length(); j++) {
                if(secretNum.charAt(i) == guessNum.charAt(j)){
                    bull = i == j ? bull + 1 : bull;
                    cow = i != j ? cow + 1 : cow;
                }
            }
        }

        if(bull != 0 && cow != 0){
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s). The secret code is 9305.");
        }
        else if(bull != 0){
            System.out.println("Grade: " + bull + " bull(s). The secret code is 9305.");
        }
        else if(cow != 0){
            System.out.println("Grade: " + cow + " cow(s). The secret code is 9305.");
        }
        else {
            System.out.println("Grade: None. The secret code is 9305");
        }
    }
}
