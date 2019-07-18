import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 序列化：将二叉树前序遍历，每个子树由[]表示，如题目中给出的示例序列化后变为：1[3[5][6]][2][4]
 * 
 * 反序列化： 创建一个Stack用来保存节点。遍历字符串，如果出现数字，则创建新节点，如果Stack不为空，则取如果stack不为空，则获取顶层元素，
 *           加入顶层元素的child中，然后压栈。如果遇到']'则弹栈，直至遍历完字符串。树的元素没有负数，则不需要考虑别的情况。
 */
class Codec {
    //序列化：将二叉树前序遍历，每个子树由[]表示
    // 如题目中给出的示例序列化后变为：1[3[5][6]][2][4]
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        //前序遍历
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(1, sb.length() - 1);
    }

    //前序遍历
    private void helper(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append("[").append(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                helper(child, sb);
            }
        }
        sb.append("]");
    }

    // 创建一个Stack用来保存节点。遍历字符串，如果出现数字，则创建新节点，如果Stack不为空，则取如果stack不为空，则获取顶层元素，
    //加入顶层元素的child中，然后压栈。如果遇到']'则弹栈，直至遍历完字符串。树的元素没有负数，则不需要考虑别的情况。
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == ']') stack.pop();
            else {
                if (c >= '0' && c <= '9') {
                    //取当前数组
                    int start = i;
                    while (i < data.length() - 1 && data.charAt(i + 1) >= '0' && data.charAt(i + 1) <= '9') {
                        i++;
                    }
                    Node node = new Node(Integer.valueOf(data.substring(start, i + 1)), new ArrayList<>());
                    if (!stack.isEmpty()) {
                        Node parent = stack.peek();
                        List<Node> list = parent.children;
                        list.add(node);
                    }
                    //压栈
                    stack.push(node);
                }
            }
        }
        if (stack.isEmpty()) return null;
        return stack.peek();
    }
}


public class $428_SerializeandDeserializeN_aryTree {
}
