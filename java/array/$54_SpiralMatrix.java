package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用递归，将当前圈的元素按顺时针顺序加入结果集，然后缩进内圈，直至没有元素待添加
 * 这里需要注意两种特殊情况，如[[5,6]]和[[7],[9],[6]]，需要排除重复添加
 */
public class $54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0 || nums[0].length == 0) return res;
        helper(res, nums, 0, nums[0].length - 1, 0, nums.length - 1);
        return res;
    }

    /**
     * 递归，顺时针获取当前圈的排序
     *
     * @param res
     * @param colStart 列的起始索引
     * @param colEnd   列的结束索引
     * @param rowStart 行的起始索引
     * @param rowEnd   行的结束索引
     */
    private void helper(List<Integer> res, int[][] nums, int colStart, int colEnd, int rowStart, int rowEnd) {
        if (colStart > colEnd || rowStart > rowEnd) return;
        //获取当前圈四条边的元素
        //1.上边，包括开头和结尾两个元素
        for (int i = colStart; i <= colEnd; i++) {
            res.add(nums[rowStart][i]);
        }
        //2.右边，不包括开头元素
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            res.add(nums[i][colEnd]);
        }
        //3.下边，不包括开头元素，rowStart < rowEnd避免重复取值，如[[5,6]]
        for (int i = colEnd-1; i >= colStart && rowStart < rowEnd; i--) {
            res.add(nums[rowEnd][i]);
        }
        //4.左边，不包括开头和结尾元素，colStart < colEnd避免重复取值，如[[7],[9],[6]]
        for (int i = rowEnd - 1; i > rowStart && colStart < colEnd; i--) {
            res.add(nums[i][colStart]);
        }

        //递归，进入里面一圈
        helper(res, nums, colStart + 1, colEnd - 1, rowStart + 1, rowEnd - 1);
    }
}
