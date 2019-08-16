import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1.创建一个容量为K+1的最大堆优先队列，遍历数组，将数据加入优先队列，最后返回栈顶元素
 * <p>
 * 2.使用二分法，因为矩阵有序，所有第一个元素一定是最小元素，最后一个元素一定是最大元素，求两个元素的中间值mid
 * 遍历矩阵求小于等于mid的元素和count，如果count < k，则表示第key小的元素一定在[mid+1,right]中，
 * 如果count > k，则表示第key小的元素一定在[left,mid]中，最后二分结束时left的值就是第K小的元素
 * 对于查找比mid小的元素个数，因为整个矩阵是有序的，所以从矩阵的左下角开始，如果当前数<=mid，则当前数同列的上面的元素都<=mid
 * 所以res += i + 1，然后再将数字右移一位，继续判断。如果当前数>mid，则i--，从上一行的左下角开始判断
 */
class Solution {
    //1.优先队列
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue queue = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queue.add(matrix[i][j]);
                if (queue.size() > k) {
                    queue.remove();
                }
            }
        }
        return (Integer) queue.remove();
    }

    //2.二分法
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            //获取小于等于mid的元素数量
            int count = getCountSmallerThanMid(matrix, mid);
            //二分
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int getCountSmallerThanMid(int[][] matrix, int mid) {
        int i = matrix.length - 1, j = 0, res = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return res;
    }
}


public class $378_KthSmallestElementInASortedMatrix {
}
