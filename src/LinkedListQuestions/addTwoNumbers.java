package LinkedListQuestions;

public class addTwoNumbers {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addTwoNumbersSol(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        while (l1 != null || l2!= null) {
            int x = l1 != null ? l1.data : 0;
            int y = l2 != null ? l2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        if (carry > 0){
            curr.next = new Node(carry);
        }

        return dummy.next;
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
        Node head = new Node(2);
        Node second = new Node(4);
        Node third = new Node(3);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = null;

        Node head1 = new Node(5);
        Node second1 = new Node(6);
        Node third1 = new Node(4);

        // Linking nodes
        head1.next = second1;
        second1.next = third1;
        third1.next = null;

        printList(head);
        printList(addTwoNumbersSol(head, head1));
    }
}
