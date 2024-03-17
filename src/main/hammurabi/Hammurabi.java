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
    public  void yearlySummary(int year, int acresOfLand, int people, int valueLand, int numberOfBushels, int peopleStraved, int peopleMoved, int harvest, int bushelAcre, int destroyedBushel, int deathByPlague){
        System.out.println("O GREAT HAMMURABI" );
        System.out.println("You're in year" + year +" of the ten year rule");
        System.out.println("In the previous year " + peopleStraved +" people starved to death");
        System.out.println("In the previous year"  + peopleMoved + "people entered to kingdom");

        if (deathByPlague != 0){
            System.out.println("The population is now" + people + ".");
            System.out.println("We harvested " + harvest + " bushel at " + bushelAcre + "per acre");
            System.out.println("Rats destroyed " + destroyedBushel +" bushels, leaving " + numberOfBushels+ " bushels in storage");
            System.out.println("the city owns " + acresOfLand+ "acrres of land");
            System.out.println("Land is currently worth " + valueLand + "bushel per acre");
        }
    }
    private void finished(int years, int totalDeaths, int population, int acres, int percentDied) {
         String statement = " DUE TO THIS EXTREME MISMANAGEMENT YOU HAVE NOT ONLY BEEN IMPEACHED AND THROWN OUT OF OFFICE BY THE PEOPLE";
        if (years < 10) {
            System.out.println(statement);
        } else {
            String answer = "IN YOUR 10-YEAR TERM OF OFFICE, " + percentDied + " PERCENT OF THE\n" +
                    "POPULATION STARVED PER YEAR ON AVERAGE, I.E., A TOTAL OF\n" +
                    totalDeaths + " PEOPLE DIED!!\n" +
                    "YOU STARTED WITH 10 ACRES PER PERSON AND ENDED WITH\n" +
                    acres / population + " ACRES PER PERSON\n\n";
            if (percentDied > 33 || acres / population < 7)
                answer += statement;
            else if (percentDied > 10 || acres / population < 9)
                answer += "YOUR HEAVY-HANDED PERFORMANCE SMACKS OF NERO AND IVAN IV.\n" +
                        "THE PEOPLE (REMAINING) FIND YOU AN UNPLEASANT RULER, AND,\n" +
                        "FRANKLY, HATE YOUR GUTS!";
            else if (percentDied > 3 || acres / population < 10)
                answer += "YOUR PERFORMANCE COULD HAVE BEEN SOMEWHAT BETTER, BUT\n" +
                        "REALLY WASN'T TOO BAD AT ALL.\n" +
                        Math.random() * population * .8 + " PEOPLE WOULD" +
                        "DEARLY LIKE TO SEE YOU ASSASSINATED BUT WE ALL HAVE OUR" +
                        "TRIVIAL PROBLEMS";
            else
                answer += "A FANTASTIC PERFORMANCE!!!  CHARLEMANGE, DISRAELI, AND\n" +
                        "JEFFERSON COMBINED COULD NOT HAVE DONE BETTER!";
            answer += "\n\n\n\n\n\n\n\n\n\nSo long for now.";
            System.out.println(answer);
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
    public int harvest(int acres){
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