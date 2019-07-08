/**
 * 1.找到中点
 * 2.翻转中点之后的链表
 * 3.拼接两个链表
 */
public class $143_ReorderList {
    public void reorderList(ListNode head) {
        //1.找到中点
        if(head == null) return;
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //2.翻转中点之后的链表
        ListNode reverse = reverse(slow.next);
        slow.next = null;

        //3.逐步插入
        ListNode cur = head;
        while(reverse != null){
            ListNode reTmp = reverse.next;
            reverse.next = cur.next;
            cur.next = reverse;
            reverse = reTmp;
            cur = cur.next.next;
        }
    }

    private ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0),pre = fakeHead;
        fakeHead.next = head;
        while(head.next != null){
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return fakeHead.next;
    }
}
