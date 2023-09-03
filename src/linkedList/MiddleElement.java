package linkedList;

public class MiddleElement {
    public static int middle(Node root) {
        Node fast = root;
        Node slow = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
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
        System.out.println("Middle element : " + middle(linkedList.head));
    }
}
