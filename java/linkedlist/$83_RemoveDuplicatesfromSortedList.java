/**
 * 使用双指针slow/fast分别表示重复元素的起始和结束位置，如果相邻元素不同，直接跳过，如果相邻元素相同，找到最后一个相同元素的位置，进行删除操作即可
 */
public class $83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        //使用两个指针指代重复元素的开始和结束
        ListNode slow = head, fast = head;
        while (slow != null && slow.next != null) {
            //如果相邻两个元素不同，直接跳过
            if (slow.next.val != slow.val) {
                slow = slow.next;
                continue;
            }

            fast = slow;

            //如果有相同元素，找到最后一位相同元素，用fast指代
            while (fast.next != null && fast.next.val == slow.val) {
                fast = fast.next;
            }

            //删除重复元素
            slow.next = fast.next;
            slow = slow.next;
        }
        return fakeHead.next;
    }
}
