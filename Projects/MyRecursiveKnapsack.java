import java.util.*;

class MyRecursiveKnapsack implements RecursiveKnapsack{
	 int[] knapSackSolution = new int[0];
	 
	    @Override
	    public int[] getKnapsackSolution(int[] weights, int targetweight) {
	        if(weights.length == 0){
	        	return null;
	        }
	        if(targetweight < 0){
	        	return null;
	        }
	      
	        if(weights[0] == targetweight){
	            int[] knapSackSolution = Arrays.copyOfRange(this.knapSackSolution, 0, this.knapSackSolution.length +1);
	            knapSackSolution[knapSackSolution.length-1] = weights[0];
	            return knapSackSolution;
	        }
	        else if(weights[0] < targetweight){
	            int[] arr = Arrays.copyOfRange(weights, 1, weights.length);
	            int target = targetweight - weights[0];
	            int[] result = getKnapsackSolution(arr, target);
	        }
	        else{
	            int[] arr = Arrays.copyOfRange(weights, 1, weights.length);
	            int targetExtra = targetweight;
	            int[] result = getKnapsackSolution(arr, targetExtra);
	        }
	        return knapSackSolution;
	    }
}
