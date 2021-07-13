package DataStructures;

public class Node {
    private String value;
    private int priority;

    public Node(String value, int priority) {
        // YOUR CODE HERE
        this.value = value;
        this.priority = priority;
    }

    // Add your own getter/settter/helper methods here (get/set priority, value, etc.)

    // YOUR CODE HERE

    public int getPriority() {
        return this.priority;
    }

    public String getValue() {
        return this.value;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
