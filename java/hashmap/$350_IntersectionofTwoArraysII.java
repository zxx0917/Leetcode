import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $350_IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        //使用Map记录num1中的数字以及出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //遍历num2，逐个对照map中出现的次数，得出结果
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
