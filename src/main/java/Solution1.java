public class Solution1 {
    public static class LinkedListNode {
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    }

    ;

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val) {
        if (head == null) {
            head = new LinkedListNode(val);
        } else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }
}