package DataStructures;

import java.util.ArrayList;

/**
 * For this homework, you will be creating your very own
 * priority queue using the Heap data structure!
 *
 * This will allow you to always get the Node with the higest
 * priority in O(logN) time, regardless of the order that
 * Nodes were inserted.
 *
 * MAKE SURE TO READ THE COMMENTS CAREFULLY! Creating a priority queue
 * from scratch is no small task, but you can do it!! :)
 *
 * The five primary functions of the PriorityQueue are as follows:
 * 1. size(): gets the number of elements in the queue in O(1) time.
 * 2. peek(): gets the highest priority value in O(1) time.
 * 3. insert(): puts a new element into the queue and fixes the heap in O(logN) time.
 * 4. removeMax(): gets the highest priority value and fixes the heap in O(logN) time.
 * 5. changePriority(): edits the priority of an existing element and fixes the heap in O(logN) time.
 *
 * There are lots of helper functions that we recommend you fill out first
 * to make it go more smoothly (especially bubbleUp() and bubbleDown()).
 *
 */
public class MyPriorityQueue {

    /**
     * Uses the heap array representation to store Nodes (don't forget to implement them in Node.java!!!!)
     * Remember the max-heap properties:
     *  1. All parents must be higher priority than their children.
     *  2. A node at index i has its left child at position i*2.
     *  3. A node at index i has its left child at position i*2 + 1.
     *  4. A node at index i has its parent at position i/2 (rounded down).
     *  5. You can assume that no two nodes have the same priority for this implementation.
     */
    private ArrayList<Node> heapArray;

    public MyPriorityQueue() {
        // Init heapArray
        heapArray = new ArrayList<>();
        // Like LinkedLists, we should add a null sentinel node in element 0.
        // This will make calculating left/right nodes much easier.
        heapArray.add(null);
    }


    /////////////////////////////////////////////////////////////////////
    // PRIMARY METHODS                                                 //
    // It is recommended that you complete size() first,               //
    // then complete the helper methods before continuing              //
    // with this section.                                              //
    /////////////////////////////////////////////////////////////////////

    /** Returns the number of elements currently in this priority queue.
     *  Do not count the null node at index 0 as an element.
     */
    public int size() {
        // YOUR CODE HERE (replace line below)
        return heapArray.size()-1;
    }

    /**
     * Returns the value of the Node with the highest priority value, but does
     * not remove it from the heap. Returns null if heap is empty.
     * You can assume that no two elements have the same priority.
     */
    public String peek() {
        // YOUR CODE HERE (replace line below)
        if(size() == 0) return null;
        return heapArray.get(1).getValue();
    }

    /**
     * Insert a new item with the given priority into the queue.
     * Remember to follow these steps:
     *  1. Create a new Node.
     *  2. Insert the new node into the bottom of the heap (end of array).
     *  3. Call bubbleUp() to put the node into the proper location.
     */
    public void insert(String value, int priority) {
        // YOUR CODE HERE\
        Node n = new Node(value, priority);
        heapArray.add(n);
        bubbleUp(1);
    }

    /**
     * Removes the highest priority Node from the queue,
     * and returns its value. If the queue is empty, return null
     * and do nothing.
     * You can assume that no two elements have the same priority.
     *
     * Make sure that all heap properties are still preserved after
     * removing the node!! This can be done with the following steps:
     *  1. Identify the largest priority node (HINT: This should be easy and take O(1) time.)
     *  2. Swap the largest priority node with the node at the end of the list.
     *  2. Remove the node.
     *  3. bubbleDown() the node that is in the position that used to be
     *     filled by the highest priority node.
     */
    public String removeMax() {
        // YOUR CODE HERE (replace line below)
        if(size() == 0) return null;

        Node n = heapArray.get(1);
        swap(1, size());
        heapArray.remove(size());
        bubbleDown(1);

        return null;
    }

    /**
     * Changes the priority of an existing value to newPriority,
     * and fixes the heap afterwards.
     * You can assume that all values and priorities in the queue are unique.
     * If the item cannot be found, then do nothing.
     */
    public void changePriority(String value, int newPriority) {
        // Loop through all elements in heapArray
        for(int i=1; i<heapArray.size(); i++) {
            Node n = heapArray.get(i);
            // Check if node's value .equals() the one we're looking for.
            // If not, do nothing and go to next element
            if(n.getValue().equals(value)) {
                // Save the old priority
                int oldP = n.getPriority();
                // Change the priority
                n.setPriority(newPriority);
                // If the new priority is greater than the old priority, bubbleUp.
                if(newPriority > oldP) bubbleUp(i);
                else bubbleDown(i);
                // Otherwise, bubbleDown.
            }
        }
    }

    /////////////////////////////////////////////////////////////////////
    // HELPER METHODS                                                  //
    //  These shouldn't be accessible to programmers                   //
    //  using your priority queue, but will                            //
    // help you implement the methods above.                           //
    /////////////////////////////////////////////////////////////////////

    /** Switches the positions of the nodes at index1 and index2 in heapArray. */
    private void swap(int index1, int index2) {
        // YOUR CODE HERE
        Node node1 = heapArray.get(index1);
        Node node2 = heapArray.get(index2);
        this.heapArray.set(index1, node2);
        this.heapArray.set(index2, node1);
    }


    /**
     * Moves the node in the given index up the heap, until it
     * no longer needs to be moved to satisfy the heap properties.
     *
     * Skeleton code is provided for you, and you should modify the
     * placeholder values. If you don't want to use the skeleton code
     * you can just delete everything and start from scratch (not recommended).
     */
    private void bubbleUp(int index) {
        // Make sure the index is valid and the node is not null before continuing!!
        boolean indexValid = !(index <= 1);
        if (indexValid) {
            // Get the parent index
            int parentIndex = index/2;
            // Check if the node should be swapped (parent exists and is lower priority)
            boolean shouldSwap = heapArray.get(index).getPriority() < heapArray.get(parentIndex).getPriority();
            if (shouldSwap) {
                // Swap the two nodes.
                swap(index, parentIndex);
                // Recursively call bubbleUp on the parent index.
                bubbleUp(parentIndex);
            }
        }
    }
    /**
     * Moves the node in the given index down the heap, until it
     * no longer needs to be moved to satisfy the heap properties.
     *
     * Skeleton code is provided for you, and you should modify the
     * placeholder values. If you don't want to use the skeleton code
     * you can just delete everything and start from scratch (not recommended).
     */
    private void bubbleDown(int index) {
        // Make sure the index is valid and the node is not null before continuing!!
        boolean indexValid = !(index <= 1 && index > heapArray.size());
        if (indexValid) {
            // Get the child node with the highest priority using getNode().
            // (i.e. choose the left node if it exists and it is higher priority than the right node)
            // Make sure to verify that nodes are not null before checking their priorities!!
            Node leftNode = heapArray.get(index/2); // Remember the heap properties (see heapArray comment)!
            Node rightNode = heapArray.get(index/2+1);

            int indexToChoose = 0;
            Node nodeToChoose = null;
            if (leftNode.getPriority() > rightNode.getPriority()) { // Fill in this if statement with the logic described above.
                nodeToChoose = leftNode;
                indexToChoose = index/2;
            } else {
                nodeToChoose = rightNode;
                indexToChoose = index/2+1;
            }

            // Check if the node should be swapped (indexToChoose node exists and is higher priority)
            boolean shouldSwap = nodeToChoose != null && nodeToChoose.getPriority() > heapArray.get(index).getPriority();
            if (shouldSwap) {
                // Swap the two nodes.
                swap(index, indexToChoose);
                // Recursively call bubbleDown on indexToChoose.
                bubbleDown(indexToChoose);

            }
        }
    }
}