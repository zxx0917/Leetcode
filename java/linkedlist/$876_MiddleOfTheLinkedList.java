import java.util.ArrayList;
import java.util.List;

/**
 * 两种方法：1.快慢指针；2.转换为数组，求中点
 */
public class $876_MiddleOfTheLinkedList {
    //方法1：
    public ListNode middleNode1(ListNode head) {
        //双指针法
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //方法2：
    public ListNode middleNode2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        return list.get(list.size()/2);
    }
}
