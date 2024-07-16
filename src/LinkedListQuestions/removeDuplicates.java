package LinkedListQuestions;

public class removeDuplicates {
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

    public static Node removeDuplicatesSol(Node head){
        if(head.next == null){
            return head;
        }
        Node prev = head;
        Node curr = head.next;

        while(curr != null){
            if(prev.data != curr.data){
                prev.next = curr;
                curr.prev = prev;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }


    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a DLL
        Node head = new Node(1);
        Node second = new Node(1);
        Node third = new Node(1);
        Node fourth = new Node(2);
        Node fifth = new Node(3);

        // Linking nodes
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;


        // Print the original list
        System.out.println("Original List:");
        printList(head);

        // Print the modified list
        System.out.println("List after deleting all duplicates :");
        printList(removeDuplicatesSol(head));
    }
}
