//Luca Lombardo
//CSC 236-6
//Lab 2-A

import java.util.Scanner;

public class LockDataStructureClass implements LockADT {
	private int x;
	private int y;
	private int z;
	private int top;
	private int rotation;
	private boolean status;
	public static final int CLOCK = 0;
	public static final int COUNTER_CLOCK = 1;
	Scanner scan = new Scanner(System.in);
	
	public LockDataStructureClass() {
		x = 0;
		y = 0;
		z = 0;
		top = 0;
		rotation = 0;
		status = false;
	}
	
	public LockDataStructureClass(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setX(int x1) {
		this.x = x1;
	}
	
	public void setY(int y1) {
		this.y = y1;
	}
	
	public void setZ(int z1) {
		this.z = z1;
	}
	
	public void alter(int x1, int y1, int z1) {
		setX(x1);
		setY(y1);
		setZ(z1);	
	}
	
	public void setCurrently(int cur) {
		this.top = cur;
	}
	
	public int currently() {
		return top;
	}
	
	public void turn(int direction, int number) {
		int i = top;
		int numbersPassed = 0;
		
		do 
		{
			if(direction == COUNTER_CLOCK)
			{
				i++;
				
				if(i > 39)
					i = 0;
	
				if(i < 0)
					i=39;
	
				this.top = i;

				System.out.print(top + " ");
	
				numbersPassed++;
	
				if(numbersPassed > 40 && top == number)
					break;
			}
		
			if(direction == CLOCK)
			{
				if(rotation != 2) 
				{
					i--;
				
					if(i>39)
						i=0;
		
					if(i<0)
						i=39;
		
					this.top = i;
		
					System.out.print(top + " ");
		
					numbersPassed++;
		
					if(numbersPassed > 40 && top == number)
						break;
				}
				else if(rotation == 2) 
				{
					i--;
					
					if(i>39)
						i=0;
	
					if(i<0)
						i=39;
	
					this.top = i;
	
					System.out.print(top + " ");
	
					numbersPassed++;
	
					if(top == number)
						break;
				}
					
			}
		
		}while(true);
		
		System.out.println();
		rotation++;
	}
	
	public void close() {
		status = false;
	}
	
	public boolean inquire() {
		return status;
	}
	
	public boolean attempt() {
		int firstStop = -1;

		int secondStop = -1;

		int thirdStop = -1;

		int firstRotation = -1;

		int secondRotation = -1;

		int thirdRotation = -1;

		for(int i=1; i<=3; i++){

		System.out.print("Enter the num to stop with on top(0-39) for Rotation" + i + ": ");

		int numToStop = scan.nextInt();

		System.out.print("Enter the direction to turn (0 for clockiwse and 1 for counter clock wise) for Rotation" + i + ": ");

		int direction = scan.nextInt();

		turn(direction, numToStop);

		if(i == 1) {

		firstStop = numToStop;

		firstRotation = direction;

		}

		else if(i == 2) {

		secondStop = numToStop;

		secondRotation = direction;

		}

		else if(i == 3) {

		thirdStop = numToStop;

		thirdRotation = direction;

		}

		if(firstStop==this.x && firstRotation == CLOCK
		&& secondStop==this.y && secondRotation == COUNTER_CLOCK
		&& thirdStop==this.z && thirdRotation == CLOCK) {

		this.status = true;
		System.out.println("The lock has been opened.");

		}
		
		}
		this.rotation = 0;

		return status;
	}
}