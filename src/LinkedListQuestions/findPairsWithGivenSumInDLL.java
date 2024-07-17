package LinkedListQuestions;

import java.util.ArrayList;

public class findPairsWithGivenSumInDLL {
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

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (head == null) {
            return res;
        }

        Node front = head;
        Node back = head;

        // Move 'back' to the end of the list
        while (back.next != null) {
            back = back.next;
        }
        // front.prev != back -> back should not cross front
        while (front != null && back != null && front != back && front.prev != back) {
            int sum = front.data + back.data;
            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(front.data);
                pair.add(back.data);
                res.add(pair);
                front = front.next;
                back = back.prev;
            } else if (sum > target) {
                back = back.prev;
            } else {
                front = front.next;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(4);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(5);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        int target = 7;
        ArrayList<ArrayList<Integer>> result = findPairsWithGivenSum(target, head);
        for (ArrayList<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
