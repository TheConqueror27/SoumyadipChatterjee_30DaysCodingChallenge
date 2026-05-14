import java.util.*;

public class Day_15 {

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

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode ptr1 = head1;
        SinglyLinkedListNode ptr2 = head2;

        while (ptr1 != ptr2) {

            if (ptr1 == null)
                ptr1 = head2;
            else
                ptr1 = ptr1.next;

            if (ptr2 == null)
                ptr2 = head1;
            else
                ptr2 = ptr2.next;
        }

        return ptr1.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   

        while (t-- > 0) {

            int index = sc.nextInt();

            SinglyLinkedList llist1 = new SinglyLinkedList();
            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist1Count = sc.nextInt();

            for (int i = 0; i < llist1Count; i++) {
                int data = sc.nextInt();
                llist1.insertNode(data);
            }

            int llist2Count = sc.nextInt();

            for (int i = 0; i < llist2Count; i++) {
                int data = sc.nextInt();
                llist2.insertNode(data);
            }

            SinglyLinkedListNode ptr1 = llist1.head;
            for (int i = 0; i < index; i++) {
                ptr1 = ptr1.next;
            }

            llist2.tail.next = ptr1;

            System.out.println(findMergeNode(llist1.head, llist2.head));
        }

        sc.close();
    }
}