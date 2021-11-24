package coffeemachine;

import java.util.Scanner;

public class Task4 {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (true){

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = in.nextLine();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back - to main menu: ");
                    buy(in.nextLine());
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    return;
            }
        }
    }

    public static void make(String coffee){
        switch (coffee){
            case "espresso":
                makeCoffee(250, 0, 16, 4);
                break;
            case "latte": makeCoffee(350, 75, 20, 7);
                break;
            case "cappuccino": makeCoffee(200, 100, 12, 6);
                break;
        }
    }
    public static void makeCoffee(int nWater, int nMilk, int nBeans, int nMoney){
        if(nWater > water){
            System.out.println("Sorry, not enough water!");
            return;
        }

        if(nMilk > milk){
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if(nBeans > beans){
            System.out.println("Sorry, not enough beans!");
            return;
        }

        if(cups == 0){
            System.out.println("Sorry, not enough cups!");
        }

        System.out.println("I have enough resources, making you a coffee!");
        water -= nWater;
        milk -= nMilk;
        beans -= nBeans;
        money += nMoney;
        cups--;
    }
    public static void buy(String kind) {
        switch (kind) {
            case "1":
                make("espresso");
                break;
            case "2": make("latte");
                break;
            case "3": make("cappuccino");
                break;
            case "4":
                return;
            default:
                System.out.println("Unknown symbol.");
        }
    }

    public static void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void remaining(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$ " + money + " of money");
    }

    public static void fill(){
        System.out.println("Write how many ml of water you want to add: ");
        water += in.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += in.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += in.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += in.nextInt();
    }
}
