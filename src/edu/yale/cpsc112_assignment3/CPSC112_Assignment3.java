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

		} 
 

 public static boolean isGameOver(String input) {
    // Parts 3 and 4 code goes here
	
  }
  

}
