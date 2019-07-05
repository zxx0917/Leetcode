/**
 * 两个指针，一个代表当前节点，一个代表当前节点的前节点，遍历链表，如果当前节点等于val，删除即可
 */
public class $203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0), cur = head, pre = fakeHead;
        fakeHead.next = head;
        while (cur != null) {
            if (cur.val == val) {
                //删除
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return fakeHead.next;
    }
}
