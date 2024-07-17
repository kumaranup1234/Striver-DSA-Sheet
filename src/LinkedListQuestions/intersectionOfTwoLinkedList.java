package LinkedListQuestions;

public class intersectionOfTwoLinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        int lengthA = 0, lengthB = 0;
        Node currA = headA, currB = headB;
        while (currA != null) {
            lengthA++;
            currA = currA.next;
        }
        while (currB != null) {
            lengthB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;
        
        if (lengthA > lengthB){
            for (int i = 0; i < lengthA-lengthB; i++) {
                currA = currA.next;
            }
        }else{
            for (int i = 0; i < lengthB-lengthA; i++) {
                currB = currB.next;
            }
        }
        // in the question we want to compare the actual node
        // location not the data
        // the input has to do in that way
        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // Creating nodes
        Node head = new Node(4);
        Node second = new Node(1);
        Node third = new Node(8);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        Node head1 = new Node(5);
        Node second1 = new Node(6);
        Node third1 = new Node(1);
        Node fourth1 = new Node(8);
        Node fifth1 = new Node(4);

        // Linking nodes
        head1.next = second1;
        second1.next = third1;
        third1.next = fourth1;
        fourth1.next = fifth1;

        System.out.println(getIntersectionNode(head, head1));
    }
}
