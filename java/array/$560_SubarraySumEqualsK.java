package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 本来一开始是想用滑动窗口的，但是卡在了负数，这里使用map来解决。
 * 遍历一次数组，将当前累积和作为key，出现次数作为val，放入map，
 * 如果当前累积和-k存在于Map中，则表示当前索引之前一定有连续子数组和为k
 */
public class $560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0,res = 0;
        for(int i : nums){
            sum += i;
            if(map.containsKey(sum-k)){
                res += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
