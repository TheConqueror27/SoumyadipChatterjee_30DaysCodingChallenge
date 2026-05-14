import java.io.*;
import java.util.*;
public class Day_02 {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;
        SinglyLinkedList() {
            head = null;
            tail = null;
        } 
        void insertNode(int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }

            tail = node;
        }
    }
    static void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head.data);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while (t--> 0) {
            SinglyLinkedList list = new SinglyLinkedList();
            int n = sc.nextInt(); 
            for (int i = 0; i < n; i++) {
                int data = sc.nextInt();
                list.insertNode(data);
            }
            reversePrint(list.head);
        }
        
        sc.close();
    }
}