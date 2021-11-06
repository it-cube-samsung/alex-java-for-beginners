package coffeemachine;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CofeMachine coffee1 = new CofeMachine();
        String action;
        boolean working = true;
        while(working){
            switch(coffee1.status){
                case ACTION:
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    action = in.nextLine();
                    if(action.equals("exit")){
                        working = false;
                        break;
                    }
                    coffee1.work(action);
                    break;
                case KIND:
                    coffee1.work(in.nextLine());
                    break;
                case FILL:
                    coffee1.work(in.nextLine());
            }
        }
    }
}
