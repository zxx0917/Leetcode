/**
 * 插入排序是两次循环，外层循环是找到待插入元素，内层循环是找到待插入元素在排序好后元素中的插入位置
 * 这里使用cur代表待插入元素，insert表示待插入位置。
 * 对于每个待插入元素，如果需要插入排好序的元素，则从头开始遍历，找到插入位置，直接插入即可
 *
 */
public class $147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        //两层循环
        ListNode fakeNode = new ListNode(0), cur = head, insert = fakeNode;
        fakeNode.next = head;
        while (cur != null && cur.next != null) {
            //如果待插入元素大于前一个元素，则不需要改变位置
            if (cur.val < cur.next.val) {
                cur = cur.next;
                continue;
            }
            insert = fakeNode;
            //从头遍历，找到当前待插入元素需要插入的位置
            while (insert.next.val < cur.next.val) {
                insert = insert.next;
            }

            //插入元素
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = insert.next;
            insert.next = tmp;

        }

        return fakeNode.next;
    }
}
