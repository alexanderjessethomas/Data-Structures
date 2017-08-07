
public class CircularLinkedList<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int listSize;
	
	public CircularLinkedList(){
		firstNode = null;
		lastNode = null;
		listSize = 0;
	}
	
	public void insert(T element){
		Node<T> newNode = new Node<T>(element);
		
		if(lastNode == null){
			firstNode = newNode;
			lastNode = newNode;
		}else{
			lastNode.setNext(newNode);
			lastNode = newNode;
			listSize++;
		}
	}
	public T delete(int key){
		T deleted = null;
		Node<T> node = firstNode;
		for(int i = 0; i < key - 1; i++){
			node = node.getNext();
			if((key - 1) ==i){
				deleted = node.getNext().getElement();
				node.setNext(node.getNext().getNext());
				listSize--;
			}
		}
		return deleted;
	}
	
	public T find(int key){
		Node<T> node = firstNode;
		for(int i = 0; i < key; i++){
			node = node.getNext();
		}
		return node.getElement();
	}
	
	public Node<T> getNode(int key){
		Node<T> node = firstNode;
		for(int i = 0; i < key; i++){
			node = node.getNext();
		}
		return node;
	}
	
	public int getListSize(){
		return listSize;
	}
	
	public void createCircularPath(){
		lastNode.setNext(firstNode);
	}
	
}
