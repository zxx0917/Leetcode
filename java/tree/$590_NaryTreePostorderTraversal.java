import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class $590_NaryTreePostorderTraversal {
    //遍历：
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if(root == null) return;
        for(Node node : root.children){
            helper(node,res);
        }
        res.add(root.val);
    }

    //迭代
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //前指针
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if ((cur.children.size() == 0) || (pre != null && cur.children.contains(pre))) {
                //加入结果集
                res.add(cur.val);
                stack.pop();
                //更新pre指针
                pre = cur;
            } else {
                //继续压栈，注意压栈是从右往左
                List<Node> nodeList = cur.children;
                for (int i = nodeList.size() - 1; i >= 0; i--) {
                    stack.push(nodeList.get(i));
                }
            }
        }
        return res;
    }
}
