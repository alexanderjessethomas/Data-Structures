/**
 * This is the interface for the MyBinarySearchTree class.
 *
 * MyBinarySearchTree takes a Generic Key which extends Comparable,
 * as well as a Generic Value. The Key is a Comparable type used for
 * traversing the tree, while the value is the contents of the node.
 *
 * @author Jean-Paul Labadie
 * @since 11-20-2015
 */
public interface BinarySearchTree <Key extends Comparable<Key>,Value> {

    /**
     * @return return true if the tree is empty
     */
    boolean isEmpty();

    /**
     * @param key the key to search for
     * @return the Value of the Node paired with the input key
     */
    Value find(Key key);

    /**
     * Inserts a new key-value pair node into the tree.
     * If the key already exists in the tree, overwrite the value at that Node
     * @param key the key which determines the place of this new node
     * @param val the value which will be stored under this key
     * @return return either the value val, or the value of the overwritten node
     */
    Value insert(Key key, Value val);

    /**
     * @param key the key of the Node to delete
     * @return tbe Value of the node that was deleted, or null if it can't be found
     */
    Value delete(Key key);

    /**
     * Returns the current tree in level-order traversal.
     * The String should not contain newlines, returns, etc.
     * Key-Value pairs should be presented together.
     * Use this exact format:
     * {(key=value), (key=value)}
     * This format is described here http://docs.oracle.com/javase/7/docs/api/java/util/AbstractMap.html#toString()
     *
     * @return the string of the level-order-traversal
     */
    String stringLevelOrder();
}
