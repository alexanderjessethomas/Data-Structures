import java.util.*;

public class Node<Key extends Comparable<Key>, Value> {
	private Key key;
	private Value value;
	private Node<Key, Value> leftChild;
	private Node<Key, Value> rightChild;
	private Node<Key, Value> parent;
	
	//constructor for Node
	public Node(Key key, Value value){
		this.key = key;
		this.value = value;
	}
	
	//get methods for key, Value, children and patent
	public Key getKey(){
		return this.key;
	}
	
	public Value getValue(){
		return this.value;
	}
	
	public Node<Key, Value> getLeftChild(){
		return this.leftChild;
	}
	
	public Node<Key, Value> getRightChild(){
		return this.rightChild;
	}
	
	public Node<Key, Value> getParent(){
		return this.parent;
	}
	
	public void setParent(Node<Key, Value> n){
		parent = n;
	}
	
	public void setRightChild(Node<Key, Value> n){
		rightChild = n;
	}
	
	public void setLeftChild(Node<Key, Value> n){
		leftChild = n;
	}
	
	public void setValue(Value val){
		value = val;
	}
	
	public void setKey (Key k){
		key = k;
	}
}
