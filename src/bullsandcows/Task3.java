package bullsandcows;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();
        StringBuilder ranNum = new StringBuilder();

        if(length > 10){
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
        }

        for (int i = 0; i < length; i++) {
            if(i == 0){
                int ranDig = (int)(Math.random() * 10);
                if(ranDig == 0){
                    i--;
                    continue;
                }
                ranNum.append(ranDig);
                continue;
            }
            String ranDig = Integer.toString((int)(Math.random() * 10));
            if(ranNum.indexOf(ranDig) == -1){
                ranNum.append(ranDig);
                continue;
            }
            i--;
        }
        System.out.println("The random secret number is " + ranNum + ".");
    }
}
