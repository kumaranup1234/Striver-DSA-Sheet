package LinkedList;

public class LL {
    Node head;
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
            newNode.next = head;
            head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = null;
    }

    public void printList(){
        if (head == null){
            System.out.println("List is empty");
        }
        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public void deleteFirst(){
        if (head == null){
            System.out.println("List is empty");
        }
        head = head.next;
    }
    public void deleteLast(){
        if (head == null){
            System.out.println("List is empty");
        }
        if (head.next == null){
            head = null;
            return;
        }
        Node currNode = head;
        while (currNode.next.next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }

    public static void main(String[] args) {
        LL list= new LL();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.deleteLast();
        list.printList();
    }
}
