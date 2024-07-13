package LinkedListQuestions;

public class reverseDLL {
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

    public Node reverseDLLSol(Node head) {
        Node temp = null;
        Node curr = head;

        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        if(temp != null){
            head = temp.prev;
        }
        return head;
    }

    public void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reverseDLL reverseDLL = new reverseDLL();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original List:");
        reverseDLL.printList(head);

        head = reverseDLL.reverseDLLSol(head);

        System.out.println("Reversed List:");
        reverseDLL.printList(head);
    }
}
