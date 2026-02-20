package code;

import java.util.Scanner;

public class TheFloodGameTester {
	public static void main(String[] args) {
		TheFloodGame TFG = new TheFloodGame(20, 20);
		int counter = 0;
		int num = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("welcome to the flood game!");
		
		System.out.println("please select a number: \n 1, 2, 3 \n 4, 5, 6");
		System.out.println("\n");
	
		do{
			TFG.display();
			num = input.nextInt();
			if(num>6 || num<1) {
				System.out.println("choose a valid number: ");
			}
			else {
				TFG.flood(num);
				counter++;
				System.out.println("turn: " + counter + " /25");
				System.out.println();
			}
			
			if(counter==26) 
				System.out.println("you lost, but lets see how many more it will take you to win!");
			
		}while(!TFG.check(num));
		
		if(TFG.check(num))
			System.out.println("you won!");
		
		
		if(TFG.check(num) && counter>25) {
			System.out.println("it took you " + (counter-25) + " more to win");
		}
	}

}

