import java.util.Arrays;
import java.util.Comparator;

/**
 * 优化：其实可以直接将数组按照costA-costB排序，前N个元素一定是去A地更划算，再将后面N个放去B即可
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2, res = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });
        int i = 0;
        while (i < 2 * n) {
            if (i < n) {
                res += costs[i][0];
            } else {
                res += costs[i][1];
            }
            i++;
        }
        return res;
    }
}

public class $1029_TwoCityScheduling {
}
