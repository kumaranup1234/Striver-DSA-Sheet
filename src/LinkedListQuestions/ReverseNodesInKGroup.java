package LinkedListQuestions;

// logic toh I got myself
// implementation heavy
// revisit again

//  T.C O(2N)


public class ReverseNodesInKGroup {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node reverseKGroup(Node head, int k) {
        // Initialize a temporary node to traverse the list
        Node temp = head;

        // Initialize a pointer to track the last node of the previous group
        Node prevLast = null;

        // Traverse through the linked list
        while (temp != null) {
            // Get the Kth node of the current group
            Node kThNode = findKthNode(temp, k);

            // If the Kth node is NULL (not a complete group)
            if (kThNode == null) {
                // If there was a previous group, link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                // Exit the loop
                break;
            }

            // Store the next node after the Kth node
            Node nextNode = kThNode.next;

            // Disconnect the Kth node to prepare for reversal
            kThNode.next = null;

            // Reverse the nodes from temp to the Kth node
            reverse(temp);

            // Adjust the head if the reversal starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous group to the reversed group
                prevLast.next = kThNode;
            }

            // Update the pointer to the last node of the previous group
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }

        // Return the head of the modified linked list
        return head;
    }

    public Node findKthNode(Node head, int k) {
        k = k - 1; // we already start from that node
        Node temp = head;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Helper function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();

        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print the original list
        System.out.println("Original List:");
        obj.printList(head);

        int k = 2; // Set the value of k

        // Reverse nodes in k-group
        Node newHead = obj.reverseKGroup(head, k);

        // Print the modified list
        System.out.println("Modified List (Reversed in K-Group):");
        obj.printList(newHead);
    }
}
