import java.util.*;

/**
 * 使用DFS找寻岛屿，使用Set来储存岛屿筛选重合岛
 * DFS找寻岛屿：从grid左上角开始逐个遍历，如果当前元素为1，则进入递归，进行岛屿找寻，对于已经递归过的元素，直接将元素变为0
 * Set筛选岛：对于每DFS，使用一个List记录岛屿的坐标，如一个岛屿是(1,1)/(1,2)/(2,1)，则将坐标转换为101,102,201，
 * 然后减去岛屿的左上角元素求出每个岛屿的相对坐标值，如上述岛屿的相对坐标值为0,1,100，与岛屿(0,0)/(0,1)/(1,0)是相同岛屿，
 * 再将相对坐标值加入Set，最后返回Set的长度即可
 */
class Solution {
    int row, col;
    List<Integer> island = new ArrayList<>();

    public int numDistinctIslands(int[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        col = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j);
                    island.set(0, 0);
                    Collections.sort(island);
                    //得到的坐标形式为0,1,100,101
                    set.add(island.toString());
                    island.clear();
                }
            }
        }

        return set.size();
    }

    private void helper(int[][] grid, int r, int c) {
        if (r >= row || r < 0 || c >= col || c < 0) return;
        //如果不是1返回
        if (grid[r][c] != 1) return;
        //储存当前陆地的坐标
        if (island.size() == 0) {
            //第一个元素直接加入
            island.add(r * 100 + c);
        } else {
            //求相对坐标
            island.add(r * 100 + c - island.get(0));
        }

        //修改当前陆地为0，表示已经遍历过
        grid[r][c] = 0;
        //上下左右递归找寻
        helper(grid, r - 1, c);
        helper(grid, r + 1, c);
        helper(grid, r, c - 1);
        helper(grid, r, c + 1);
    }
}

public class $694_NumberOfDistinctIslands {
}
