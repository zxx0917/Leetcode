/**
 * 从指定的(sr,sc)开始，判断上下左右四个方向的元素是否与指定元素值相同，如果相同，则将对应方位上的元素值改为-1，
 * 继续判断newColor上的上下左右四个方向的元素，直到到达边界，到达边界后回溯，将-1元素改为newColor，这样是为了防止oldColor和newColor相同时进入死循环
 */
class Solution {
    int row, col, oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row = image.length;
        if (row == 0) return new int[][]{};
        col = image[0].length;
        //获取起始元素的颜色
        oldColor = image[sr][sc];
        helper(sr, sc, image, newColor);
        return image;
    }

    private void helper(int sr, int sc, int[][] image, int newColor) {
        //递归返回条件：颜色坐标不能超过二维数组范围
        if (sr >= row || sr < 0 || sc >= col || sc < 0) return;
        //遇到其他颜色，返回
        if (image[sr][sc] != oldColor) return;
        //标记已经遍历过的元素
        image[sr][sc] = -1;
        //上元素
        helper(sr - 1, sc, image, newColor);
        helper(sr, sc - 1, image, newColor);//左
        helper(sr + 1, sc, image, newColor);//下
        helper(sr, sc + 1, image, newColor);//右
        //回溯转换为newColor
        image[sr][sc] = newColor;
    }
}

public class $733_FloodFill {
}
