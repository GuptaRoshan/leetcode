package linkedList;

public class PalindromicLinkedList {
    public static boolean isPalindrome(Node head) {

        // find the middle of linked List
        Node slow = head;
        Node fast = head;

        Node previous = null;
        Node current = head;
        Node next = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Reverse first half of the linked List
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        //Move slow pointer one step further if there are odd number of nodes
        if (fast != null) {
            slow = slow.next;
        }

        while (previous != null && slow != null) {
            if (previous.data == slow.data) {
                return true;
            }
            previous = previous.next;
            slow = slow.next;
        }

  /*
        // Reverse second half of the linked List
        Node previous = null;
        Node current = slow;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        Node temp = head;
        while (previous != null && temp != null) {
            if (temp.data != previous.data) {
                return false;
            }
            previous = previous.next;
            temp = temp.next;
        }


   */
        return true;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(1);
        linkedList.addInTail(2);
        linkedList.addInTail(3);
        linkedList.addInTail(2);
        linkedList.addInTail(1);
        System.out.println(isPalindrome(linkedList.head));
    }

}
