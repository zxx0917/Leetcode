import java.util.Random;

/**
 * 对于w[i] [1,3,5,6] 我们需要根据权重获取随机数，所以需要从头开始将权重值进行逐步累积，
 * 累积后数组为：[1,4,9,15]，然后使用Random产生一个[1,15]之间的随机数，如果随机数落在[1]，对应元素为0，
 * 如果随机数落在[2,4]区间，对应元素为1，如果随机数落在[5,9]区间，对应元素为2，如果随机数落在[10,15]，对应元素为4
 * 在得出随机数后如果顺序遍历效率比较低，这里的权重累积数组是递增的，所以可以考虑使用二分法，找到随机数对应的区间
 */
class Solution {
    //权重累加数组
    int[] arr;

    public Solution(int[] w) {
        arr = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            arr[i] = sum;
        }
    }

    public int pickIndex() {
        //产生随机数
        Random random = new Random();
        int randomNum = random.nextInt(arr[arr.length - 1]) + 1;
        //二分查找随机数所在的区间
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == randomNum) {
                return mid;
            } else if (arr[mid] > randomNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


public class $528_RandomPickWithWeight {
}
