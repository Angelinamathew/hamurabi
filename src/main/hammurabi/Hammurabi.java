package hammurabi;               // package declaration
import java.util.Random;         // imports go here
import java.util.Scanner;

public class Hammurabi {         // must save in a file named Hammurabi.java
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        int population = 100;
        int numberOfBushels = 2800;
        int acresOfLand = 1000;
        int landValue = 19;
        int years = 1;
        int peopleStarved = 0;
        int peopleMoved = 0;
        int harvest = 0;
        int bushelsAteByRat = 0;
        int totalImmgration = 0;
        int deathByPlague = 0;
        int deathPercent = 0;

        // statements go after the declations
        while (years <= 10) {

        }
    }

    public int askHowManyAcresToBuy(int price, int bushels) {
        int acresBuy = 0;
        while (true) {
            try {
                System.out.println("How many acres of land do you want to buy?");
                acresBuy = scanner.nextInt();
                if (acresBuy * price <= bushels) {
                    break;
                }
                System.out.println("You are poor");
            } catch (Exception e) {
                System.out.println("This is not a number");
                scanner.nextLine();
            }
        }
        return acresBuy;
    }

    public int askHowManyAcresToSell(int acresOwned) {
        int arcesToSell = 0;
        while (true) {
            try {
                System.out.println("How many acres of land to sell?");
                arcesToSell = scanner.nextInt();
                if (arcesToSell <= acresOwned) {
                    break;
                }
                System.out.println("you don't have land to buy");
            } catch (Exception e) {
                System.out.println("This is not a number");
                scanner.nextLine();
            }
        }
        return arcesToSell;
    }
}


    //other methods go her