/**
 * 两个链表分为以下几种情况：
 * 1.某个链表为null
 * 2.两个链表不等长
 * 3.两个链表等长
 * 对于上述情况有以下解决方法：
 * 对于情况1，直接返回另一个链表即可。
 * 对于情况2，同时遍历两个链表，找出短链表，新建链表，补0，最后添加短链表，使得两个链表等长
 *
 * 然后对于两个等长链表，直接相加值，生成新链表，暂时不要处理进位。
 * 最后从新链表尾节点开始，往前逐个处理进位，这里注意每个节点需要遍历找到其前端链表节点
 */
public class $445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        //1.对短链表前位用0补齐
        ListNode cur1 = l1, cur2 = l2, newListNode = new ListNode(0), newPre = newListNode;
        //短链表首先到达末尾
        while (cur1 != null && cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //如果cur2是短链表
        if (cur1 != null) {
            //cur1剩余的元素个数就是两个链表的相差长度
            while (cur1 != null) {
                //补0
                newPre.next = new ListNode(0);
                newPre = newPre.next;
                cur1 = cur1.next;
            }
            //将补上的0接上短链表
            newPre.next = l2;
            cur1 = l1;
            cur2 = newListNode.next;
        } else if (cur2 != null) {
            //如果cur1是短链表
            while (cur2 != null) {
                //补0
                newPre.next = new ListNode(0);
                newPre = newPre.next;
                cur2 = cur2.next;
            }
            //将补上的0接上短链表
            newPre.next = l1;
            cur2 = l2;
            cur1 = newListNode.next;
        } else {
            //如果两者等长，则不加0
            cur1 = l1;
            cur2 = l2;
        }


        //对等长的两个链表l1/newListNode进行累加，不考虑进位
        ListNode fakeHead = new ListNode(0), pre = fakeHead;
        while (cur1 != null) {
            pre.next = new ListNode(cur1.val + cur2.val);
            pre = pre.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        //这是pre位于新链表末尾，从尾往头处理进位
        int carry = 0;
        while (pre != fakeHead) {
            int x = pre.val + carry;
            carry = x / 10;
            pre.val = x % 10;
            //找到pre的前位节点
            ListNode front = fakeHead;
            while (front.next != pre) {
                front = front.next;
            }
            pre = front;
        }

        //判断首位是否需要进位
        if (carry > 0) {
            ListNode tmp = new ListNode(carry);
            tmp.next = fakeHead.next;
            fakeHead.next = tmp;
        }
        return fakeHead.next;
    }
}
