package heap;


import java.util.PriorityQueue;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MergeKSortedList {
    /**
     * 1. Create a priority queue, sort by ascending order of the listNode by first element
     * the first list node and its first element will always be  smaller.
     * 2. create a dummy node
     * 3. insert all the element in the queue
     * 4. poll from queue
     * 5. append in the dummy node and increment dummy node
     * 6. increment the polled list node from the queue and if the node is not null pushed into the queue.
     **/
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            dummy.next = temp;
            dummy = dummy.next;
            temp = temp.next;
            if (temp != null) {
                priorityQueue.add(temp);
            }
        }
        return tail.next;
    }

    public static void main(String[] args) {
        /*  [[1,4,5],[1,3,4],[2,6]] */
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode3};
        mergeKLists(listNodes);
    }

}
