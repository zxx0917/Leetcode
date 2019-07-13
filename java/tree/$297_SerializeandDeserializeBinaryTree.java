import java.util.LinkedList;
import java.util.Queue;


/**
 * 序列化：首先求出树的深度，然后使用层序遍历，节点为null也加入queue中，树深度作为限制条件之一，这样可以防止最后一层叶子节点的null进入结果集。
 * 反序列化：就是层序遍历的逆过程，每层的节点数为2^depth个（depth从0开始）
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //1.得到树的最大深度
        int depth = getDepth(root);
        //2.层序遍历，逐层加入结果集
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (depth-- > 0 && !queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    sb.append(cur.val).append(",");
                } else {
                    sb.append("null").append(",");
                }

                if (cur != null) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        //删除最后一个","
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //得到每个节点的值
        String[] nodeVals = data.substring(1, data.length() - 1).split(",");
        if (nodeVals.length == 0) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodeVals[0]));
        //层序遍历逆过程
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0, index = 1;
        while (index < nodeVals.length && !queue.isEmpty()) {
            depth++;
            //每层的元素个数为2^depth个
            int nodeCount = (int) Math.pow(2, depth);
            int count = queue.size();
            while(count-- > 0){
                TreeNode cur = queue.poll();
                TreeNode left = !nodeVals[index].equals("null")? new TreeNode(Integer.valueOf(nodeVals[index])):null;
                TreeNode right = !nodeVals[index+1].equals("null")? new TreeNode(Integer.valueOf(nodeVals[index+1])):null;
                index += 2;
                cur.left = left;
                cur.right = right;

                //把左右节点压栈
                if(left != null) queue.add(left);
                if(right != null) queue.add(right);
            }
        }

        return root;
    }
}

public class $297_SerializeandDeserializeBinaryTree {
}
