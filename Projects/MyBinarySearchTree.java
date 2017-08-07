import java.util.*;

public class MyBinarySearchTree<Key extends Comparable<Key>,Value> implements BinarySearchTree<Key, Value>{
	
	//private variables that will be used through out the 
	private Node<Key, Value> root;
	private int size = 0;
	private Node<Key,Value> current;
	
	/* 
	 * This is an additional helper method that is not originally in the interface
	 * The point of this method is to select the successor for the node that is being deleted.
	 * if it has one. 
	 * It takes in the selected node.
	 * The while loop is for going through the tree and getting the successor
	 */
	private Node<Key,Value> selectSuccessor(Node<Key,Value> n){
        Node<Key, Value> successorAncestor = n;
        Node<Key, Value> successor = n;
        Node<Key, Value> current = n.getRightChild();

        while (current != null) {
        	successorAncestor = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor != n.getRightChild()){
        	successorAncestor.setLeftChild(successor.getRightChild());
            successor.getRightChild().setParent(successorAncestor);
            successor.setRightChild(n.getRightChild());
            n.getRightChild().setParent(successor);
        }
        return successor;
    }
	
	
	/*
	 * The point of this method is to check if the Binary Search Tree is empty or not. 
	 * I tried to implement this method two different ways. The first is the one that is commented out
	 * After looking online I found multiple sources that showed it done in a single line
	 * I would assume the current implementation of this class is faster than my previous one. 
	 */
	@Override
	public boolean isEmpty() {
		//if(size == 0){
		//	return true;
	    //}else{
		//	return false;
	    //}
		return size ==0;
	}

	/*
	 * The point of this method is to find the key that is passed into the method.
	 * After the key is found it returns the value of the Key
	 * If the Key is not in the binary search tree it returns null.
	 */
	@Override
	public Value find(Key key) {
		current = root;
		
		while(current.getKey() != key){
			if(key.compareTo(current.getKey()) <0){
				current = current.getLeftChild();
			}
			else{
				current = current.getRightChild();
			}
			if (current == null){
				return null;
			}
		}
		return current.getValue();
	}
	
	/*
	 * This method is the insert method for the binary search tree. 
	 * The method takes in a key and a value. 
	 * Then it created a new node that is set to that key and holds the value 
	 * After that is done the method looks through the tree based on where current is
	 * After that it inserts the node once the proper position is found. 
	 */
	@Override
	public Value insert(Key key, Value val) {
		Node<Key, Value> n = new Node<>((Key) key, (Value) val);
		if(root == null){
            root = n;
            return (Value)val;
        }else{
            current = root;
            while(true){
                Node<Key, Value> parent = current;
                if(key.compareTo(current.getKey()) < 0){
                    current = current.getLeftChild();
                    if(current ==null){
                        current.setLeftChild(n);
                        current.getLeftChild().setParent(parent);
                        size++;
                        return (Value)val;
                    }
                }else if(key.compareTo(current.getKey()) > 0){
                	current = current.getRightChild();
                	if(current == null){
                		current.setRightChild(n);
                		current.getRightChild().setParent(parent);
                		size++;
                		return (Value) val;
                	}
                }
                else{
                	Value temporary = current.getValue();
                	current.setValue(n.getValue());
                	return temporary;
                }
            }
        }
	}

	/*
	 *This method is a delete method for the Binary Search Tree. 
	 *It takes in the Key of the node that you want to delete. 
	 *The majority of this method is checking the nodes in the tree for the one that you want to delete
	 *At the end of this method Select Successor is used to get the Successor of the deleted node if it has one. 
	 */
	@Override
	public Value delete(Key key) {
		current = root;
		Node<Key, Value> parentNode = current;
		boolean leftChild = true;
		while(current.getKey() != key){
			parentNode = current;
			if(key.compareTo(current.getKey()) < 0){
				leftChild = true;
				current = current.getLeftChild();
			}else if (key.compareTo(current.getKey()) < 0){
				leftChild = false;
				current = current.getRightChild();
			}else if(current == null){
				return null;
			}else{
				if (current.getLeftChild() == null && current.getRightChild() == null) {
                    if(current == root) {
                        root = null;
                    }else if(leftChild){
                        parentNode.setLeftChild(null);
                    }else{
                        parentNode.setRightChild(null);
                    }
				}else if(current.getRightChild()==null){
                    if(current == root){
                        root= current.getLeftChild();
                    }else if(leftChild){
                        parentNode.setLeftChild(current.getLeftChild());
                        current.getLeftChild().setParent(parentNode);
                    }else{
                        parentNode.setRightChild(current.getLeftChild());
                        current.getLeftChild().setParent(parentNode);
                    }
                }else if(current.getLeftChild() == null) {
                    if (current == root) {
                        root = current.getRightChild();
                    }else if (leftChild) {
                        parentNode.setLeftChild(current.getRightChild());
                        current.getRightChild().setParent(parentNode);
                    }else{
                        parentNode.setRightChild(current.getRightChild());
                        current.getRightChild().setParent(parentNode);
                    }

                }else{
                	Node<Key,Value> successor = selectSuccessor(current);
                	if(current == root){
                		root = successor;
                	}else if(leftChild){
                		parentNode.setRightChild(successor);
                	}else{
                		parentNode.setRightChild(successor);
                	}
                	
                }
			
			}
		}
		
		return current.getValue();
	}

	/*
	 * This method is is for going through a level order sort for the binary search tree
	 * I was unable to figure this method out to return a string. 
	 */
	@Override
	public String stringLevelOrder() {
		//String out = "Level 0: ";
		//Node<Key, Value> n;
		//Integer current = new Integer(0);
		return null;	
	}
}
