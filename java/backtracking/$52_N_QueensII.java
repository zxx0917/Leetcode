import java.util.HashSet;
import java.util.Set;

/**
 * 使用三个Set保存列、正、负对角线的使用情况，当当前行找到满足条件的位置时，进入下一行，再从第一列开始找到合适位置，
 * 如果到达最后一行，则表示找到一个解，更新计数器
 */
class Solution {
    int res = 0;

    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();
        helper(0, col, z_diagonal, f_diagonal, n);
        return res;
    }

    private void helper(int row, Set<Integer> colSet, Set<Integer> z_diagonalSet, Set<Integer> f_diagonalSet, int n) {
        //最后一行解决
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            //剪枝
            if (colSet.contains(col) || z_diagonalSet.contains(row + col) || f_diagonalSet.contains(row - col))
                continue;
            //更新Set
            colSet.add(col);
            z_diagonalSet.add(row + col);
            f_diagonalSet.add(row - col);
            //递归
            helper(row + 1, colSet, z_diagonalSet, f_diagonalSet, n);
            //回退
            colSet.remove(col);
            z_diagonalSet.remove(row + col);
            f_diagonalSet.remove(row - col);
        }
    }
}

public class $52_N_QueensII {
}
