
public interface EliminationInterface {

	/**
	 * Starts a new "game" of elimination, taking in 2 parameters:
	 *    - the initial number of players in the circle
	 *    - a randomly chosen "elimination #"
	 *
	 * The simulation is initialized by creating the appropriate players and putting them into a circle. One
	 * of those players is selected as the initial "current player"
	 */
	public void init(int numPlayers, int elimNumber);

	/**
	 * Returns true only if the current person in the circle is the winner
	 */
    public boolean currentIsWinner();

	/**
	 * Returns the elimination number for this simulation
	 */
    public int getEliminationNumber();

	/**
	 * Returns the name of the current person in the circle
	 */
    public String getCurrentPlayerName();

	/**
	 * Runs one cycle of elimination by starting at the "current player", counting off people while going 
	 * around the circle (think duck duck goose), and removing the person reached when the count reaches 
	 * the elimination #.  The new "current person" is the person immediately following the one who was
	 * eliminated. Return the name of the person removed from the circle.
	 */
    public String tick();
}

