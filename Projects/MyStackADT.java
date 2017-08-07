
public class MyStackADT<T> implements StackADT<T>{
	
	private int count;
	private Node<T> top;
	
	public MyStackADT(){
		count = 0;
		top = null;
	}
	
	@Override
	public void push(T new_item) {
		Node<T> temp = new Node<T>(new_item);
		temp.setNext(top);
		top = temp;
		count++;
	}

	@Override
	public T pop() {
		T result = top.getElement();
		top = top.getNext();
		count--;
		return result;
	}

	@Override
	public T peek() {
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0);
	}

	@Override
	public int size() {
		return count;
	}
	
	@Override
	public String toString(){
		String stack = "";
		Node current = top;
		while(current != null){
			stack = stack + current.getElement();
			current = current.getNext();
		}
		return stack;
	}

}
