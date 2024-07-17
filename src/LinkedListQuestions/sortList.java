package LinkedListQuestions;

public class sortList {
    public static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // T.C O(log n * (n + n / 2))

    public static Node sortListSol(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortListSol(left);
        right = sortListSol(right);

        return mergeTwoLists(left, right);
    }

    static Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return dummy.next;
    }

    static Node findMiddle(Node head) {
        Node slow = head;
        // we want first middle that why little bit modified
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        Node head = new Node(5);
        Node second = new Node(4);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node fifth = new Node(1);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        printList(head);
        printList(sortListSol(head));
    }
}
