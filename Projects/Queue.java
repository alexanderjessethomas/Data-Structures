/*
 * Author: Alex Thomas
 * Nau id: ajt239
 * Collaboration: No One
 * Project: Project 1
 * Professor: Ryan Middleton
 * Class: CS 249
 * 
 * Description: This java class is for a queue class. This is for part 2 of project 1.
 * This queue is supposed to be the one from the text according to the project except we are supposed to add
 * a display method to display the queue. 
 * Main is the method that was used for testing. 
 */
public class Queue {
	private int size;
    private long[] queueArray;
    private int f; //front
    private int r; //rear
    private int nItems;
    
    public Queue(int s){            //this is the constructor for the queue class
    	size = s;					//sets size
    	queueArray = new long[size];//creates the queue of the proper size
        f = 0;						// sets where the front pointer starts
        r = -1;						//sets where the rear pointer starts
        nItems= 0;					//sets the number of items in the queue
        
    }//end constructor
    
    public void insert(long j){ //inserts into the queue array
       if (r == size - 1){
           r = -1;
       }//this is for the wrap around in a queue
       queueArray[++r] = j;
       nItems++;
           
    }//This is the end of the queue classes insert method
    
    public long remove(){ //removes the item that is first in line of the queue. 
        long temp= queueArray[f++];
        if(f == size){
            f = 0;
        }//this is for the wrap around in a queue.
        nItems--; 
        return temp;
    }   
    
    public long peekFront(){ //see what is first in the queue
        return queueArray[f];
    }
    
    public boolean isEmpty(){// check to see if the queue is empty 
        return (nItems==0);
    }
    
    public boolean isFull(){//check to see if the queue is full
        return (nItems == size);
    }
    
    public int size(){// check the size of the queue
        return nItems;
    }
    
    public void display(){// display the queue. 
        for (int i = 0; i < queueArray.length; i++){
            System.out.print(queueArray[i] + " ");
        }
    }
    
    public static void main(String[] args){
        Queue testQueue = new Queue(5);
        
        testQueue.insert(10);
        testQueue.insert(20);
        testQueue.insert(30);
        testQueue.insert(40);
        testQueue.insert(50);

        testQueue.display();
        System.out.println();
        System.out.println("Testing wrap Around");
        
        testQueue.insert(60);
        testQueue.display();
        
        System.out.println();
        System.out.println("Testing Queue with single input:");
        Queue testQueue2 = new Queue(5);
        
        testQueue2.insert(1);
        
        testQueue2.display();
        
        System.out.println();
        System.out.println("Testing Queue with no inputs:");
        Queue testQueue3 = new Queue(5);
        
        testQueue3.display();
        
        
    }
}
