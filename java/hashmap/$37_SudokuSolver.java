public class $37_SudokuSolver {
    //使用回溯法求数独解，首先创建3个boolean数组分别表示行、列、3*3方块的数字使用情况
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][][] boxes = new boolean[3][3][10];
        //初始化已经使用的数字情况
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[i / 3][j / 3][num] = true;
                }
            }
        }
        //进行回溯
        helper(board, rows, cols, boxes, 0, 0);
    }

    private boolean helper(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][][] boxes, int row, int col) {
        //边界校验，如果已经到最后，则跳出递归
        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }

        //如果当前格子是空，尝试1~9每个数逐个添加到数独
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                //判断这个数是否在三个数组中没有使用过
                boolean flag = !(rows[row][i] || cols[col][i] || boxes[row / 3][col / 3][i]);
                if (flag) {
                    //未使用，尝试加入数独
                    rows[row][i] = true;
                    cols[col][i] = true;
                    boxes[row / 3][col / 3][i] = true;
                    //填入其中
                    board[row][col] = (char) (i + '0');
                    //递归
                    if (helper(board, rows, cols, boxes, row, col + 1)) {
                        return true;
                    }
                    //不满足条件，还原
                    board[row][col] = '.';
                    rows[row][i] = false;
                    cols[col][i] = false;
                    boxes[row / 3][col / 3][i] = false;

                }
            }
        } else {
            //如果这个数使用过，跳到下一个
            return helper(board, rows, cols, boxes, row, col + 1);
        }
        return false;
    }
}
