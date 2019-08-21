/**
 * 使用深度优先遍历，循环每层NestedInteger之中的内容，如果是数字，直接计算，如果是集合，则继续递归
 */
class Solution {
    int res = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        helper(nestedList, 1);
        return res;
    }

    //DSF
    private void helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList.isEmpty()) return;
        //循环每层NestedInteger之中的内容，如果是数字，直接计算，如果是集合，则继续递归
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger()) {
                res += depth * integer.getInteger();
            } else {
                helper(integer.getList(), depth + 1);
            }
        }
    }
}

public class $339_NestedListWeightSum {
}
