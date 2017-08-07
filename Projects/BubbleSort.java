/*
 * Author: Alex Thomas
 * Nau id: ajt239
 * Collaboration: No One
 * Project: Project 1
 * Professor: Ryan Middleton
 * Class: CS 249
 * 
 * Description: This java class is for Bubble Sort. This is one of the three sorting algorithms for project 1.
 * Main is the method that was used for testing. 
 */
import java.util.Arrays;

public class BubbleSort {
	public static int[] bubbleSort(int[] anArray){
		int[] bubble = anArray;
		for (int i = 0; i < bubble.length; i++) {   //first for loop
			int comparisons = 0; //keeps track of comparisons done by loop.
			for (int j = i + 1; j < bubble.length; j++){    //second for loop
				int copies = 0;  //keeps track of copies
				if(bubble[i] > bubble[j]){
					int temp = bubble[i];
					bubble[i] = bubble[j];
					bubble[j] = temp;
					copies += 3;
				}
			}
			comparisons++;
		}
		return bubble;
	}
	
	public static void main(String [] args){
			
			//arrays for testing there sorting algorithms 
	        int bubble1[] = {10,9,8,7,6,5,4,3,2,1};
	        int bubble2[] = {10,20,30,40,50,100,90,80,70,60};
	        
	        System.out.println("Bubble Sort arrays before sorting: ");
	        System.out.println("Array 1: " + Arrays.toString(bubble1));
	        System.out.println("Array 2: " + Arrays.toString(bubble2) + "\n");
	        bubbleSort(bubble1);
	        bubbleSort(bubble2);
	        
	        System.out.println("Sorted Array 1: " + Arrays.toString(bubble1));
	        System.out.println("Sorted Array 2: " + Arrays.toString(bubble2));
	}
}
