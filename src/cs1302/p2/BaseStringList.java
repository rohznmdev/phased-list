package cs1302.p2;

import cs1302.adt.StringList;

/**
 * This class represents a base string list which is an implementation of the stringlist class.
 */
public abstract class BaseStringList implements StringList {

    // don't use array or node data structures

    //Initializes the insance variables
    protected int size;


    /**
     * This is the constructor for the class which sets the size instance variable to 0.
     */
    public BaseStringList() {
        // set the size to 0.
        size = 0;
    } // BaseStringList

    /**
     * Method that appends an item to the node at the size index.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(String item) {
        // creating a temp variable.
        boolean temp = false;
        // checking for exceptions.
        if (item.equals("")) {
            throw new IllegalArgumentException("Append: Item cannot be empty.");
        } else if (item == null) {
            throw new NullPointerException("Append: Item cannot be null");
        } // if
        // using the add method to append at the size index.
        add(size(), item);
        temp = true;
        // returning the result.
        return temp;
    } // append

    /**
     * Method that checks if the size is 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        boolean temp = false;
        //checks if the size is 0.
        if (size() == 0) {
            temp = true;
        }
        return temp;
    } // isEmpty

    /**
     * Method that returns the string starting with the start string, seperated by the sep string
     * and ending with the end string.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String makeStringTemp = start;
        //if it is empty then it will return an empty list.
        if (isEmpty() == true) {
            makeStringTemp = start + end;
        } else {
            // creating the correct string based on the index.
            for (int i = 0; i < size() - 1; i++) {
                makeStringTemp = makeStringTemp + this.get(i) + sep;
            }
            makeStringTemp = makeStringTemp + this.get(size() - 1) + end;
        }
        //returning the string.
        return makeStringTemp;
    } // makeString

    /**
     * Method that inserts the item at the index 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
        //checking for exceptions
        if (item.equals("")) {
            throw new IllegalArgumentException("Prepend: Item cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("Prepend: Item cannot be null");
        }
        //calling the add method.
        return add(0, item);
    } // prepend

    /**
     * Method that returns the size.
     *
     *<p>
     *{@inheritDoc}
     */
    @Override
    public int size() {
        //return the size of the object.
        return size;
    } // size

    /**
     *Method that returns the string with the specified contents.
     *
     *<p>
     *{@inheritDoc}
     */
    @Override
    public String toString() {
        // call the make string method.
        return makeString("[", ", ", "]");
    } // toString

} // BaseStringList
