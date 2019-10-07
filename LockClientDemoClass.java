//Luca Lombardo
//CSC 236-6
//Lab 2-A

import java.util.Scanner;

public class LockClientDemoClass {
	public static void main(String[] args) {
		
		LockDataStructureClass lock = new LockDataStructureClass();
		menu(lock);
		
	}
	
	
	public static void menu(LockDataStructureClass lock) {
		int number;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println("1: set lock combination \n"
						+ "2: close lock \n"
						+ "3: check status \n"
						+ "4: attempt to open lock \n"
						+ "5: check what the dial is currently pointing at \n"
						+ "6: exit the program \n");
			
			number = scan.nextInt();
			
			if(number == 1) {
				System.out.println("Enter 3 numbers between 0 - 39");
				lock.alter(scan.nextInt(), scan.nextInt(), scan.nextInt());
			}
			else if(number == 2) {
				
				if(lock.inquire() == true) {
					lock.close();
					System.out.println("The lock has been closed.");
				}
				else
					System.out.println("The lock is already closed.");
			}
			else if(number == 3) {
				if(lock.inquire() == true)
					System.out.println("The lock is open");
				else
					System.out.println("The lock is closed");
			}
			else if(number == 4) {
			
				lock.attempt();
			}
			else if(number == 5) {
				System.out.println(lock.currently());
			}
		}while(number != 6);
		
		scan.close();
			
	}

}
