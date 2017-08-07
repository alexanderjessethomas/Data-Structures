/*
 * Author: Alex Thomas
 * Nau id: ajt239
 * Collaboration: No One
 * Project: Project 1
 * Professor: Ryan Middleton
 * Class: CS 249
 * 
 * Description: This java class is for Selection Sort. This is one of the three sorting algorithms for project 1.
 * Main is the method that was used for testing. 
 */
import java.util.Arrays;

public class SelectionSort {
	public static int[] selectionSort(int[] anArray){
        for ( int i = 0; i < anArray.length -1; i++){
            int comparisons = 0;
            int minimum = i;
            for (int j = i + 1; j < anArray.length; j++){
                if (anArray[j] < anArray[minimum]){
                    minimum = j;
                } //end if statement
            }// end second for loop
            int copies = 0;
            if (minimum != i ){
                int temp = anArray[i];
                anArray[i] = anArray[minimum];
                anArray[minimum] = temp;
                copies += 3;
            }//end if statement 
            comparisons++;
        }// end first for loop
        return anArray;
    }//end selectionSort
	
	public static void main(String [] args){
		
		//arrays for testing there sorting algorithms 
		int selection1[] = {10,9,8,7,6,5,4,3,2,1};
        int selection2[] = {5,10,15,20,25,50,45,40,35,30};
        
        System.out.println("Selection Sort arrays before sorting: ");
        System.out.println("Array 1: " + Arrays.toString(selection1));
        System.out.println("Array 2: " + Arrays.toString(selection2) + "\n");
        selectionSort(selection1);
        selectionSort(selection2);
        
        System.out.println("Sorted Array 1: " + Arrays.toString(selection1));
        System.out.println("Sorted Array 2: " + Arrays.toString(selection2));
	}
}
