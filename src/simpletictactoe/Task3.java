package simpletictactoe;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String cells = in.nextLine();

        int index = 0;
        int freePlaces = 0;

        int countX = 0;
        int countO = 0;

        char[][] cell = new char[3][3];

        boolean winX = false;
        boolean winO = false;

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
                switch (cell[i][j]){
                    case '_':
                        freePlaces++;
                        break;
                    case 'X':
                        countX++;
                        break;
                    case 'O':
                        countO++;
                        break;
                }
            }
            System.out.println("|");
        }
        System.out.println("---------");

        if((cell[0][0] == cell[0][1] && cell[0][1] == cell[0][2] && cell[0][1] == 'X')
        || (cell[1][0] == cell[1][1] && cell[1][1] == cell[1][2] && cell[1][1] == 'X')
        || (cell[2][0] == cell[2][1] && cell[2][1] == cell[2][2] && cell[2][1] == 'X')
        || (cell[0][0] == cell[1][0] && cell[1][0] == cell[2][0] && cell[0][0] == 'X')
        || (cell[0][1] == cell[1][1] && cell[1][1] == cell[2][1] && cell[2][1] == 'X')
        || (cell[0][2] == cell[1][2] && cell[1][2] == cell[2][2] && cell[2][2] == 'X')
        || (cell[0][0] == cell[1][1] && cell[1][1] == cell[2][2] && cell[1][1] == 'X')
        || (cell[0][2] == cell[1][1] && cell[1][1] == cell[2][0] && cell[1][1] == 'X')){
            winX = true;
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
        }


        if((winO && winX) || (countO - countX >= 2) || (countX - countO >= 2)){
            System.out.println("Impossible");
        }
        else if(freePlaces != 0 && !winO && !winX){
            System.out.println("Game not finished");
        }
        else if(freePlaces == 0 && !winO && !winX){
            System.out.println("End");
        }
        else if(winX){
            System.out.println("X wins");
        }
        else if(winO){
            System.out.println("O wins");
        }
    }
}
