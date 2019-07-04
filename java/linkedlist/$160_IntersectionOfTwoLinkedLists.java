/*
 *  统一链表长度，然后从等长的地方开始遍历，如果p = q，则表示遇到交点
 *  这里分别计算两个链表的长度，然后根据较短的长度修成较长链表的起始位置，然后两者一起遍历，直至遇到交点或者都为Null
 */
public class $160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //1.计算headA的长度
        int countA = 0;
        ListNode p = headA;
        while (p != null) {
            countA++;
            p = p.next;
        }

        //2.计算headB的长度
        int countB = 0;
        ListNode q = headB;
        while (q != null) {
            countB++;
            q = q.next;
        }

        //统一长度
        p = headA;
        q = headB;
        if (countA > countB) {
            while (countA > 0) {
                countA--;
                p = p.next;
            }
        } else {
            while (countB > 0) {
                countB--;
                q = q.next;
            }
        }

        //同时遍历
        while (q != null && p != null) {
            if (q == p) {
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
    }
}
