package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 因为两个数组都可能存在重复值而结果不要求重复值，所以先使用两个Set分别储存两个数组的元素，
 * 然后再遍历一个Set中的元素是否存在于另一个Set，如果存在则是交集元素
 */
public class $349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        //将第一个数组中的元素加入Set
        for(int num : nums1){
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        //将第二个元素放入Set
        for(int num : nums2){
            set2.add(num);
        }

        //Set2元素是否在Set1中
        List<Integer> res = new ArrayList<>();
        for(int num : set2){
            if(set1.contains(num))
                res.add(num);
        }

        int[] arr = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
