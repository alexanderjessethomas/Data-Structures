
public interface StackADT<T> {

	/**
	 * Pushes an object onto the "top" of the stack
	 */
    public void push(T new_item);

    /**
     * Removes and returns the object on the "top" of the stack
     */ 
    public T pop();

    /**
     * Returns without removing the object on the "top" of the stack
     */
    public T peek();

    /**
     * Returns true if empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of objects in the stack
     */
    public int size();

    /**
     * Returns a string representation of the stack
     */
    public String toString();
}

