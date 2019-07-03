import java.util.ArrayList;
import java.util.List;

/**
 * 方法1：遍历链表，将值存入数组，数组值为二叉树的中序遍历值，使用递归还原
 * 方法2：使用快慢指针求链表中点，然后使用中序遍历得到二叉树
 */
public class $109_ConvertSortedListtoBinarySearchTree {
    //方法1：
    public TreeNode sortedListToBST1(ListNode head) {
        //1.遍历链表，使用数组保留节点升序值
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        //2.递归构建二叉树，链表值为中序遍历结果
        return helper(list,0,list.size()-1);
    }

    private TreeNode helper(List<Integer> list, int lo, int hi) {
        if(lo > hi) return null;
        int mid = lo + (hi-lo)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list,lo,mid-1);
        root.right = helper(list,mid+1,hi);
        return root;
    }

    //方法2
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null;
        //初始化快慢指针
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //慢指针指向中点节点
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}
