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
public class HashTable {
    private Tree[] hashArray; // array of lists
    private int arraySize;
// -------------------------------------------------------------
    public HashTable(int size){
        arraySize = size;
        hashArray = new Tree[arraySize]; // create array
        for(int j=0; j<arraySize; j++) // fill array
            hashArray[j] = new Tree(); // with trees
    }
    public void displayTable(){
        for(int j=0; j<arraySize; j++){
            System.out.print(j + ". "); // display cell number
            hashArray[j].displayTree(); // display tree
        }
       }
// -------------------------------------------------------------
    public int hashFunc(int key){
        return key % arraySize;
    }
// -------------------------------------------------------------
    public void insert(Node theNode){
        int key = theNode.getKey();
        double data = theNode.getData();
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].insert(key,data); // insert at hashVal
    } // end insert()
// -------------------------------------------------------------
    public void delete(int key){
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].delete(key); // delete link
    } // end delete()
// -------------------------------------------------------------
    public Node find(int key){
        int hashVal = hashFunc(key); // hash the key
        Node theNode = hashArray[hashVal].find(key); // get link
        return theNode; // return link
    }
// -------------------------------------------------------------
}
