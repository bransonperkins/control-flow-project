import java.util.Random;
import java.util.Scanner;

public class Survey {

    public static void surveyQuestions() {
        // initialize scanner
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = userInput.next();
        System.out.printf("Hello %s!\n", name);

        // ask user if they would like to continue with the survey
        System.out.printf("Do you want to continue? ");
        String yesOrNo = userInput.next();
            
        // if else statement to determine if the survey continues or not
        if (yesOrNo.equals("yes") || yesOrNo.equals("y") || yesOrNo.equals("Yes") || yesOrNo.equals("Y")) {
            System.out.println("Awesome. Let's begin the survey!");
        } else {
            System.out.println("Come back another time to complete the survey. Thanks!");
        }
           // if the user decides to take the survey then begin asking questions
            while(true) {
                System.out.print("What is your favorite pet's name? ");
                String pet = userInput.next();

                System.out.print("What is your pet's age? ");
                int petage = userInput.nextInt();

                System.out.print("What is your lucky number? ");
                int lucky = userInput.nextInt();

                System.out.print("Do you have a favorite player on a pro sports team? ");
                String fave = userInput.next();
                // declared favorite player's number outside if statement so it can be updated in correct scope
                int faveNum = 0;
                if (fave.equals("yes") || fave.equals("y") || fave.equals("Yes") || fave.equals("Y")) {
                    System.out.print("What is their number? ");
                    faveNum = userInput.nextInt();
                }

                System.out.print("What is the two-digit model year of your car? ");
                int car = userInput.nextInt();

                System.out.print("What is the first name of your favorite actor/actress? ");
                String act = userInput.next();

                System.out.print("Enter a random number between 1 and 50: ");
                int rand1 = userInput.nextInt();

                // generate random numbers
                Random random = new Random();
                int rand2 = random.nextInt(75) + 1;
                int rand3 = random.nextInt(65) + 1;

                // find magic number - user's favorite player's number or their lucky number * random number. while loop will bring random num down into the desired range
                int magic = 0;
                if (faveNum > 0) {
                    magic = faveNum;
                } else {
                    magic = lucky*rand2;
                }
                while (magic > 75) {
                    magic -= 75;
                }
                
                // generate values for 5 non-magic numbers
                // find the 3rd letter of their favorite pet. convert that character value to an integer value
                char third = pet.charAt(2);
                int lottery1 = (int)third;
                while (lottery1 > 65) {
                    lottery1 -= 65;
                }

                // favorite player number + age of pet + lucky number
                int lottery2 = faveNum + petage + lucky;
                while (lottery2 > 65) {
                    lottery2 -= 65;
                }

                // use random number between 1 and 50 and subtract it from one of the random generated numbers
                int lottery3 = rand1 - rand3;
                while (lottery3 < 1) {
                    lottery3 += rand3;
                }

                // convert the first letter of the user's favorite actor/actress name to an integer value
                char first = act.charAt(0);
                int lottery4 = (int)first;
                while (lottery4 > 65) {
                    lottery4 -= 65;
                }

                // multiply age of their pet and their car model year
                int lottery5 = petage*car;
                while (lottery5 > 65) {
                    lottery5 -= 65;
                }

                System.out.printf("Lottery Numbers: %d, %d, %d, %d, %d Magic ball: %d\n", lottery1, lottery2, lottery3, lottery4, lottery5, magic);
                playAgain();
                userInput.close();
                break;
            } 
   
    }

    // create new method to see if the user wants to play the game again - injected method into the survey method and called it in the main method
    public static void playAgain() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Do you want to play the game again? " );
        String play = userInput.nextLine();

        switch (play) {
            case "yes":
            case "Yes":
            case "y":
            case "Y":
                surveyQuestions();
                break;
            default:
                System.out.println("See ya next time!");
                userInput.close();
                break;
        }
    }
}