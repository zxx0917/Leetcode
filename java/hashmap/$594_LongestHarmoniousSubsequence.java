import java.util.HashMap;
import java.util.Map;

/**
 * 题目的不要求是子数组，所以直接使用Map来记录元素出现的次数，然后遍历Map求出差值为1的元素最大值即可
 */
public class $594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0, sum = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                sum = map.get(key) + map.get(key + 1);
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}
