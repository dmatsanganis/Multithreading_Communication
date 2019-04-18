import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LeitourgikaA {
	
	private static int[] array;                     //A static int-type array.
	protected static long sum = 0;				    //A long-type variable, sum, initially equals to 0.											
	protected static long product = 1;				//A long-type variable, product, initially equals to 1.																						
	protected static int rm_number;					//An int-type variable, rm_number.															
	private static Scanner scan;					//A Scanner-type variable,scan.			
	
	public static void main(String[] args) 
	{
		scan = new Scanner(System.in);
		Random random = new Random();  									//A random-type variable, random.	
		System.out.println("Enter the array size you want: ");		    //A message asks from the user to give the array size.														
		int n = scan.nextInt();											//An int-type variable, n, reads the array size. 																						
		array = new int[n];												//The n-array is created.																																								
		for(int i = 0; i < array.length; i++) 							//The array fills with numbers, from a for-loop.																			
		{
		  int numbers = random.nextInt(100 -(-100) + 1) + (-100); 		//These, randomly selected, numbers are limited integers, which belongs to (-100,100) field.																																						
		  array[i] = numbers; 											//The array gets one number per loop.												
		}																												
		System.out.println(Arrays.toString(array)); 					//The array appears at the console screen.																				
			
		Thread T1 = new T1();											//A T1 class object, T1.
		System.out.println("Starting Thread T1.");            			//Thread 1 (T1) start message appears at the console screen.	
		T1.start();														//Thread 1 (T1) executes.																								
 
		Thread T2 = new T2();											//A T2 class object, T2.	
		System.out.println("Starting Thread T2.");            			//Thread 2 (T2) start message appears at the console screen.	
		T2.start();														//Thread 2 (T2) executes.															
	      
		Thread T3 = new T3();											//A T3 class object, T3.	
		System.out.println("Starting Thread T3.");            			//Thread 3 (T3) start message appears at the console screen.	
		T3.start();														//Thread 3 (T3) executes.																			
	      
		Thread T4 = new T4();											//A T4 class object, T4.	
		System.out.println("Thread T4 will start when Threads T1, T2, T3 are completed.");//A Message appears at the control screen.
		try
		{
			T1.join();													//Thread 4 waits for the completion of Thread T1.	
			T2.join();													//Thread 4 waits for the completion of Thread T2.
			T3.join();													//Thread 4 waits for the completion of Thread T3.
		}
		catch (InterruptedException e) 
		{
			throw new IllegalStateException(e);							//Exception.					    
		}
		System.out.println("Starting Thread T4.");            			//Thread 4 (T4) start message appears at the console screen.	 						
		T4.start();														//Thread 4 (T4) executes.		
	}		

	public static class T1 extends Thread{
		
		public void run()												//Run void.							
		{
			System.out.println("Creating Thread T1.");					//Thread 1 (T1) is created and this appears at the console screen.									
		    for (int i : array)									        //A for loop for all the numbers of the array.					
		    {																								    	  
		    	sum += i ;								    			//The last number is added to the others during every loop.																																									    	  
		    }																	
		    System.out.println("T1 = " + sum);							//Thread 1 (T1) appears at the console screen.	
		    System.out.println("Exiting Thread T1.");					//Thread 1 (T1) exit message appears at the console screen.					
		}
	}
	
	public static class T2 extends Thread{
		
		public void run()												//Run void.							
		{
			System.out.println("Creating Thread T2.");					//Thread 2 (T2) is created and this appears at the console screen.									
		    for (int i : array)									        //A for loop for all the numbers of the array.					
		    {																								    	  
		    	product *= i ;											//The last number is multiplied to the others during every loop.																																									    	  
		    }																	
		    System.out.println("T2 = " + product);					    //Thread 2 (T2) appears at the console screen.	
		    System.out.println("Exiting Thread T2.");					//Thread 2 (T2) exit message appears at the console screen.						
		}
	}

	public static class T3 extends Thread{
		
		public void run()												//Run void.							
		{
			System.out.println("Creating Thread T3.");					//Thread 3 (T3) is created and this appears at the console screen.	
			Random random = new Random();  								//A random-type variable, random.	
			rm_number =  random.nextInt(1000-(-1000)+1)+(-1000); 	    //rm_number is a randomly selected limited integer, which belongs to (-1000,1000) field.																		
		    System.out.println("T3 = "+ rm_number);					    //Thread 3 (T3) appears at the console screen.										
		    System.out.println("Exiting Thread T3.");					//Thread 3 (T3) exit message appears at the console screen.						
		}
	}

	public static class T4 extends Thread{
		
		private Scanner scanner;

		public void run()												//Run void.							
		{
			System.out.println("Creating Thread T4.");					//Thread 4 (T4) is created and this appears at the console screen.										
			long list[] = {sum,product,rm_number};						//A long-type list array.																			
		      
		    System.out.println("Numbers in Descending Order:");			//A message prints on the console screen.																				
		    for (int i = list.length-1; i >= 0; i--)					//A for loop.
		      {
		    	  Arrays.sort(list);									//The long-type array list is sorted in descending order.										    	  
		      }	
		  System.out.println("1. " + list[2]);				            //Thread 4 (T4) appears at the console screen with the highest number of the array, list.	
	  	  System.out.println("2. " + list[1]);				            //Thread 4 (T4) appears at the console screen with the second higher number of the array, list.	 
	  	  System.out.println("3. " + list[0]);				            //Thread 4 (T4) appears at the console screen with the lowest number of the array, list.	 
		  System.out.println("Exiting Thread T4.");						//Thread 4 (T4) exit message appears at the console screen.	
		  scanner = new Scanner(System.in);
		  System.out.println("Press Enter to quit");					//Exit Application message.			
	      scanner.nextLine();
		}
	}
}