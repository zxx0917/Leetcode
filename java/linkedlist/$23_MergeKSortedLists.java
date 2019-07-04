import java.util.*;

public class $23_MergeKSortedLists {
    //方法1：暴力法 时间复杂度：O(NlogN)，空间复杂度O(N)
    public ListNode mergeKLists1(ListNode[] lists) {
        //遍历所有链表，将值储存
        if(lists.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        for(ListNode head : lists){
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
        }

        //排序
        Collections.sort(list);

        //重构链表
        ListNode fakeHead = new ListNode(-1),pre = fakeHead;
        for(int val : list){
            pre.next = new ListNode(val);
            pre = pre.next;
        }
        return fakeHead.next;
    }

    //方法2：优先队列，时间复杂度O(NlogK)，空间复杂度O(N)
    class Solution {
        //查找每个链表的头元素，将最小值放入结果链表中，这里使用优先队列实现
        public ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });

            ListNode fakeHead = new ListNode(0), pre = fakeHead;
            for (ListNode head : lists) {
                if(head != null)
                    queue.add(head);
            }

            //取出最小元素，加入结果链表，如果其后还有元素，则将其后元素加入优先队列，直至queue为空
            while (!queue.isEmpty()) {
                pre.next = queue.poll();
                pre = pre.next;
                if(pre.next != null)
                    queue.add(pre.next);
            }
            return fakeHead.next;
        }
    }
}
