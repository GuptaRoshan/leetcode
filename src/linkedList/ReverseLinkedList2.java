package linkedList;

public class ReverseLinkedList2 {
    public static Node reverseBetween(Node head, int left, int right) {
        Node leftPointer = head;
        Node prevLeftPointer = null;
        Node rightPointer = null;
        Node nextRightPointer = null;

        if (head == null || head.next == null || left == right) {
            return head;
        }

        int counter = 1;

        while (leftPointer != null) {
            if (counter == left) break;
            prevLeftPointer = leftPointer;
            leftPointer = leftPointer.next;
            counter++;
        }

        if (leftPointer == null) {
            return head;
        }

        rightPointer = leftPointer;

        while (rightPointer != null) {
            if (counter == right) break;
            rightPointer = rightPointer.next;
            nextRightPointer = rightPointer.next;
            counter++;
        }

        if (rightPointer == null) {
            return head;
        }

        Node previous = null;
        Node current = leftPointer;
        Node next = null;


        while (current != null && current != nextRightPointer) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (prevLeftPointer == null && nextRightPointer == null) return previous;

        if (prevLeftPointer != null) {
            prevLeftPointer.next = rightPointer;
        }else {
            head = rightPointer;
        }

        if (leftPointer != null) {
            leftPointer.next = nextRightPointer;
        }


        return head;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(1);
        linkedList.addInTail(2);
        linkedList.addInTail(3);
//        linkedList.addInTail(4);
//        linkedList.addInTail(5);
        linkedList.printList(linkedList.head);
        System.out.println();
        linkedList.printList(reverseBetween(linkedList.head, 1, 2));
    }


}
