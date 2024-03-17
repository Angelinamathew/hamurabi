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
//Asks the player how many acres of land to buy, and returns that number. You must have enough grain to pay for your purchase.
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
  //  Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.
  //  Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn.
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
   // Ask the player how much grain to feed people, and returns that number.
   // You can't feed them more grain than you have. You can feed them more than they need to survive.
    public int askHowMuchGrainToFeedPeople(int bushels){
        int grainToFeed = 0;
        while (true) {
            try {
                System.out.println("How many acres of land to sell?");
                grainToFeed = scanner.nextInt();
                if (grainToFeed <= bushels) {
                    break;
                }
                System.out.println("you don't have land to buy");
            } catch (Exception e) {
                System.out.println("This is not a number");
                scanner.nextLine();
            }
        }
        return grainToFeed;
    }
    /*
    Ask the player how many acres to plant with grain, and returns that number.
    You must have enough acres, enough grain, and enough people to do the planting.
    Any grain left over goes into storage for next year.
     */
    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        int acresToPlant =0;
        while(true){
            try {
                System.out.println("How many acres to plant with grain?");
                acresToPlant = scanner.nextInt();

                if (acresToPlant<=acresOwned && acresOwned/10 <= population && acresToPlant <= bushels){
                    break;
                } else if (acresToPlant > acresOwned) {
                    System.out.println("Too many acres to plant");
                } else if (acresToPlant/10 > population) {
                    System.out.println("Not enough people!");
                } else if (acresToPlant*2 > bushels) {
                    System.out.println("Too many acres and not enough bushels.O Great Hammurabi, surely you jest! We have only "+bushels+" bushels left!");
                }
            }
            catch (Exception e){
                System.out.println("This is not a number");
                scanner.nextInt();
            }
        }
        return acresToPlant;
    }
    //Each year, there is a 15% chance of a horrible plague. When this happens, half your people die.
    // Return the number of plague deaths (possibly zero).
    public int plagueDeaths(int population){
        if(rand.nextInt(100) < 15){
            return population/2;
        }
        return 0;
    }
    //Each person needs 20 bushels of grain to survive. If you feed them more than this, they are happy, but the grain is still gone.
    public int starvationDeaths(int population, int bushelsFedToPeople){
        if (bushelsFedToPeople < population){
            return population - (bushelsFedToPeople / 20);
        }
        return 0;
    }
   // Return true if more than 45% of the people starve
    public boolean uprising(int population, int howManyPeopleStarved){
        int checkPercent = (int)((double) howManyPeopleStarved / population) +1;
        return checkPercent >= 45;
    }
    public int immigrants(int population, int acresOwned, int grainInStorage){
        return (20 * acresOwned + grainInStorage) / (100 * population) + 1;
    }
    public int harvest(int acres, int bushelsUsedAsSeed){
        return acres *(rand.nextInt(6) + 1);
    }
    public int grainEatenByRats(int bushels){
        if (rand.nextInt(100) < 40){
            return rand.nextInt(30-10+1) + 10;
        }
        return 0;
    }
    public int newCostOfLand(){
        return rand.nextInt(23-17+1) + 17;
    }

}


    //other methods go her