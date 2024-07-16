package LinkedListQuestions;

public class deleteAllOccurrencesOfX {
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

    public static Node deleteAllOccurOfX(Node head, int x) {
        if (head.next == null) {
            if (head.data == x){
                return null;
            }
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                // if its head node
                if (temp == head){
                    head = head.next;
                }else{
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                    if (temp.prev != null) {
                        temp.prev.next = temp.next;
                    }
                }
            }
            temp = temp.next;
        }
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
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(2);
        Node fifth = new Node(4);

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

        // Delete all occurrences of x = 2
        int x = 2;
        head = deleteAllOccurOfX(head, x);

        // Print the modified list
        System.out.println("List after deleting all occurrences of " + x + ":");
        printList(head);
    }
}
