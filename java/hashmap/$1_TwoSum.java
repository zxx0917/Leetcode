package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历整个数组，将元素值和下标索引存入哈希表，并在遍历途中判定表中是否存在target-当前元素
 */
public class $1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //先判定，再加入
            //为什么不能先加入再判定呢，比如target为8，如果数组中只有一个4，则会出现误判
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
