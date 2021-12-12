package coffeemachine;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        CoffeeMachine coffee1 = new CoffeeMachine();
//
//        String action;
//        boolean working = true;
//
//        while(working){
//            switch (coffee1.status) {
//                case ACTION -> {
//                    System.out.println("Write action (buy, fill, take, remaining, exit):");
//                    action = in.nextLine();
//                    if (action.equals("exit")) {
//                        working = false;
//                        break;
//                    }
//                    coffee1.work(action);
//                }
//                case KIND -> {
//                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
//                    coffee1.work(in.nextLine());
//                }
//                case FILL -> coffee1.work(in.nextLine());
//            }
//        }
//    }
//}
