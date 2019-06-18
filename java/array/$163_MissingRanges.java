package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组已经排好序，使用当前数组元素和lower比较，分为三种情况：
 * 1.如果lower-当前元素>1，则加入区间；
 * 2.等于1则表示与前一个元素差一个数，加入数字；
 * 3.小于1则连续，不处理直接进入下个数
 * 每次循环完后都需要更新lower的值：lower=当前元素+1
 * 循环完成后还需要判断最后一个数和upper之间是否还有缺失的数
 *
 * 这里需要注意边界问题，例题中会卡integer边界，所以需要把upper和lower转换为Long
 */
public class $163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int l, int u) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        long lower = l, upper = u;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            if (nums[i] - lower > 1) {
                res.add(sb.append(lower).append("->").append(nums[i] - 1).toString());
            } else if (nums[i] - lower == 1) {
                res.add(sb.append(nums[i] - 1).toString());
            }
            sb.delete(0, sb.length());
            //注意转换为long
            lower = (long) nums[i] + 1;
        }

        if (lower < upper) {
            res.add(sb.append(lower).append("->").append(upper).toString());
        } else if (lower == upper) {
            res.add(sb.append(lower).toString());
        }

        return res;
    }
}
