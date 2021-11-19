package simpletictactoe;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = in.nextLine();
        int index = 0;
        char[][] cell = new char[3][3];
        for(int m = 0; m < 3; m++){
            for(int i = 0; i < 3; i++){
                cell[m][i] = cells.charAt(index);
                index++;
            }
        }
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(cell[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
