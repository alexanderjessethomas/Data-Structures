/**
 * @author Jean-Paul Labadie
 * @since 11/5/2015
 */
public interface RecursiveKnapsack {

	/**
	 * Recursive knapsack only has one method that you must provide, other helper methods are acceptable.
	 * This method must take in an int array values (our weights for the knapsack).
	 * It also takes a non-negative non-zero value for the target weight.
	 *
	 * If negative values appear in the weight set, or if the target weight is negative, return null.
	 * Likewise, if the weight set is null, return null. These cases represent errors.
	 *
	 * If no solution can be found, return an int array with a single value, {-1}.
	 *
	 * The solution must be calculated with recursion.
	 * DO NOT USE ANY LOOPS INSIDE YOUR KNAPSACK CLASS.
	 *
	 * You do not need to account for the behavior of negative numbers in the weight set.
	 *
	 * For example, if I call your getKnapsackSolution({2,5,1,3},8) the return should be:
	 * {5,3} or {3,5}.
	 * If I call your getKnapsackSolution({},8) or getKnapsackSolution({1},-10) the return should be:
	 * null in both cases (which signifies an input error).
	 * Finally, if I call your getKnapsackSolution({1,2,0,0,20},5) the return should be:
	 * {0} (which signifies that no solutions were found).
	 * Note: in the examples given, numbers inside {} are comma-separated values representing an int array
	 *
	 *
	 * @param weights an int array representing the weights we have to choose from
	 * @param targetweight the goal weight for the recursive solution,
	 * @return the set of solution weights, or null if bad input was detected, or -1 if no solution was found
	 */
	int[] getKnapsackSolution(int[] weights, int targetweight);
}
