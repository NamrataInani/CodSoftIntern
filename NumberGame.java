import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //creating a random object to generate random number
        Random random=new Random();
        //Define the lower and upper bound for the range of numbers
        int lowerBound=1;
        int upperBound=100;
        //Generate a random number within the specified range
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts=0;
        int maxAttempts=10;
        System.out.println("Welcome to the number guessing game!!");
        System.out.println("I have selected a number between "+lowerBound+" and "+upperBound+"can you guess it??");
        while(attempts<maxAttempts){
            System.out.println("Enter your Guess Number"); 
            int userGuess=sc.nextInt();
            attempts++;
          if(userGuess == numberToGuess)  {
              System.out.println("Congratulations! you have guessed the correct number in "+attempts+" attempts.");
              break;
          }
          else if(userGuess<numberToGuess){
              System.out.println("try a higher number");
          }
          else{
              System.out.println("Try a lower number");
          }
        }
        if(attempts==maxAttempts){
            System.out.println("Sorry,you have reached the number of attempts.The correct answer is: "+numberToGuess);
        }
        System.out.println("Thanks for playing the Game");
    
    sc.close();
}
}





