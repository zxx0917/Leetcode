/**
 * 按照题意，首先求出链表中节点个数count，如果count <= k，表示每个子节点存在于结果数组中；
 * 如果k > count，把链表分为k份，每份至少有count/k个元素，未分配元素为count%k，因为未分配元素在范围为[0,k)，所以给每份元素数从前到后+1，以满足题目条件
 * 如果8个元素分成3分，每份至少有8/3=2个元素，即[2,2,2]，剩余8%3=2个元素，分给第一份和第二份，为[3,3,2]
 */
public class $725_SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) return null;
        ListNode[] res = new ListNode[k];
        //求出整个链表的长度
        ListNode p = root;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        p = root;

        //1.k >= 总长度，取每个链表节点
        if (k >= count) {
            for (int i = 0; i < count; i++) {
                res[i] = new ListNode(p.val);
                p = p.next;
            }
        } else {
            //2. k < 总长度，
            int remain = count % k;
            int preCount = count / k;
            //记录每部分需要储存多少个链表元素
            int[] counts = new int[k];
            for (int i = 0; i < k; i++) {
                counts[i] = remain-- > 0 ? preCount + 1 : preCount;
            }
            //遍历链表，储存元素
            for (int i = 0; i < k; i++) {
                //获取当前部分需要的元素个数
                int num = counts[i];
                res[i] = p;
                //调整p的位置
                while (--num > 0) {
                    p = p.next;
                }
                //截断链表
                ListNode tmp = p.next;
                p.next = null;
                p = tmp;
            }
        }
        return res;
    }
}
