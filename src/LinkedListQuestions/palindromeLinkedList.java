package LinkedListQuestions;

public class palindromeLinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the middle part
        Node next;
        Node prev = null;
        Node curr = slow;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node temp = head;

        while (prev != null && temp != slow) {
            if (prev.data != temp.data) {
                return false;
            }
            temp = temp.next;
            prev = prev.next;
        }
        return true;
    }
    public static void main(String[] args) {
        // Creating nodes
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(2);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        System.out.println(isPalindrome(head));
    }
}
