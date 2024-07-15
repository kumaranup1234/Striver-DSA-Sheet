package LinkedListQuestions;

public class findLengthOfLoop {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static int hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return 0;
        }
        slow = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        int count = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            count++;
        }
        return count;
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

        // Creating a cycle for testing
        fifth.next = second;  // Creating a cycle here
        System.out.println(hasCycle(head));
    }
}
