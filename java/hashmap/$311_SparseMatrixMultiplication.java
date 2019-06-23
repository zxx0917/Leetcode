package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵AB结果集的row和column为A的row和B的column。
 * 因为稀疏矩阵的0较多，创建两个Set来记录A全为0的行和B全为0的列，
 * 如果碰到全0行或者全0列，计算时当前元素为0，所以遍历时遇到直接continue。
 */
public class $311_SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        for(int i = 0;i < A.length;i++){
            boolean flag = true;
            for(int j = 0;j < A[0].length;j++){
                if(A[i][j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) aSet.add(i);
        }

        for(int j = 0;j < B[0].length;j++){
            boolean flag = true;
            for(int i = 0;i < B.length;i++){
                if(B[i][j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag) bSet.add(j);
        }

        for (int row = 0; row < A.length; row++) {
            if(aSet.contains(row)) continue;
            for(int col = 0;col < B[0].length;col++){
                if(bSet.contains(col)) continue;
                int sum = 0;
                for(int Brow = 0;Brow < B.length;Brow++){
                    sum += A[row][Brow] * B[Brow][col];
                }
                res[row][col] = sum;
            }
        }
        return res;
    }
}
