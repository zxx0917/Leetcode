/**
 * 首先获取链表长度len，实际需要移动的位置是k%len。
 * 如1->2->3->4->5，k=2，移动后为4->5->1->2->3
 * 实际上是第len-k的下一个节点后的所有元素插到链表首位，如上述情况是4->5插入1->2->3之前，变为4->5->1->2->3
 * 所以找到需要插入的第一个节点，放入链表首位即可
 */
public class $61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        //获取链表长度
        int count = 0;
        ListNode fakeHead = new ListNode(0), cur = head, pre = fakeHead;
        fakeHead.next = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        //需要移动的次数为k % len
        k = k % count;

        //找到需要移动的节点
        cur = head;
        for (int i = 1; i < count - k; i++) {
            cur = cur.next;
        }

        //移位
        ListNode tmp = pre.next;
        pre.next = cur.next;
        cur.next = null;
        //找到移位链表的最后一个节点
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = tmp;

        return fakeHead.next;
    }
}
