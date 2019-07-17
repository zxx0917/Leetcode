import java.util.HashMap;
import java.util.Map;

/**
 * 由题意可知，可以从十进制中获取三个信息：深度d、每层位置p、节点值v。对于一个满二叉树，如果对每层每个节点从左到右开始编号（从1开始），
 * 如果一个节点的编号为k，则父节点为k/2，两个子节点为2k，2k+1。我们可以根据十进制中给出的信息将当前节点转换为编号，使用Map保存节点编号和节点值。
 * 从根节点开始遍历（即位置为1的元素），每次递归累加当前节点值，当k节点的子节点不存在于map中（即位置为2k和2k+1的元素），表示到达叶子节点，则将累加值加入全局变量结果中。
 * 如果未到达叶子节点（即map中还有2k或2k+1元素），继续遍历。这里注意每次遍历完需要将当前节点值回退。
 */
class Solution {
    int res = 0, curVal = 0;

    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int depth = num / 100;
            int pos = num / 10 % 10;
            int val = num % 10;
            int code = (int) Math.pow(2, depth - 1) + pos - 1;
            map.put(code, val);
        }
        //递归
        helper(map, 1);
        return res;
    }

    private void helper(Map<Integer, Integer> map, int index) {
        if (!map.containsKey(index)) return;
        curVal += map.get(index);
        //判断是否到达叶子节点
        //到达
        if (!map.containsKey(index * 2) && !map.containsKey(index * 2 + 1)) {
            res += curVal;
        }
        //未到达
        if (map.containsKey(index * 2)) {
            helper(map, index * 2);
        }
        if (map.containsKey(index * 2 + 1)) {
            helper(map, index * 2 + 1);
        }
        //回退
        curVal -= map.get(index);
    }
}

public class $666_PathSumIV {
}
