/**
 * 首先我考虑的是创建两个新链表，一个是奇数节点，一个是偶数节点，最后拼接起来就好。
 * 后来看题解可以使用原位数组保存奇数节点，省点空间，实质是一样的
 */
public class $328_OddEvenLinkedList {
    //原解答
    public ListNode oddEvenList1(ListNode head) {
        //创建两个新链表，分别连接奇数节点和偶数节点，最后将两条节点拼接起来即可
        ListNode oddHead = new ListNode(0), evenHead = new ListNode(0), oddTail = oddHead, evenTail = evenHead;
        int count = 1;
        while(head != null){
            if(count % 2 != 0){
                //奇节点
                oddTail.next = head;
                oddTail = oddTail.next;
            }else{
                //偶节点
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            count++;
        }
        evenTail.next = null;
        //拼接
        oddTail.next = evenHead.next;
        return oddHead.next;
    }

    //原位链表
    public ListNode oddEvenList2(ListNode head) {
        if(head == null) return null;
        //创建两个新链表，分别连接奇数节点和偶数节点，最后将两条节点拼接起来即可
        ListNode  evenHead = head.next,even = head.next,odd = head;
        //原链表保存奇数节点，新链表保存偶数节点
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
