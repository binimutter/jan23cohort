public class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;
    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void removeLast() {
    if (head == null) {
        return; // list is empty
    }
    if (head.next == null) {
        head = null; // list has only one node
        return;
    }
    Node currentNode = head;
    while (currentNode.next.next != null) {
        currentNode = currentNode.next;
    }
    currentNode.next = null;
}
    
    public void display() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.display(); // Output: 1 2 3
    }
}
