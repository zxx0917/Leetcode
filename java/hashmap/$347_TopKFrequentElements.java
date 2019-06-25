package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首先统计每个元素出现的次数。
 * 需要按次数从大往小取值，可以维护一个List<Integer>[]，数组索引为元素出现的次数，对应的集合为出现次数对应的值，
 * 从数组从后往前取就可以实现从大到小取值。
 */
public class $347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //空间换时间
        Map<Integer,Integer> map = new HashMap<>();
        //统计每个元素出现的次数
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer>[] lists = new List[nums.length+1];//一个数最多出现nums.length次
        //构成数组
        for(int key : map.keySet()){
            int count = map.get(key);
            if(lists[count] == null)
                lists[count] = new ArrayList<>();
            lists[count].add(key);
        }
        
        //从后往前遍历数组，取值
        List<Integer> res = new ArrayList<>();
        for(int i = lists.length - 1;i >= 0;i--){
            //表示没有数字
            if(lists[i] == null) continue;
            while(k > 0){
                //相同频次有多个对应数字
                if(lists[i].size() < k) {
                    res.addAll(lists[i]);
                    k -= lists[i].size();
                    break;
                }
                for(int num : lists[i]){
                    res.add(num);
                    k--;
                    if(k == 0) break;
                }
            }
        }
        return res;
    }
}
