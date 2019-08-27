import java.util.*;

/**
 * 优先队列，将优先队列使用最大堆，每次挑选出最大的两个数，进行计算，直至队列只有一个元素或空位置
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        //将剩余的石头种类放到集合中
        Queue<Integer> weights = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            weights.add(stone);
        }

        while (weights.size() > 1) {
            //从剩余石头中挑出最重的两颗
            int y = weights.poll();
            int x = weights.poll();
            if (x != y) {
                weights.add(y - x);
            }

        }
        return weights.size() == 1 ? weights.poll() : 0;
    }
}

public class $1046_LastStoneWeight {
}
