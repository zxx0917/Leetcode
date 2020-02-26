package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和15题三数之和类似，这道题先对数组从小到大排序，使用两层循环固定第一个数和第二个数固定前两个元素，另外两个元素用双指针取值，左指针表示除了前两个数
 * 之外最小的数，右指针表示出了前两个数之外最大的数。
 * 如果四数之和大于target，则需要将右指针左移一位，减小总和，如果和小于target，则需要将左指针右移一位，增大总和，如果和等于target，则得到目标结果。
 * 注意，这里四个数都要去重，特别是第二个数的去重，如果第一个数在i位，则第二个数的起始位置时在i+1位，只有当第二个数处于i+N位（N>=2）时，才需要去重
 * 所以当第二个数与第一个数的索引差大于1时，才进行去重。
 */
public class $18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        //排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            //第一个数去重
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                //第二个数去重
                if (j - i > 1 && nums[j - 1] == nums[j]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    //比较当前和和target的关系
                    if (sum > target) {
                        //缩小大数
                        right--;
                    } else if (sum < target) {
                        //扩大小数
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //第三个数和第四个数去重
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
