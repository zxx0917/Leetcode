//题目需要将当前元素的next改为前一个元素，所以使用两个指针分别指代前一个元素和当前元素，因为当前元素的next方法已经改变，所以需要使用变量来储存原链表中的下一个元素
public class $206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head,pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
