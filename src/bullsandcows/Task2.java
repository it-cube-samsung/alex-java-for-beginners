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
            char ch = secretNum.charAt(i);
            if (secretNum.charAt(i) == guessNum.charAt(i)) {
                bull += 1;
            } else if (guessNum.indexOf(ch) >= 0) {
                cow += 1;
            }
        }

        if(bull != 0 && cow != 0){
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s). The secret code is " + secretNum);
        }
        else if(bull != 0){
            System.out.println("Grade: " + bull + " bull(s). The secret code is " + secretNum);
        }
        else if(cow != 0){
            System.out.println("Grade: " + cow + " cow(s). The secret code is " + secretNum);
        }
        else {
            System.out.println("Grade: None. The secret code is " + secretNum);
        }
    }
}
