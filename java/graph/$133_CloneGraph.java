import java.util.*;

/**
 * 图的DFS和BFS，套模板就可以了，这道题使用Map来保存原节点和其复制节点，方便记录节点是否被访问，并对复制节点进行构造
 */
class Solution {
    //BFS
    public Node cloneGraphBFS(Node node) {
        Node root = new Node(node.val, new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        //使用Map来保存node和它的复制节点
        Map<Node, Node> map = new HashMap<>();
        map.put(node, root);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            //判断其相邻节点是否被复制
            for (Node child : curNode.neighbors) {
                if (!map.containsKey(child)) {
                    map.put(child, new Node(child.val, new ArrayList<>()));
                    queue.add(child);
                }
                //将当前邻接点的复制节点放到父节点的复制节点的子集中去
                map.get(curNode).neighbors.add(map.get(child));
            }
        }
        return root;
    }

    //DFS
    public Node cloneGraphDFS(Node node) {
        Node root = new Node(node.val, new ArrayList<>());
        Stack<Node> stack = new Stack<>();
        //使用Map来保存node和它的复制节点
        Map<Node, Node> map = new HashMap<>();
        map.put(node, root);
        stack.add(node);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            //判断其相邻节点是否被复制
            for (Node child : curNode.neighbors) {
                if (!map.containsKey(child)) {
                    map.put(child, new Node(child.val, new ArrayList<>()));
                    stack.add(child);
                }
                //将当前邻接点的复制节点放到父节点的复制节点的子集中去
                map.get(curNode).neighbors.add(map.get(child));
            }
        }
        return root;
    }
}

public class $133_CloneGraph {
}
