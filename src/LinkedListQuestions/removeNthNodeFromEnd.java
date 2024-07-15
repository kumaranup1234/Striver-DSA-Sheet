package LinkedListQuestions;

public class removeNthNodeFromEnd {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count == n) {
            return head = head.next;
        }
        temp = head;
        int place = 0;
        while (place != count - n - 1) {
            temp = temp.next;
            place++;
        }
        if (temp.next.next != null) {
            temp.next = temp.next.next;
        }else{
            temp.next = null;
        }
        return head;
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
        // Creating nodes
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

        printList(removeNthFromEnd(head, 2));
    }
}
