package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();
  public static int secretNumber1; 
  public static int secretNumber2;
  public static int secretNumber3; 
  public static int secretNumber4;
  public static int a;
  public static int b;
  public static int c; 
  public static int d;
  public static int highestNum = 0;
  public static int numExceptions = 3;
  public static int truth = 1;

  public static void main(String[] args) {
    makeMySecret();
    isGameOver("1234");
    isGameOver("4321");
    isGameOver("2567");
    isGameOver("1432");
  }

  public static void makeMySecret() {
     // Part 1 code goes here (please leave the next few lines at the end of the makeMySecret method)
	 secretNumber1 = r.nextInt(7)+1; 
	 secretNumber2 = r.nextInt(7)+1;
	 if (secretNumber2 == secretNumber1){
		 secretNumber2 = r.nextInt(7)+1; 
	 }
	 secretNumber3 = r.nextInt(7)+1; 
	 if (secretNumber3 == secretNumber1 || secretNumber3 == secretNumber2){
		 secretNumber3 = r.nextInt(7)+1;
	 }
	 secretNumber4 = r.nextInt(7)+1; 
	 if (secretNumber4 == secretNumber1 || secretNumber4 == secretNumber2 || secretNumber4 == secretNumber3){
		 secretNumber4 = r.nextInt(7)+1;
	 }
	 mySecret = mySecret + secretNumber1 + secretNumber2 + secretNumber3 + secretNumber4; 
	 //question here about whether or not to have the "Secret: " 
	 
	if (DEBUG)
    {
       System.out.println("Secret: " + mySecret);
    }
  }

  
  public static boolean isGuessValid(String input) {
    // Part 2 code goes here
	boolean invalidGuess = true; 
		try {
			a = Integer.parseInt(input.substring(0,1));
			b = Integer.parseInt(input.substring(1,2));
			c = Integer.parseInt(input.substring(2,3));
			d = Integer.parseInt(input.substring(3,4));		
				if (a <=0 || a >= 8){
					invalidGuess = false;
					System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				}
				if (b <=0 || b >= 8 || b==a){
					invalidGuess = false;
					System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				}
				if (c <=0 || c >= 8 || c==b || c==a){
					invalidGuess = false;
					System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				}
				if (d <=0 || d >= 8 || d==c || d==b || d==a){
					invalidGuess = false;
					System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
				}
			return invalidGuess;
		}
				
		catch (Exception e){
				return false;
				}
		} 
 

 public static boolean isGameOver(String input) {
    // Parts 3 and 4 code goes here
	 
	 boolean endGameGuess = true;
	 if (isGuessValid(input)==false){
		 return false;
	 }
	 
	 
		int intGuess = Integer.parseInt(input); 
		int theSecret = Integer.parseInt(mySecret);
		if (intGuess > highestNum){
			highestNum = intGuess; 
		}
		if (intGuess < highestNum && intGuess != theSecret){ 
			if (numExceptions >0){
				numExceptions = numExceptions -1; 
			} 
			System.out.println("Your guess was lower than allowed. You have " + numExceptions + " exceptions remaining.");
			 if (numExceptions == 0 && intGuess > theSecret){
				 System.out.println("You're out of exceptions and you've guessed to high! The secret was " + mySecret);
				 return true;
			 }
		}
		
		 int numCorrect = 0; 
		 if (secretNumber1 == a || secretNumber1 == b || secretNumber1 == c || secretNumber1 == d){
			 numCorrect = numCorrect + 1; 
		 }
		 if (secretNumber2 == a || secretNumber2 == b || secretNumber2 == c || secretNumber2 == d){
			 numCorrect += 1; 
		 }
		 if (secretNumber3 == a || secretNumber3 == b || secretNumber3 == c || secretNumber3 == d){
			 numCorrect += 1; 
		 }
		 if (secretNumber4 == a || secretNumber4 == b || secretNumber4 == c || secretNumber4 == d){
			 numCorrect += 1; 
		 }

		 int placeCorrect = 0; 
		 if (secretNumber1 == a){
			 placeCorrect += 1; 
		 }
		 if (secretNumber2 == b){
			 placeCorrect += 1; 
		 }
		 if (secretNumber3 == c){
			 placeCorrect += 1; 
		 }
		 if (secretNumber4 == d){
			 placeCorrect += 1; 
		 }
	
		if (truth == 1){
			 int lie = r.nextInt(3); 
			 if (lie == 2){
				 truth *= -1; 
			int firstDigit; 
			int digit = r.nextInt(2);
			if (digit == 0){
				Random q = new Random();
				firstDigit = q.nextInt(5);
				while (firstDigit == numCorrect || numCorrect < placeCorrect){
					firstDigit = q.nextInt(5);
				}
				if (numCorrect == 4 && placeCorrect == 3){
					digit = 1; 
				}  else {
					numCorrect = firstDigit;
				}
			}
			if (digit == 1){
				Random p = new Random();
				int secondDigit = p.nextInt(4);
				while (secondDigit == placeCorrect || secondDigit > numCorrect){
					secondDigit = p.nextInt(4);
					if (numCorrect == 4 && secondDigit == 3){
						secondDigit = p.nextInt(3);
					}
				}	
				placeCorrect = secondDigit;
			}
			}
			 if (numCorrect == 4 && placeCorrect == 4){
				 System.out.println("You won!");
				 return true;
			 }
			 System.out.println("Guess: " + input + "; Result: " + numCorrect + "," + placeCorrect);
		}
		 return false; 

  }
  

}
