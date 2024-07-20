package LinkedListQuestions;

public class rotateList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node rotateRight(Node head, int k) {
        int length = 1;
        Node temp = head;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        temp.next = head;
        Node newTail = head;
        int stepsToNewHead = length - k;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        printList(head);
        printList(rotateRight(head, 2));
    }
}
