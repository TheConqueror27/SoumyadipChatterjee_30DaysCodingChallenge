import java.io.*;
import java.util.*;

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public void insertNode(int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }

        tail = node;
    }
}

class Result {

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head == null) {
            return newNode;
        }

        if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode current = head;

        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;

        return head;
    }
}

public class Day_09 {

    public static void printDoublyLinkedList(DoublyLinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            DoublyLinkedList list = new DoublyLinkedList();

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int data = sc.nextInt();
                list.insertNode(data);
            }

            int data = sc.nextInt();

            DoublyLinkedListNode result = Result.sortedInsert(list.head, data);

            printDoublyLinkedList(result);
        }

        sc.close();
    }
}