import java.util.HashSet;
import java.util.Set;

/**
 * 题目的意思是使用G中的元素可以组成最长子链表的个数，其中G中的元素是可以重复使用的，如链表为0->1->1->3，G = {0,1,3}，组件的个数是1。
 * 这里使用Set来保存G中的元素，然后遍历链表，使用set判断当前节点是否存在于G中，如果存在则表示该节点可以作为子链表，
 * 继续判断当前子链表是否结束，判断依据为：无子节点或下个子节点不在G中
 */
public class $817_LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        if (G.length == 0) return 0;
        //1.使用Set储存数组G
        Set set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }

        //2.遍历链表，使用set判断连续子链表的个数
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                head = head.next;
                //如果到达到达子链表的末尾，则res+1
                if (head == null || !set.contains(head.val)) {
                    res++;
                }
            } else {
                head = head.next;
            }

        }
        return res;

    }
}
