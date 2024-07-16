package LinkedListQuestions;

public class sortLinkedListOf012 {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node segregate(Node head) {
        int[] arr = new int[3];
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0){
                arr[0]++;
            }else if (curr.data == 1){
                arr[1]++;
            }  else {
                arr[2]++;
            }
            curr = curr.next;
        }
        curr = head;
        int count0 = arr[0];
        int count1 = arr[1];
        int count2 = arr[2];
        while (count0 != 0) {
            curr.data = 0;
            curr = curr.next;
            count0--;
        }
        while (count1 != 0) {
            curr.data = 1;
            curr = curr.next;
            count1--;
        }
        while (count2 != 0) {
            curr.data = 2;
            curr = curr.next;
            count2--;
        }
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
        Node second = new Node(2);
        Node third = new Node(2);
        Node fourth = new Node(0);
        Node fifth = new Node(1);

        // Linking nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        printList(head);
        printList(segregate(head));
    }
}
