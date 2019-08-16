/**
 * 因为矩阵每行和每列都是升序的，所以从矩阵左下角开始，它是当前行的最小元素、当前列的最大元素。
 * 如果左下角元素==target，return true
 * 如果左下角元素>target，则表示元素肯定不在这一行，在上一行中寻找，i--
 * 如果左下角元素<target，则表示元素肯定在这一行，在当前行中寻找，j++
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (matrix[0].length == 0) return false;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}

public class $240_SearchA2DMatrixII {
}
