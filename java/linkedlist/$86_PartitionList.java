/**
 * 原链表上保留大于等于x的节点，新建一个链表保留小于x的节点，最后将两个链表拼接起来即可
 */
public class $86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode moreListNode = new ListNode(0), lessListNode = new ListNode(0), cur = head;
        moreListNode.next = head;
        ListNode preMore = moreListNode, preLess = lessListNode;
        while (cur != null) {
            //判断当前节点大小
            if (cur.val < x) {
                //放入新链表中
                ListNode tmp = cur.next;
                preMore.next = tmp;
                preLess.next = cur;
                preLess = preLess.next;
                cur = tmp;
            } else {
                //保留在原链表
                preMore = cur;
                cur = cur.next;
            }
        }
        //合并
        preLess.next = moreListNode.next;
        return lessListNode.next;
    }
}
