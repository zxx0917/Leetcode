import java.util.HashSet;
import java.util.Set;

/**
 * 方法1：遍历链表，使用Set来储存节点，如果当前节点出现在Set中表示有环
 * 方法2：使用快慢指针，如果没环，则快指针一定会先达到终点，如果有环，快指针一定会追上慢指针
 */
public class $141_LinkedListCycle {
    //方法1
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //方法2
    public boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        ListNode slow = head,fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
