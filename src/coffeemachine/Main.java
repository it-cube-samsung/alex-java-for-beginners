package coffeemachine;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CofeMachine cofe1 = new CofeMachine();
        while(cofe1.working){
            switch(cofe1.status){
                case ACTION:
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    cofe1.work(in.nextLine());
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
