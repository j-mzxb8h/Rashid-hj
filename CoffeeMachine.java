package machine;

import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner sc = new Scanner(System.in);

    final static int MILKFORLATTE = 75;
    final static int WATERFORLATTE = 350;
    final static int COFFEEBEANSFORLATTE = 20;
    final static int MONEYFORLATTE = 7;

    final static int MILKFORCAPPUCCINO = 100;
    final static int WATERFORCAPPUCCINO = 200;
    final static int COFFEEBEANSFORCAPPUCCINO = 12;
    final static int MONEYFORCAPPUCCINO = 6;

    final static int WATERFORESPRESSO = 250;
    final static int COFFEEBEANSFORESPRESSO = 16;
    final static int MONEYFORESPRESSO = 4;


    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String coffeeMachine = sc.next();
            switch (coffeeMachine) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    System.out.printf("I gave you $%d\n", money);
                    money = 0;
                    break;
                case "remaining":
                    condition(water, milk, coffeeBeans, cups, money);
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }

    private static void condition(int water, int milk, int coffeeBeans, int cups, int money){
        System.out.printf("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n", water, milk, coffeeBeans, cups, money);
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buy = sc.next();
        switch (buy){
            case "1":
                if (water < WATERFORESPRESSO){
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeBeans < COFFEEBEANSFORCAPPUCCINO){
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    water -= WATERFORESPRESSO;
                    coffeeBeans -= COFFEEBEANSFORESPRESSO;
                    cups--;
                    money += MONEYFORESPRESSO;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if (water < WATERFORLATTE){
                    System.out.println("Sorry, not enough water!");
                } else if (milk < MILKFORLATTE){
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeans < COFFEEBEANSFORLATTE) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    water -= WATERFORLATTE;
                    milk -= MILKFORLATTE;
                    coffeeBeans -= COFFEEBEANSFORLATTE;
                    money += MONEYFORLATTE;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if (water < WATERFORCAPPUCCINO) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk < MILKFORCAPPUCCINO) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeans < COFFEEBEANSFORCAPPUCCINO) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    water -= WATERFORCAPPUCCINO;
                    milk -= MILKFORCAPPUCCINO;
                    coffeeBeans -= COFFEEBEANSFORCAPPUCCINO;
                    money += MONEYFORCAPPUCCINO;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "back":
                break;
        }
    }

    private static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += sc.nextInt();
    }
}