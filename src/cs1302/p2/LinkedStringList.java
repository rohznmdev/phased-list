package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.StringList;


/**
 * This class is the Linked List implementation of a string list.
 */

public class LinkedStringList extends BaseStringList {

    // node takes (item: String, next: Node)
    private Node head;

    /**
     * This is the constructor for the class which sets the head node to null.
     */
    public LinkedStringList() {
        head = null;
    } // LinkedStringList

    /**
     * Method that adds a node to the specified index with the contents of the item.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        // checking for exceptions
        if (item.equals("")) {
            throw new IllegalArgumentException("Item cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("Item cannot be null");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Add: invalid index");
        } // if
        // setting temp variables/nodes
        boolean btemp = false;
        Node temp = new Node(item, head);
        // if the index is 0 it will add the item to the head node.
        if (index == 0 && size() == 0) {
            head = new Node(item);
            if (index == size() && btemp == true) {
                head = new Node(item, head.getNext());
            }
            // set the head to the temp node created.
        } else if (index == 0 && size() > 0) {
            head = temp;
        } else {
            Node start = head;
            Node tempNode = new Node(item);
            // traversing the nodes until the desired index.
            for (int i = 0; i < index - 1; i++) {
                start = start.getNext();
            }
            // setting the node
            tempNode.setNext(start.getNext());
            start.setNext(tempNode);
        }
        // incrementing size and returning true.
        btemp = true;
        size++;
        return btemp;
    } // add

    /**
     * Method that clears the contents of the array by setting the head to null.
     * Also sets the size to 0.
     */
    @Override
    public void clear() {
        // setting the head to null and size to 0.
        head = null;
        size = 0;
    } // clear

    /**
     * Method that gets the item of a node at a specified index.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        // checking for exceptions
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Get: Index Out of Bounds");
        }
        // making temp variables and nodes.
        String getTemp;
        Node getTempNode = head;
        // traversing the node to the desired index.
        for (int i = 0; i < index; i++) {
            getTempNode = getTempNode.getNext();
        }
        // returning the value at that index.
        getTemp = getTempNode.getItem();
        return getTemp;
    } // get

    /**
     * Method that removes a node at a specified index.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        // checking for exceptions
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Remove: Index Out of Bounds");
        }
        // making temp variables and nodes.
        String getTemp = get(index);
        Node removeTempNode = head;
        // if the index is 0 it will just return that node and remove it.
        if (index == 0) {
            head = removeTempNode.getNext();
        } else {
            // traversing the nodes
            for (int i = 0; i < index - 1; i++) {
                removeTempNode = removeTempNode.getNext();
            }
            // setting the nodes appropriately.
            removeTempNode.setNext(removeTempNode.getNext().getNext());

        }
        // decrementing size and returning the string that was removed.
        size--;
        return getTemp;
    } // remove

    /**
     * Helper method that checks if the item of a node is null.
     * @return true if the item at the node is null.
     * @param item the item of a node to check.
     */
    private boolean checkNull(String item) {
        // setting a temp boolean variable
        boolean temp = false;
        // checking the item of a node.
        if (item == null) {
            temp = true;
        }
        // returning the result.
        return temp;
    }

    /**
     * Method that will return a new stringlist with all the items from start to stop.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        // checking for exceptions
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Slice: Index Out of Bounds");
        } // if
        // creating a new LinkedString list object
        BaseStringList slicedArea = new LinkedStringList();
        int j = 0;
        // for loop to return the array with the required elements.
        for (int i = start; i < stop; i++) {
            String sliceTemp = get(i);
            slicedArea.add(j, sliceTemp);
            j++;
        }
        // returning the sliced portion
        return slicedArea;
    } // slice

} // LinkedStringList
