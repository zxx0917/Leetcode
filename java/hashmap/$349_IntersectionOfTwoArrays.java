package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 因为两个数组都可能存在重复值而结果不要求重复值，所以先使用两个Set分别储存两个数组的元素，
 * 然后使用Set的retainAll()方法求出交集，最后将元素放入数组即可
 */
public class $349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        //retainAll()表示保留set1中set1和set2的重合元素，非重合元素删除
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            res[index++] = num;
        }
        return res;
    }
}
