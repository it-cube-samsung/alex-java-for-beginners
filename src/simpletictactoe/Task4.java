package simpletictactoe;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = in.nextLine();
        int index = 0;
        char[][] cell = new char[3][3];
        int x = 0;
        int y = 0;
        for(int m = 0; m < 3; m++){
            for(int i = 0; i < 3; i++){
                cell[m][i] = cells.charAt(index);
                index++;
            }
        }
        printPole(cell);
        while(true){
            try{
                System.out.println("Enter coordinates:");
                String coord = in.nextLine();
                x = Integer.parseInt(Character.toString(coord.charAt(0))) - 1;
                y = Integer.parseInt(Character.toString(coord.charAt(2))) - 1;
                System.out.println(x);
                System.out.println(y);
                if(x > 2 || y > 2){
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                else{
                    if (cell[x][y] != ' '){
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    cell[x][y] = 'X';
                    printPole(cell);
                    break;
                }
            }catch (Exception e){
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static void printPole(char[][] cells){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                cells[i][j] = cells[i][j] == '_' ? ' ' : cells[i][j];
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
