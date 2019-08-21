/**
 * 因为边界的O或与边界相邻的O都不算是被X围绕的区域，所以优先处理board的四个边界，如果边界有O，则从当前O开始DFS，将O改为*，这样就可以将所以和边界连同的O处理掉
 * 最后遍历整个数组，将O改为X，*改为O
 */
class Solution {
    int row, col;

    public void solve(char[][] board) {
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            //上下边界
            if (i == 0 || i == row - 1) {
                int j = 0;
                while (j < col) {
                    if (board[i][j] == 'O') {
                        //进行DFS
                        helper(board, i, j);
                    }
                    j++;
                }
            } else {
                //判断左右边界
                if (board[i][0] == 'O') {
                    //DFS
                    helper(board, i, 0);
                }
                if (board[i][col - 1] == 'O') {
                    //DFS
                    helper(board, i, col - 1);
                }
            }
        }
        //遍历数组，修改元素
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private void helper(char[][] board, int r, int c) {
        if (r >= row || r < 0 || c >= col || c < 0) return;
        if (board[r][c] != 'O') return;
        //修改当前元素
        board[r][c] = '*';
        //递归
        helper(board, r - 1, c);
        helper(board, r + 1, c);
        helper(board, r, c - 1);
        helper(board, r, c + 1);
    }


}

public class $130_SurroundedRegions {
}
