/**
 * 方法1：因为整个二维数组的元素范围是1-10000，且每行数字是升序排列，表示没有重复数字，所以可以创建一个一维数组来记录每个数字出现的次数，
 * 最先出现次数为mat.length的数字就是结果
 * 方法2：因为需要判断存在于每一行的最小公共元素，所以我们可以遍历第一行的数据，然后选取这行中的每个数字在剩余的几行中使用二分查找判断是否存在
 * 因为每行是递增排列，所以第一个每行都存在的数字就是结果
 */
public class $1198_FindSmallestCommonElementInAllRows {
    //方法1：计数法
    public int smallestCommonElement1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        //从记录1~10000，所以数组长度定义为10001
        int[] count = new int[10001];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (++count[mat[i][j]] == m) {
                    return mat[i][j];
                }
            }
        }
        return -1;
    }

    //方法2：二分法
    public int smallestCommonElement2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        //获取第一行的各个元素
        for (int j = 0; j < n; j++) {
            boolean flag = true;
            //判定当前元素是否存在于2~m行
            for (int i = 1; i < m && flag; i++) {
                //用flag记录是否找到对应的元素
                flag = binarySearch(mat[i], mat[0][j]) >= 0;
            }
            //所有行都查找完毕，如果都存在，返回当前第一行的这个元素
            if (flag) return mat[0][j];
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        return -1;
    }
}
