/*
 * Author: Alex Thomas
 * Nau id: ajt239
 * Collaboration: No One
 * Project: Project 1
 * Professor: Ryan Middleton
 * Class: CS 249
 * 
 * Description: This java class is for a Dequeue class. This is for part 3 of project 1.
 * This dequeue is very similar to the original queue class except it can be access from both sides instead of just one side. 
 * You can insert to both sides and remove from both sides. The display method is identical to the one in the queue class. 
 * Main is the method that was used for testing. 
 */
public class Dequeue {
	  private int queCap;
	  private int[] anArray;
	  private int f;//front
	  private int r;//rear
	  private int size;

	  public Dequeue(int queCap){ //constructor
	    this.queCap = queCap;
	    anArray = new int[queCap];
	    f = 0;
	    r = -1;
	    size = 0;
	  }

	  public void insertLeft(int value){    //insert to the left of the queue
	    if(r == queCap-1) r = -1;
	    anArray[++r] = value;
	    size++;
	  }
	  
	 public void insertRight(int value){    //insert to the right of the queue
	    if(f == - 1) f = queCap-1;
	    anArray[++f] = value;
	    size++;
	  }

	  public int removeRight(){ //remove from the right of the queue
	    int temp = anArray[f++];
	    if(f == queCap) f = 0;
	    size--;
	    return temp;
	  }

	  

	  public int removeLeft(){  //remove from the left of the queue
	    int temp = anArray[r--];
	    if(r == -1) r = queCap;
	    size--;
	    return temp;
	  }

	  public boolean isEmpty(){ //see if the queue is empty or not. 
	    return (size == 0);
	  }

	  public boolean isFull(){  //see if the queue is full or not. 
	    return (size == queCap);
	  }
	  
	  public void display(){// display the dequeue. 
	        for (int i = 0; i < anArray.length; i++){
	            System.out.print(anArray[i] + " ");
	        }
	    }
	  
	  public static void main(String[] args) {

		    Dequeue queue = new Dequeue(5);

		    queue.insertLeft(2); 
		    queue.insertLeft(4); 
		    queue.insertLeft(6); 
		    queue.insertLeft(8);
		    queue.insertLeft(10);
		    
		    queue.display();
		    
		    System.out.println();
	        System.out.println("Testing wrap Around");
	        
	        queue.insertLeft(60);
	        queue.display();
	        
	        System.out.println();
	        System.out.println("Testing Dequeue with single input:");
	        Queue testQueue2 = new Queue(5);
	        
	        testQueue2.insert(1);
	        
	        testQueue2.display();
	        
	        System.out.println();
	        System.out.println("Testing Dequeue with no inputs:");
	        Queue testQueue3 = new Queue(5);
	        
	        testQueue3.display();
	        
		  }

}
