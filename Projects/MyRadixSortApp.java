
public class MyRadixSortApp {
		public static void main(String [] args){
			int [] arr = {36, 54, 13, 7, 102, 567, 793, 34, 923};
			display (arr);

			MyRadixSort test = new MyRadixSort();
			test.init();
			test.sortRadixLSDOnePass (arr);
			display (arr);
			test.sortRadixLSDOnePass (arr);
			display (arr);

			test.sortRadixLSDOnePass (arr);
			display (arr);

			int [] arr2 = {15, 9, 10, 12, 7, 8, 20, 30, 100};
			display (arr2);
			test.init();  
			test.sortRadixLSD(arr2, 3);
			display (arr2);
		}

		public static void display(int[] arr){
			for (int i=0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
		
			System.out.println("");
		}

}


