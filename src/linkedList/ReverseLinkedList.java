package linkedList;

public class ReverseLinkedList {
    public static Node reverse(Node root) {
        if (root != null) {
            Node previous = null;
            Node current = root;
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
        linkedList.addInTail(2);
        linkedList.addInTail(5);
        linkedList.addInTail(7);
        linkedList.addInTail(8);
        linkedList.addInTail(9);
        linkedList.printList(linkedList.head);
        System.out.println();
        linkedList.printList(reverse(linkedList.head));
    }
}
