/**
 * 使用快慢指针找到后半部分链表，翻转后半部分，然后逐个比较
 */
public class $234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //快慢指针找终点
        if(head == null) return true;
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转后半部分
        ListNode reverse = reverse(slow);
        //比较前后两部分
        while(reverse != null){
            if(head.val != reverse.val) return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
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
