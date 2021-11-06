package coffeemachine;

public class CofeMachine {

    public enum Status {
        ACTION, KIND, FILL
    }

    public enum Coffee{
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
    public void make(Coffee coffee){
        switch (coffee){
            case espresso:
                makeCoffee(250, 0, 16, 4);
                break;
            case latte:
                makeCoffee(350, 75, 20, 7);
                break;
            case cappuccino:
                makeCoffee(200, 100, 12, 6);
                break;
        }
    }
    public void makeCoffee(int nWater, int nMilk, int nBeans, int money){

        if(nWater > this.water){
            System.out.println("Sorry, not enough water!");
            return;
        }

        if(nMilk > this.milk){
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if(nBeans > this.beans){
            System.out.println("Sorry, not enough beans!");
            return;
        }

        if(this.cups == 0){
            System.out.println("Sorry, not enough cups!");
        }

        System.out.println("I have enough resources, making you a coffee!");
        this.water -= nWater;
        this.milk -= nMilk;
        this.beans -= nBeans;
        this.money += money;
        this.cups--;
    }

    public void buy(String kind) {
        switch (kind) {
            case "1":
                make(Coffee.espresso);
                break;
            case "2":
                make(Coffee.latte);
                break;
            case "3":
                make(Coffee.cappuccino);
                break;
            case "4":
                return;
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
