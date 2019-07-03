/**
 * 一般来说删除一个节点是使用上一个节点指向待删除节点的下一个节点，但是这道题只给出了待删除的节点node，
 * 所以可以将删除节点的值和next指向下下个节点，因为给定的节点为非末尾节点并且一定是链表中的一个有效节点，所以不必考虑特殊情况
 */
public class $237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
