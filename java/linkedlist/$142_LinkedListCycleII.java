import java.util.HashSet;
import java.util.Set;

/**
 * 使用Set来储存遍历的节点，遇到的第一个重复节点就是环的起始点
 */
public class $142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
