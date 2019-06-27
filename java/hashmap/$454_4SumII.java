package array;

import java.util.HashMap;
import java.util.Map;

public class $454_4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //创建两个Map，分别计算AB两个数组之间两两元素之和以及出现的次数
        Map<Integer, Integer> map1 = new HashMap<>();

        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int key1 = A[i] + B[j];
                map1.put(key1, map1.getOrDefault(key1, 0) + 1);
            }
        }

        int res = 0;
        //遍历CD，计算其中两两元素之和，判断map中是否有其负值存在，有则累加
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = C[i] + D[j];
                res += map1.getOrDefault(-sum,0);
            }
        }
        return res;
    }
}
