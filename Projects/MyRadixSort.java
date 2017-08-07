import java.util.List;
import java.util.ArrayList;

class MyRadixSort implements RadixSort{
	final int radix = 10;

	int digit = 1;
	List<Integer>[] arr;

	public void init(){
		digit = 1;
		arr = new ArrayList[radix];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}
	}

	public void sortRadixLSD(int[] input, int max_significant_digits){
		for (int i=1; i <= max_significant_digits; i++)
			sortRadixLSDOnePass(input);
	}

	public void sortRadixLSDOnePass(int[] input){
		for (int i=0; i < input.length; i++) {
			arr[(input[i] / digit) % radix].add(input[i]);
		}

		int n = 0;
		for (int b = 0; b < radix; b++) {
			for (Integer i : arr[b]) {
				input[n++] = i;
			}
			arr[b].clear();
		}
		// move to next digit
		digit *= radix;
	}

}