
public interface SupermarketInterface {

	/**
	 * This method should create the number of checkout lines as specified by numClerks, with each line 
	 * having a maximum length specified by lineCapacity.
	 */
	public void buildMarket(int numClerks, int lineCapacity);

	/**
	 * A new customer with 'numItems' items in their cart should be created and added to the best line 
	 * for that customer.  Return true if the customer was added; return false if all of the lines were
	 * at capacity.
	 */
    public boolean addCustomer(int numItems);

	/**
	 * Represents one 'tick' or time step (1 second) of a supermarket simulation.
	 *   - Each clerk should clear one item from their current customer at a rate of 1 item per second
	 *   - Finishing up with a customer who has no items takes 1 second
	 *   - Finsihed customers should be removed from their line and returned.
	 *   - You should remove the total number of customers removed from checkout lines this tick
	 */
    public int tick();
}
