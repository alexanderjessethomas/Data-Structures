import java.util.NoSuchElementException;

class MatrixAPP{
	public static void main (String [] args){
		MyLinkedMatrix matrix = new MyLinkedMatrix();

		if (!matrix.init(-2, -2))
			System.out.println("Error initializing the matrix.");

		matrix.init(5, 5);
		
		System.out.println (matrix.getValue(0,1));
		matrix.setValue (5, 0, 1);
		System.out.println (matrix.getValue(0,1));

		System.out.println (matrix.sumRow(2));
		
		System.out.println (matrix.sumCol(3));

		try{
			System.out.println (matrix.sumRow(10));
		} catch (NoSuchElementException e) {
			System.out.println("No such element.");
		}
	}
}