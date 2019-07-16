/**
 * 可知前序遍历的结果为中->左->右，所以只要知道每颗子树的右子树元素的起始范围就可以固定二叉树
 * 如1-2--3--4-5--6--7，可知1为根节点，子节点深度为1，因为2和5的深度都为1，所以左子树的元素为[2--3--4]，右子树的范围是[5--6--7]
 * 对于左子树[2--3--4]，根节点为[2]，子节点深度为2，所以左右子树分别为[3][4]。
 * 所以我们可以根据当前节点所在的深度来找出当前根节点的左右子树范围：
 * 例如根节点为1时，其索引位置为0，左子树的根节点的起始位置为2。
 * 扩展到通用情况，当根节点最后一位数的索引为lo，深度为depth(从1开始)，其左子树的根节点的索引位置为lo+1+depth，从左子树根节点开始，向右搜索右子树的根节点，即前面有depth个'-'的数字，索引位置为start
 * 这里要注意一种特殊情况，即右子树不存在时，左子树元素的末尾索引为当前递归数组的最末索引；如果右子树存在，则左子树元素的末尾索引为start-1-depth
 */
class Solution {
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;
        return helper(S.toCharArray(), 0, S.length() - 1, 1);
    }

    private TreeNode helper(char[] arr, int lo, int hi, int depth) {
        if (lo > hi) return null;
        //生成根节点
        StringBuilder sb = new StringBuilder();
        sb.append(arr[lo]);
        while(lo < hi && arr[lo+1] >= '0' && arr[lo+1] <= '9'){
            lo++;
            sb.append(arr[lo]);
        }
        TreeNode root = new TreeNode(Integer.parseInt(sb.toString()));

        //求出右子树节点的起始位置，即找到前面有depth个'-'的数字
        int start = lo + 1 + depth;
        while (start <= hi) {
            int count = 0;
            while (start < hi && arr[start] == '-') {
                count++;
                start++;
            }
            if(count == depth) break;
            start++;
        }

        int rightStart = start;
        if(start < hi){
            //表示有右子树
            start = start-1-depth;
        }else{
            //表示没有右子树
            start = hi;
        }
        //构建左右子树
        root.left = helper(arr,lo+1+depth,start,depth+1);
        root.right = helper(arr,rightStart,hi,depth+1);
        return root;
    }
}

public class $1028_RecoveraTreeFromPreorderTraversal {
}
