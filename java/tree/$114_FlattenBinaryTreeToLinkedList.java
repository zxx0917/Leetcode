/**
 * 使用一个指针指代链表的最新元素，通过前序遍历，将当前节点加入链表末尾。这里注意每次遍历需要保存当前右节点
 */
public class $114_FlattenBinaryTreeToLinkedList {
    TreeNode last = null; //当前指针指向链表的最新元素

    public void flatten(TreeNode root) {
        if (root == null) return;
        //将当前节点加入链表最后
        if (last != null) {
            last.left = null;
            last.right = root;
        }
        //更新链表最后元素指针
        last = root;
        //保存当前右节点
        TreeNode copyRight = root.right;
        flatten(root.left);
        flatten(copyRight);
    }
}
