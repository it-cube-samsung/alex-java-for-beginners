package coffeemachine;

public class CoffeeMachine {

    public enum Status {
        ACTION, KIND, FILL
    }

    public enum Coffee{
        espresso, latte, cappuccino
    }

    public enum Ingredients{
        MILK, WATER, BEANS, CUPS, START
    }

    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;

    Status status = Status.ACTION;
    Ingredients ing = Ingredients.START;

    public void work(String inner) {
        switch (this.status) {

            case ACTION:
                switch (inner) {
                    case "buy" -> this.status = Status.KIND;
                    case "remaining" -> remaining();
                    case "take" -> take();
                    case "fill" -> {
                        this.status = Status.FILL;
                        fill(inner);
                    }
                }
                break;

            case KIND:
                buy(inner);
                this.status = Status.ACTION;
                break;
            case FILL:
                fill(inner);

        }
    }

    public void fill(String filledIng){
        try {
            switch (this.ing) {
                case START -> {
                    System.out.println("Write how many ml of water you want to add:");
                    this.ing = Ingredients.WATER;
                }
                case WATER -> {
                    System.out.println("Write how many ml of milk you want to add:");
                    this.water += Integer.parseInt(filledIng);
                    this.ing = Ingredients.MILK;
                }
                case MILK -> {
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    this.ing = Ingredients.BEANS;
                    this.milk += Integer.parseInt(filledIng);
                }
                case BEANS -> {
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    this.ing = Ingredients.CUPS;
                    this.beans += Integer.parseInt(filledIng);
                }
                case CUPS -> {
                    this.ing = Ingredients.START;
                    this.cups += Integer.parseInt(filledIng);
                    this.status = Status.ACTION;
                }
            }
        }
        catch (Exception ignored){

        }
    }

    public void make(Coffee coffee){
        switch (coffee) {
            case espresso -> makeCoffee(250, 0, 16, 4);
            case latte -> makeCoffee(350, 75, 20, 7);
            case cappuccino -> makeCoffee(200, 100, 12, 6);
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
            case "1" -> make(Coffee.espresso);
            case "2" -> make(Coffee.latte);
            case "3" -> make(Coffee.cappuccino);
            default -> System.out.println("Unknown symbol.");
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
