package LinkedListQuestions;

public class linkedListCycle2 {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // extended version of tortoise and hare method
    // after finding the cycle reset one of the pointers to the head and start again now only
    // incrementing once and the point of meet will be the starting point of loop
    public static Node hasCycle2(Node head) {
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
            return null;
        }

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        // Creating nodes
        Node head = new Node(3);
        Node second = new Node(2);
        Node third = new Node(0);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a cycle for testing
        fifth.next = second;  // Creating a cycle here
        System.out.println(hasCycle2(head).data);
    }
}
