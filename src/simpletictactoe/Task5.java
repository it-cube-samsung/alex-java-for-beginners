package simpletictactoe;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char[][] cell = new char[][]{ {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };

        int x;
        int y;

        boolean xMove = true;
        int countMove = 9;

        boolean winX = false;
        boolean winO = false;

        printPole(cell);
        while(countMove != 0){
            try{
                System.out.println("Enter coordinates:");
                String cord = in.nextLine();
                x = Integer.parseInt(Character.toString(cord.charAt(0))) - 1;
                y = Integer.parseInt(Character.toString(cord.charAt(2))) - 1;
                if(x > 2 || y > 2){
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                else{
                    if (cell[x][y] != ' '){
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    countMove--;
                    if(xMove){
                        cell[x][y] = 'X';
                        xMove = false;
                    }
                    else{
                        cell[x][y] = 'O';
                        xMove = true;
                    }
                    printPole(cell);
                    if((cell[0][0] == cell[0][1] && cell[0][1] == cell[0][2] && cell[0][1] == 'X')
                            || (cell[1][0] == cell[1][1] && cell[1][1] == cell[1][2] && cell[1][1] == 'X')
                            || (cell[2][0] == cell[2][1] && cell[2][1] == cell[2][2] && cell[2][1] == 'X')
                            || (cell[0][0] == cell[1][0] && cell[1][0] == cell[2][0] && cell[0][0] == 'X')
                            || (cell[0][1] == cell[1][1] && cell[1][1] == cell[2][1] && cell[2][1] == 'X')
                            || (cell[0][2] == cell[1][2] && cell[1][2] == cell[2][2] && cell[2][2] == 'X')
                            || (cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2] && cell[1][1] == 'X')
                            || (cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0] && cell[1][1] == 'X')){
                        winX = true;
                        break;
                    }
                    if((cell[0][0] == cell[0][1] && cell[0][1] == cell[0][2] && cell[0][1] == 'O')
                            || (cell[1][0] == cell[1][1] && cell[1][1] == cell[1][2] && cell[1][1] == 'O')
                            || (cell[2][0] == cell[2][1] && cell[2][1] == cell[2][2] && cell[2][1] == 'O')
                            || (cell[0][0] == cell[1][0] && cell[1][0] == cell[2][0] && cell[0][0] == 'O')
                            || (cell[0][1] == cell[1][1] && cell[1][1] == cell[2][1] && cell[2][1] == 'O')
                            || (cell[0][2] == cell[1][2] && cell[1][2] == cell[2][2] && cell[2][2] == 'O')
                            || (cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2] && cell[1][1] == 'O')
                            || (cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0] && cell[1][1] == 'O')){
                        winO = true;
                        break;
                    }
                }
            }catch (Exception e){
                System.out.println("You should enter numbers!");
            }
        }
        if(winX){
            System.out.println("X wins");
        }
        else if(winO){
            System.out.println("O wins");
        }
        else{
            System.out.println("Nobody wins");
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
