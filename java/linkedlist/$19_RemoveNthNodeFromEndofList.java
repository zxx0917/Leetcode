public class $19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //获取链表长度，删除第len-n+1个元素即可
        if(head == null) return null;
        int len = 0;
        ListNode fakeHead = new ListNode(0),cur = head;
        fakeHead.next = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }

        //找到第len-n+1个元素的前置元素
        ListNode pre = fakeHead;
        int count = 0;
        while(++count < len-n+1){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return fakeHead.next;
    }
}
