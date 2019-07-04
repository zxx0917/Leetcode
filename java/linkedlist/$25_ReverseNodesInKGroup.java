/**
 * 首先求出整条链表的节点个数，需要翻转的组数group为count/k
 * 然后使用双指针，一个指针pre指向当前组第一个待插入元素的前置元素，另一个指针cur指向当前需要翻转的元素，翻转(group*(k-1))次即可
 */
public class $25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        //1.获得链表节点个数
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        //2.获得需要翻转的组数
        int group = count / k;

        ListNode fakeHead = new ListNode(0), pre = fakeHead;
        cur = head;
        fakeHead.next = head;
        //3.开始翻转
        while (group-- > 0) {
            //3.1 组内翻转k-1次
            for (int i = 0; i < k - 1; i++) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }

            //3.2 开始下一次翻转
            pre = cur;
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
