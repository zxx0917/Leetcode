//枚举两条不同的边r1、r2作为长方形的上下边，然后在这两条边里遍历每列，记录存在多少列，使得该列中第r1行和第r2行中对应的元素都是1
//对于满足上述条件的列数count，可以组成的长方形个数为count*(count-1)/2，累积。
class Solution {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;
        if (row == 1) return res;
        //固定两条边
        for (int r1 = 0; r1 < row; r1++) {
            for (int r2 = r1 + 1; r2 < row; r2++) {
                int count = 0;//记录满足的列数
                for (int j = 0; j < col; j++) {
                    if (grid[r1][j] == 1 && grid[r2][j] == 1)
                        count++;
                }
                //记录此次遍历的长方形个数
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}

public class $750_NumberOfCornerRectangles {
}
