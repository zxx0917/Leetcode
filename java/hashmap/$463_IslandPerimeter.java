package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历所有格子，遇到1时判断它四面有几个1，旁边1的个数对应了该土地的周长：
 * 旁边有0个1->周长为4，1个1->周长为3，2个1->周长为2，3个1->周长为1，4个1->周长为0。
 * 所以在遍历过程中可以遇到1时总周长+4，再判断其上下左右1的个数，有几个总边长减几。
 */
public class $463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //遇到1总周长+4
                    sum += 4;
                    //再判断其上下左右1的个数，有几个总边长减几
                    int count = getCount(grid, i, j);
                    sum -= count;
                }
            }
        }
        return sum;
    }

    //计算1上下左右1的个数
    private int getCount(int[][] grid, int i, int j) {
        int count = 0;
        //上
        if (i > 0 && grid[i - 1][j] == 1) count++;
        //下
        if (i < grid.length - 1 && grid[i + 1][j] == 1) count++;
        //左
        if (j > 0 && grid[i][j - 1] == 1) count++;
        //右
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) count++;
        return count;
    }

    /*
     * 使用Map统计这些土地，key为周边1的个数，value为满足条件的1的总个数，最后遍历map就能求得结果
     */
    public int islandPerimeter1(int[][] grid) {
        if (grid.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //判断上下左右1的个数
                    int count = getCount(grid, i, j);
                    //存入map
                    map.put(count, map.getOrDefault(count, 0) + 1);
                }
            }
        }

        //遍历map进行结果计算
        int res = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            res += (4 - key) * count;
        }

        return res;
    }


}
