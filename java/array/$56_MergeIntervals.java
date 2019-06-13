package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 首先对每个元素的起点元素进行升序排序，因为两个元素的起始元素已经排好序，
 * 所以当后一个元素的起点元素小于等于前一个元素的末尾元素时，两个区间可以合并，如[1,3],[2,5]。
 * 合并后新区间为：[前一个元素的起始元素，Math.max(前一个元素的结尾元素,后一个元素的结尾元素)，如[1,3],[2,5]->[1,Math.max(3,5)]->[1,5]
 * 注意可以多个区间连续合并。
 */
public class $56_MergeIntervals {
    public int[][] merge(int[][] nums) {
        List<int[]> list = new ArrayList<>();
        //1.对所有的元素的起始点进行从小到大
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //2.遍历排序后的数组，如果后一个数组的起始点落在前一个数组之中，则合并
        int i = 0;
        while(i < nums.length){
            int start = nums[i][0];
            int end = nums[i][1];
            //多个区间连续合并
            while (i < nums.length - 1 && nums[i + 1][0] <= end) {
                end = Math.max(nums[i+1][1],end);
                i++;
            }
            list.add(new int[]{start,end});
            i++;
        }

        return list.toArray(new int[0][]);
    }

}
