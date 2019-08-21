/**
 * 使用DFS
 * 首先使用一个全局变量储存岛屿数量，然后遍历grid，如果遇到元素为1，则从这个元素开始DFS
 * DFS的具体逻辑如下：对于已经遍历过的元素，直接变为0，然后递归处理其上下左右元素，直至一个岛屿全变为0
 */
class Solution {
    int res = 0, row, col;

    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //是岛屿的一部分，递归
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, int i, int j) {
        if (i >= row || i < 0 || j >= col || j < 0) return;
        //如果不是岛屿，则返回
        if (grid[i][j] != '1') return;
        //将当前元素转换为0，防止重复遍历
        grid[i][j] = 0;
        //上下左右分别处理
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
    }
}

public class $200_NumberOfIslands {
}
