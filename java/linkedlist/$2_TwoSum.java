public class $2_TwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0), cur = fakeHead;
        int carry = 0;
        //1.逐步计算每位的和，以carry来记录进位数
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            //进位
            carry = sum / 10;
            //创建当前节点
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            //进入下一节点
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        //判定是否还有进位
        if(carry > 0){
            cur.next = new ListNode(carry);
        }

        return fakeHead.next;
    }
}
