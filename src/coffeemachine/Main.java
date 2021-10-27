package coffeemachine;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CofeMachine cofe1 = new CofeMachine();
        String action;
        boolean working = true;
        while(working){
            switch(cofe1.status){
                case ACTION:
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    action = in.nextLine();
                    if(action.equals("exit")){
                        working = false;
                        break;
                    }
                    cofe1.work(action);
                    break;
                case KIND:
                    cofe1.work(in.nextLine());
                    break;
                case FILL:
                    cofe1.work(in.nextLine());
            }
        }
    }
}
