/**
 * 1.迭代法：设置两个指针分别指代两条链表的当前元素，遍历至一条链表末端。因为原先链表有序，所以将剩余的链表直接拼接
 * 2.递归法
 */
public class $21_MergeTwoSortedLists {
    //迭代法：
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //给新链表生成假头，方便后续返回
        ListNode head = new ListNode(0), tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        //因为原先链表有序，所以将剩余的链表直接拼接
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    //递归法：
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}
