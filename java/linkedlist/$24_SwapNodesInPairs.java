/**
 * 给链表设定伪头，方便最后返回链表。
 * 题目实际上交换相邻奇数位和偶数位的节点，所以设定一个变量储存奇数位上的节点，一个变量储存上一对偶数位的节点，逐个交换即可
 */
public class $24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode odd = head,p = fakeHead,even = null;
        while(odd != null && odd.next != null){
            //获取偶数位节点
            even = odd.next;

            //交换
            odd.next = even.next;
            even.next = odd;
            p.next = even;

            //进入到下一对
            p = odd;
            odd = odd.next;
        }
        return fakeHead.next;
    }
}
