package coffeemachine;

public class CofeMachine {

    public enum Status {
        ACTION, KIND, FILL
    }

    public enum Cofe{
        espresso, latte, cappuccino
    }

    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;

    Status status = Status.ACTION;
    public void work(String inner) {
        switch (this.status) {
            case ACTION:
                if (inner.equals("buy")){
                    this.status = Status.KIND;
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back - to main menu: ");
                }
                else if(inner.equals("fill")){
                    this.status = Status.FILL;
                    System.out.println("Write how many ml of water you want to add: ");
                }
                else if(inner.equals("remaining")){
                    remaining();
                }
                else if(inner.equals("take")){
                    take();
                }
                break;
            case KIND:
                buy(inner);
                this.status = Status.ACTION;
                break;
        }
    }
    public void make(Cofe coffe){
        System.out.println("I have enough resources, making you a coffee!");
        switch (coffe){
            case espresso:
                makeCofe(250, 0, 16, 4);
                break;
            case latte:
                makeCofe(350, 75, 20, 7);
                break;
            case cappuccino:
                makeCofe(200, 100, 12, 6);
                break;
        }
    }
    public void makeCofe(int nWater, int nMilk, int nBeans, int money){
        if(nWater <= this.water) {
            if (nMilk <= this.milk) {
                if (nBeans <= this.beans) {
                    if (this.cups != 0) {
                        this.water -= nWater;
                        this.milk -= nMilk;
                        this.beans -= nBeans;
                        this.money += money;
                        this.cups--;
                    } else {
                        System.out.println("Sorry, not enough cups!");
                    }
                } else {
                    System.out.println("Sorry, not enough beans!");
                }
            } else {
                System.out.println("Sorry, not enough milk!");
            }
        }
        else{
            System.out.println("Sorry, not enough water!");
        }
    }

    public void buy(String kind) {
        switch (kind) {
            case "1":
                make(Cofe.espresso);
                break;
            case "2":
                make(Cofe.latte);
                break;
            case "3":
                make(Cofe.cappuccino);
                break;
            default:
                System.out.println("Unknown symbol.");
        }
    }
    public void take(){
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }
    public void remaining(){
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.beans + " g of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$ " + this.money + " of money");
    }
}
