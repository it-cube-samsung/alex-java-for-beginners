package simpletictactoe;

import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.println("|       |");
        }
        System.out.println("---------");
        Scanner in = new Scanner(System.in);
        int countOfMove = 9;
        boolean xMove = true;
        char[][] cell = new char[3][3];
        char firstPlayer = 'X';
        char secondPlayer = 'O';
        int x = 0;
        int y = 0;
        boolean isWinX = false;
        boolean isWinO = false;
        char winSymbol;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cell[i][j] = ' ';
            }
        }
        while(countOfMove != 0){
            System.out.println("Enter the coordinates:");
            String coord = in.nextLine();
            if((int) coord.charAt(0) - 49 > 2 || (int)coord.charAt(0) - 49 < 0 || (int)coord.charAt(2) - 49 > 2 || (int)coord.charAt(2) - 49 < 0){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if(cell[(int) coord.charAt(0) - 49][(int) coord.charAt(2) - 49] != ' '){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            x = (int) coord.charAt(0) - 49;
            y = (int) coord.charAt(2) - 49;
            if(xMove){
                cell[x][y] = firstPlayer;
                xMove = false;
            }
            else{
                cell[x][y] = secondPlayer;
                xMove = true;
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
            if(cell[0][0] == cell[0][1] && cell[0][2] == cell[0][1]){
                winSymbol = cell[0][0];
                isWinX = winSymbol == 'X' || isWinX;
                isWinO = winSymbol == 'O' || isWinO;
            }
            if(cell[1][0] == cell[1][1] && cell[1][2] == cell[1][1]){
                winSymbol = cell[1][0];
                isWinX = winSymbol == 'X'? true : isWinX;
                isWinO = winSymbol == 'O'? true : isWinO;
            }
            if(cell[2][0] == cell[2][1] && cell[2][1] == cell[2][2]){
                winSymbol = cell[2][0];
                isWinX = winSymbol == 'X'? true : isWinX;
                isWinO = winSymbol == 'O'? true : isWinO;
            }
            if(cell[0][0] == cell[1][0] && cell[2][0] == cell[1][0]){
                winSymbol = cell[0][0];
                isWinX = winSymbol == 'X'? true : isWinX;
                isWinO = winSymbol == 'O'? true : isWinO;
            }
            if(cell[0][1] == cell[1][1] && cell[1][1] == cell[2][1]){
                winSymbol = cell[0][1];
                isWinX = winSymbol == 'X'? true : isWinX;
                isWinO = winSymbol == 'O'? true : isWinO;
            }
            if(cell[0][2] == cell[1][2] && cell[2][2] == cell[1][2]){
                winSymbol = cell[0][2];
                isWinX = winSymbol == 'X'? true : isWinX;
                isWinO = winSymbol == 'O'? true : isWinO;
            }
            if(cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2]){
                winSymbol = cell[0][0];
                isWinX = winSymbol == 'X'? true : isWinX;
                isWinO = winSymbol == 'O'? true : isWinO;
            }
            if(cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0]){
                winSymbol = cell[0][2];
                isWinX = winSymbol == 'X'? true : isWinX;
                isWinO = winSymbol == 'O'? true : isWinO;
            }
            if(isWinX){
                System.out.println("X wins");
                break;
            }
            if(isWinO){
                System.out.println("O wins");
                break;
            }
            countOfMove--;
        }
        if(countOfMove == 0){
            System.out.println("Nobody wins");
        }
    }
}
