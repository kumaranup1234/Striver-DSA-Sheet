package LinkedListQuestions;

public class flattenLinkedList {
    public static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    // H.n - n
    // v.n - m
    // T.C O(n^2 * m)
    // s.c O(n) recursive stack space
    static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergedHead = flatten(head.next);
        return merge(head, mergedHead);
    }

    static Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node res = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                res.bottom = l1;
                res = l1;
                l1 = l1.bottom;
            } else {
                res.bottom = l2;
                res = l2;
                l2 = l2.bottom;
            }
        }

        if (l1 != null) {
            res.bottom = l1;
        } else {
            res.bottom = l2;
        }
        return dummy.bottom;
    }

    // Method to print the flattened linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // Flatten the list
        Node flattenedList = flatten(head);

        // Print the flattened list
        printList(flattenedList);
    }
}
