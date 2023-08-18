package mortgageCalculator.java;

import java.text.NumberFormat;
import java.util.*;
public class mortgageCalculator {

	public static void main(String[] args) {
     final byte MONTHS_IN_YEAR = 12;
     final byte PERCENT = 100;
     
     int principal = 0;
     float monthlyInterest = 0;
     int numOfPayments = 0;
     
     Scanner scanner = new Scanner(System.in);
     
     while(true) {
     System.out.print("Principal: ");
     principal = scanner.nextInt();
      if(principal >= 1000 && principal <= 1_000_000) {
    	 break;
      }
      System.out.println("Enter a value between 1000 and 1000000");
     }
     while(true) {
    	   System.out.print("Annual Interest Rate: ");
    	     float annualInterest = scanner.nextFloat();
    	     if(annualInterest >= 1 && annualInterest <= 30) {
    	    	 monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
    	    	 break;
    	     }
    	     System.out.println("Enter a value between 1 and 30");
     }
     
     while(true) {
    	 System.out.print("Period(Years): ");
         byte period = scanner.nextByte();
         if(period >= 1 && period <= 30) {
        	 numOfPayments = period * MONTHS_IN_YEAR; 
        	 break;
         }
         System.out.println("Enter a period between 1 and 30"); 
     }

     double mortgage = principal 
    		 * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments))
    		 / (Math.pow(1 + monthlyInterest, numOfPayments) -1 );
     String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
     System.out.println("Mortgage: " + mortgageFormatted);
     

	}
}
