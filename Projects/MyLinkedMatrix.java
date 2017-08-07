import java.util.NoSuchElementException;

public class MyLinkedMatrix implements LinkedMatrix {
	Link start = null;

	public boolean init(int rows, int cols) {
		if (rows <= 0 || cols <= 0)
			return false;

		Link [][] matrix = new Link[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				String value = "";
				value += i;
				value += j;
				matrix[i][j] = new Link();
				matrix[i][j].setData(Integer.parseInt(value));
			}
		}

		for (int i = 0; i < cols-1; i++) {
			for (int j = 0; j < rows; j++) {
				matrix[i][j].setNext(matrix[i+1][j]);
			}
		}

		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows-1; j++) {
				matrix[i][j].setDown(matrix[i][j+1]);
			}
		}

		start = matrix[0][0];
		
		return true;
	}

	public boolean setValue(int value, int row, int col) {
		Link current = start;		
		
		for (int i = 0; i < row; i++) {
			if (current == null)
				return false;
			current = current.getDown();
		}

		for (int i = 0; i < col; i++) {
			if (current == null)
				return false;
			current = current.getNext();
		}

		current.setData(value);

		return true;
	}

	public void fill(int value) {
		Link row_leading = start;

		while (row_leading != null) {
			Link current = row_leading;

			while (current != null) {
				current.setData(value);
				current = current.getNext();
			}

			row_leading = row_leading.getDown();
		}
	}

	public int sumRow(int row) throws NoSuchElementException {
		Link current = start;

		for (int i = 0; i < row; i++){
			if (current == null)
				throw new NoSuchElementException();

			current = current.getDown();
		}
		
		int sum = 0;
		
		while (current != null){
			sum += current.getData();
			current = current.getNext();
		}
		return sum;
	}

	public int sumCol(int col) throws NoSuchElementException {
		Link current = start;

		for (int i = 0; i < col; i++){
			if (current == null)
				throw new NoSuchElementException();

			current = current.getNext();
		}
		
		int sum = 0;
		
		while (current != null){
			sum += current.getData();
			current = current.getDown();
		}
		return sum;
	}

	public int getValue(int row, int col) throws NoSuchElementException {
		Link current = start;

		for (int i = 0; i < row; i++){
			if (current == null)
				throw new NoSuchElementException();

			current = current.getDown();
		}
		
		for (int i = 0; i < col; i++){
			if (current == null)
				throw new NoSuchElementException();

			current = current.getNext();
		}

		return current.getData();
	}
}