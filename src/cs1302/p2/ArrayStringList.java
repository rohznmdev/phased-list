package cs1302.p2;

import cs1302.adt.StringList;

/**
 * This class represents the ArrayList implementation of a string list.
 */

public class ArrayStringList extends BaseStringList {

    //initializes the instance variables needed for this class
    private String[] items;

    /**
     * This is the constructor for the class which creates a String array with 10 empty items.
     */
    public ArrayStringList() {
        items = new String[100];
    } // ArrayStringList


    /**
     * Test method that checks if the size of the array is equal to the length -1.
     * @return true if the two are equal.
     */
    // for testing
    private boolean checkSize() {
        //returns true if the index passed in is not in the array length
        boolean temp = false;
        if (size() == items.length - 1) {
            // index is not in array range proceed to make new array and copy
            temp = true;
        } // if
        return temp;
    }

    /**
     * Test method that sets an int to 30% larger than the length of the array
     * made in the constructor.
     * @return int which is 30% larger than the length of the array.
     */
    private int arraySizeIncrease() {
        //increases the size of the array by 30 percent.
        int arrSize = (int)Math.round(items.length * 0.3);
        return arrSize;
    } // arraySizeIncrease

    /**
     * Adds an item to the specified index of the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        // this method returns true if the value was successfully added
        // checking for exceptions
        if (item.equals("")) {
            throw new IllegalArgumentException("Add: Item cannot be empty");
        } // if
        if (item == null) {
            throw new NullPointerException("Add: Item cannot be null");
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Add: Index is out of bounds");
        } // if
        boolean temp = false;
        String[] addTemp = new String[size()];
        //creating a temp array with the size of the original array.
        int newArrSize = size() + arraySizeIncrease();
        // setting the items of the temp array to the item of the original array at the index.
        for (int i = 0; i < size(); i++) {
            addTemp[i] = get(i);
        } // for
        // if the array needs to be larger it will make a new one with size 30% larger
        // than the previous one.
        if (checkSize() == true) {
            items = new String[newArrSize];
        }
        int j = 0;
        // adding the index
        for (int i = 0; i < size() + 1; i++) {
            if (i == index) {
                items[i] = item;
                j = 1;
            } else {
                items[i] = addTemp[i - j];
            }
        } // for
        //returning the result and increasing the size.
        temp = true;
        size++;
        return temp;
    } // add

    /**
     * Sets all the items in the array to null and sets the size to 0.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        //looping through each index
        for (int i = 0; i < items.length - 1; i++) {
            //setting all indexes to null
            items[i] = null;
            // changing the size to 0.
            this.size = 0;
        } // for
    } // clear

    /**
     * Gets the item of the specified index of the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        //checking for exceptions
        String getTemp = "";
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Get: Index is out of bounds");
        } else {
            // returning the value of the array at the specified index.
            getTemp = items[index];
        }
        return getTemp;
    } // get

    /**
     * Removes the item of the specified index of the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        //checking for exceptions
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Remove: Index is out of bounds");
        }
        //making a temp variable
        String temp = get(index);
        //looping through the array
        for (int i = index; i < items.length - 1; i++) {
            items[i] = items[i + 1];
        }
        //decrementing the size and returning the string that was removed.
        size--;
        return temp;
    } // remove

    /**
     * Method that returns the string list with all the items from the start to stop index.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        // checking for exceptions
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Slice: Index is out of bounds");
        } // if
        // creating a new ArrayStringList object.
        BaseStringList slicedArea = new ArrayStringList();
        // returning the new list with the required elements.
        if (start == stop) {
            slicedArea.makeString("[", ", ", "]");
        } else if (start != stop) {
            for (int i = start; i < stop; i++) {
                slicedArea.append(items[i]);
            } // for
        } // if
        return slicedArea;
    } // slice
} // ArrayStringList
