/**
 * 方法1：不需要翻转链表：找到链表最后节点，直接加1，然后从尾往头更新进位，这里从尾往头遍历时需要每次找到当前节点的前置节点。
 * 方法2：翻转链表，头结点+1，处理进位，然后再翻转回来
 */
public class $369_PlusOneLinkedList {
    //方法1：不翻转链表
    public ListNode plusOne1(ListNode head) {
        //遍历到最后一个节点
        ListNode fakeHead = new ListNode(0), cur = head;
        fakeHead.next = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        //最后一位加1，从尾更新到头
        int carry = 0;
        cur.val += 1;
        while (cur != fakeHead) {
            int x = cur.val + carry;
            carry = x / 10;
            cur.val = x % 10;
            //从前往后找到cur的前节点
            ListNode pre = fakeHead;//用来指代前节点
            while (pre.next != cur) {
                pre = pre.next;
            }
            //往前进一位
            cur = pre;
        }
        //判断最高位是否需要进位
        if (carry > 0) {
            ListNode tmp = new ListNode(1);
            tmp.next = fakeHead.next;
            fakeHead.next = tmp;
        }
        return fakeHead.next;
    }

    //方法2：翻转链表
    public ListNode plusOne2(ListNode head) {
        ListNode reverse = reverseListNode(head);

        //头结点+1
        ListNode cur = reverse;
        cur.val += 1;
        int carry = 0;
        while(cur != null){
            int x = cur.val + carry;
            carry = x / 10;
            cur.val = x % 10;
            cur = cur.next;
        }

        //还原
        ListNode res = reverseListNode(reverse);
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = res;

        //最高位是否需要进位
        if(carry > 0){
            ListNode tmp = new ListNode(1);
            tmp.next = fakeHead.next;
            fakeHead.next = tmp;
        }

        return fakeHead.next;
    }

    //翻转链表
    private ListNode reverseListNode(ListNode head){
        ListNode fakeHead = new ListNode(0),pre = fakeHead,cur = head;
        fakeHead.next = head;
        while(cur.next != null){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return fakeHead.next;
    }
}
