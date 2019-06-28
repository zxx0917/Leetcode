package array;

import java.util.HashMap;
import java.util.Map;


/**
 * 逐个计算两个点之间的距离，使用map来储存距离和出现的次数，如果同一个点有两个以上的相同距离，则出现2n个回旋镖，
 */
public class $447_NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    Double distance = Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
                    if (!map.containsKey(distance)) {
                        map.put(distance, 1);
                    } else {
                        Integer count = map.get(distance);
                        res += 2 * count;
                        map.put(distance, count + 1);
                    }
                }
            }
            map.clear();
        }
        return res;
    }
}
