package LinkedList;

// we can create a doubly linked list using one pointer with every node by taking
// XOR addresses of previous and next nodes

public class DLL {
    static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head;

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void insertAtIdx(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            insertFirst(data);
            return;
        }
        Node temp = head;
        int count = 0;
        while (count < pos - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null && count + 1 < pos) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteHead() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteTail() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    public void deleteAtIdx(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            deleteHead();
            return;
        }
        Node temp = head;
        int count = 0;
        while (count < index && temp != null) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Index out of bounds");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertFirst(4);
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(1);
        dll.insertLast(5);
        dll.insertLast(6);
        dll.insertAtIdx(7, 3);
        dll.deleteHead();
        dll.deleteTail();
        dll.deleteAtIdx(2);
        dll.printList();
    }
}