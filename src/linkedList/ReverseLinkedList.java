package linkedList;

public class ReverseLinkedList {
    public static Node reverse(Node head) {
        if (head != null) {
            Node previous = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addInHead(2);
        linkedList.addInHead(5);
        linkedList.addInHead(7);
        linkedList.addInHead(8);
        //linkedList.addInHead(9);
        linkedList.printList(linkedList.head);
        System.out.println();
        linkedList.printList(reverse(linkedList.head));
    }
}
