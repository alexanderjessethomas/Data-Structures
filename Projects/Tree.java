/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg5;

/**
 *
 * @author Alex
 */
import java.util.*;
class Node{
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode(){
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
    
    public int getKey(){
        return iData; 
    }
    public double getData(){
        return dData;
    }
    
}//end node class
public class Tree {
    private Node root;
    
    public Tree(){
        root = null;
    }
    public Node find(int key) // find node with given key
    { // (assumes non-empty tree)
        Node current = root; // start at root
        while(current.iData != key){
            if(key < current.iData) // go left?
                current = current.leftChild;
            else // or go right?
                current = current.rightChild;
            if(current == null) // if no child,
                return null; // didn’t find it
        }
        return current; // found it
    } // end find()\
    
    public void insert(int id, double dd){
        Node newNode = new Node(); // make new node
        newNode.iData = id; // insert data
        newNode.dData = dd;
        if(root==null) // no node in root
            root = newNode;
        else {
            Node current = root; // start at root
            Node parent;
            while(true){
                parent = current;
                if(id < current.iData){
                    current = current.leftChild;
                    if(current == null){ // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else{
                    current = current.rightChild;
                    if(current == null){ // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                }//end else go right
            }//end while loop
        }//end else
    }// end insert
    
    public boolean delete(int key){
        Node current = root; 
        Node parent = root;
        boolean isLeftChild = true;
        while(current.iData != key){
            parent = current;
            if(key< current.iData){
                isLeftChild = true;
                current = current.leftChild;
                
            }//end if
            else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null)
                return false;
            
        }//end while loop
        
        if(current.leftChild == null && current.rightChild ==null){
            if (current == root)
                root = null; 
            else if (isLeftChild)
                parent.leftChild = null; 
            else
                parent.rightChild = null;
        }//end outer if
        
        else if(current.rightChild == null)
            if(current == null)
                root = current.leftChild;
            else if(isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        
        else if(current.leftChild == null)
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        
        else{
            Node successor = getSuccessor(current);
            if(current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            
            successor.leftChild = current.leftChild;
            
        }//end else
        
        return true;
    }//end delete
    
    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }//end while 
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }// end getsuccessor
    
    public void preOrder(Node localRoot){
        if(localRoot != null){
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }//end preOrder
    public void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }// end inOrder
    public void postOrder(Node localRoot){
        if(localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");

        }
    }//end postOrder
    public void levelOrder(Node localRoot){
        if(localRoot == null){
            System.out.print("empty");
            return;
        }
        java.util.LinkedList<Node> que = new java.util.LinkedList<Node>();
        que.push(localRoot);
        while(!que.isEmpty()){
            localRoot = que.removeFirst();
            System.out.print(localRoot.iData + " ");
            if(localRoot.leftChild != null){
                que.add(localRoot.leftChild);
            }
            if(localRoot.rightChild != null){
                que.add(localRoot.rightChild);
            }
        }
    }//end level order
    
    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(".........................................");
        while(isRowEmpty == false){
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for(int i = 0; i<nBlanks; i++)
                System.out.print(' ');
            
            while(globalStack.isEmpty() == false){
                Node temp = (Node)globalStack.pop();
                if(temp != null){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                }//end if
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }// end else 
                
                for(int i = 0; i <nBlanks*2-2; i++)
                    System.out.print(' ');
            }//end inner while loop
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty() == false){
                globalStack.push(localStack.pop());
            }//end while loop
        }//end outer while loop

        System.out.println(".........................................");

    }//end display
    
}// end tree
        
        
