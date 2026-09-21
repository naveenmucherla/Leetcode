class MyLinkedList {
    // 1. Define the custom Singly Linked List Node from scratch
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    /** Initializes the MyLinkedList object. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /** Get the value of the indexth node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // Fixed bounds condition using OR (||) instead of AND (&&)
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /** Append a node of value val as the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }
    
    /** Add a node of value val before the indexth node in the linked list. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        Node newNode = new Node(val);
        Node curr = head;
        // Traverse to the node right before the targeted insertion index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }
    
    /** Delete the indexth node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            // Traverse to the node right before the targeted deletion index
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */