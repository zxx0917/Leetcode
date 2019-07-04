/**
 * 首先为元素组定义一个假头，方便后续数组返回。
 * 定义计数器，根据m找到第一个待翻转元素之前的元素，使用pre代替，然后使用cur找到当前需要翻转的节点，将节点插入pre之后即可
 * 翻转需要的次数为n-m
 */
public class $92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        //1.找出第一个待翻转元素之前的元素
        ListNode fakeHead = new ListNode(0), pre = fakeHead;
        fakeHead.next = head;
        int count = 0;
        while (++count < m) {
            pre = pre.next;
        }

        //2.找到待翻转元素
        ListNode cur = pre.next;
        count = 0;
        while (cur != null && cur.next != null && count < n - m) {
            //3.翻转
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
            count++;
        }
        return fakeHead.next;
    }
}
