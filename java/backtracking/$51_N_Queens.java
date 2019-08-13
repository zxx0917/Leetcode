import java.util.*;

/**
 * 经典回溯问题。
 * 如果将皇后放在(i,j)处，它所在的列、行、双对角线都不能摆放其他皇后。
 * 所以我们创建三个Set，用来保存哪些列、对角线有皇后。
 * 对每一行进行递归，如果找到符合条件的位置，直接进入下一行，如果到最后List.size==n，则表示是一个合适解，加入结果集
 * 剪枝条件：如果对应的列、对角线有皇后，剪枝
 * 关于对角线的取值，如果在一个4x4的棋盘，皇后位于(1,2)，则主对角线为(3,0)/(2,1)/(1,2)/(0,3)，副对角线为(0,1)/(1,2)/(2,3)
 * 所以推及到(i,j)，主对角线为i+j，副对角线为i-j
 */
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();
        helper(0, col, z_diagonal, f_diagonal, new ArrayList<>(), n);
        return res;
    }

    //row代表行号
    private void helper(int row, Set<Integer> colSet, Set<Integer> z_diagonalSet, Set<Integer> f_diagonalSet, List<String> list, int n) {
        //如果到达最后一行
        if (list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        //遍历当前行的每一列
        for (int col = 0; col < n; col++) {
            //剪枝
            if (colSet.contains(col) || z_diagonalSet.contains(col + row) || f_diagonalSet.contains(row - col))
                continue;
            //更新集合
            colSet.add(col);
            z_diagonalSet.add(col + row);
            f_diagonalSet.add(row - col);
            //更新结果
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';
            list.add(new String(chars));
            //递归，进入下一行
            helper(row + 1, colSet, z_diagonalSet, f_diagonalSet, list, n);
            //还原
            colSet.remove(col);
            z_diagonalSet.remove(col + row);
            f_diagonalSet.remove(row - col);
            list.remove(list.size() - 1);
        }
    }
}

public class $51_N_Queens {
}
