import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法，将数组按照去A地费用和去B地费用的绝对值从小到大排列，线性遍历排序好的数组，对于去A、B的位置还有剩余时，每组取费用小的那个，
 * 如果A没有剩余，只能去B，如果B没有剩余，只能去A
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0] - o1[1]) - Math.abs(o2[0] - o2[1]);
            }
        });
        int a = 0, b = 0, n = costs.length / 2, res = 0;
        for (int[] cost : costs) {
            if (a < n && b < n) {
                //去A地的花费小于去B的花费
                if (cost[0] < cost[1]) {
                    a++;
                    res += cost[0];
                } else {
                    //去B的花费小
                    b++;
                    res += cost[1];
                }
            } else if (a < n) {
                //B去满了
                a++;
                res += cost[0];
            } else if (b < n) {
                //A去满了
                b++;
                res += cost[1];
            }
        }
        return res;
    }
}


public class $1029_TwoCityScheduling {
}
