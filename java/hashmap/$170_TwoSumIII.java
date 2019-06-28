package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建一个Map来储存add的数字和出现的次数，以及计数器count来储存加了多少个数
 * 进行find操作时，如果储存元素小于2，则直接返回false。遍历map的keySet，判断目标和value和当前数num的差值是否存在于map中，
 * 这里需要考虑两种情况：
 * 1.如果是两个相同数相加得到目标和，则需要判断此数是否出现了两次以上，否则不符合条件，如0,0的情况
 * 2.如果是两个不同数相加得到目标和，则直接判断差值是否存在于map即可
 */
public class $170_TwoSumIII {
}

class TwoSum {
    Map<Integer,Integer> map;
    int count;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
        count = 0;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number,map.getOrDefault(number,0)+1);
        count++;
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(count < 2) return false;
        for(int num : map.keySet()){
            //注意相同数的情况，如0,0
            int diff = value - num;
            if(diff == num && map.get(diff) > 1)
                return true;
            if(diff != num && map.containsKey(diff))
                return true;
        }
        return false;
    }
}