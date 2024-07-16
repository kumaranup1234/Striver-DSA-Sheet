package LinkedListQuestions;

public class add1ToALinkedListInteger {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // reverse the linked list
    // then add carry over the digits carefully
    // the reverse the list again
    public static Node addOne(Node head)
    {
        if(head == null){
            return null;
        }
        Node curr = reverseList(head);
        Node temp = curr;
        printList(curr);
        int carry = 1;


        while(temp != null){
            int sum = temp.data + carry;
            carry = sum / 10;
            // mod for storing the last digit only as we need to store the last digit only
            temp.data = sum % 10;

            if (carry == 0){
                break;
            }
            // for the last node where carry is 1, so we need to create a new node
            // for the carry value
            // and make th carry as 0 then
            if (temp.next == null && carry > 0){
                temp.next = new Node(carry);
                // to break the loop
                carry = 0;
            }
            temp = temp.next;
        }
        return reverseList(curr);
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
        Node head = new Node(1);
        Node second = new Node(3);
        Node third = new Node(2);
        Node fourth = new Node(5);
        Node fifth = new Node(4);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        printList(head);
        printList(addOne(head));
    }
}
