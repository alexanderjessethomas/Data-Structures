/*
 * Author: Alex Thomas
 * Nau id: ajt239
 * Collaboration: No One
 * Project: Project 1
 * Professor: Ryan Middleton
 * Class: CS 249
 * 
 * Description: This java class is for Insertion Sort. This is one of the three sorting algorithms for project 1.
 * Main is the method that was used for testing. 
 */
import java.util.Arrays;

public class InsertionSort {
	public static int[] insertionSort(int[] anArray){
        for (int i = 1; i < anArray.length; i++){
            int temp = anArray[i];
            int j = i;
            int comparisons = 0;
            while ( j > 0 && temp < anArray[j-1]){
                anArray[j] = anArray[j-1];
                j = j-1;
            }
            anArray[j] = temp;     
            comparisons++;
        }
        return anArray;
    }// end insertionSort
	
	public static void main(String [] args){
		
		//arrays for testing there sorting algorithms 
		int insertion1[] = {10,9,8,7,6,5,4,3,2,1};
        int insertion2[] = {5,10,15,20,25,50,45,40,35,30};
        
        System.out.println("Insertion Sort arrays before sorting: ");
        System.out.println("Array 1: " + Arrays.toString(insertion1));
        System.out.println("Array 2: " + Arrays.toString(insertion2) + "\n");
        insertionSort(insertion1);
        insertionSort(insertion2);
        
        System.out.println("Sorted Array 1: " + Arrays.toString(insertion1));
        System.out.println("Sorted Array 2: " + Arrays.toString(insertion2));
	}
}
