/**
 *  //对BST进行中序遍历，这样元素是按递增顺序排列，创建两个指针分别指向头元素和当前元素的前一个元素，在递归过程中完成链表转换
 */
class Solution {
    Node fakeHead, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        //找到数最左边元素，用假头连接，以便后续返回
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        fakeHead = new Node(0, null, cur);
        helper(root);
        //遍历完毕后建立最后一个节点和头结点的关系
        pre.right = fakeHead.right;
        fakeHead.right.left = pre;
        return fakeHead.right;
    }

    private void helper(Node curNode) {
        if (curNode == null) return;
        helper(curNode.left);
        if (pre != null) {
            pre.right = curNode;
            curNode.left = pre;
        }
        pre = curNode;
        helper(curNode.right);
    }
}


public class $426_ConvertBinarySearchTreetoSortedDoublyLinkedList {
}
