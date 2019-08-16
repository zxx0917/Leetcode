import java.util.ArrayList;
import java.util.List;

/**
 * 1.双指针，使用左右指针分别指代数组的第一个元素和最后一个元素，如果arr[left]和x的差 > arr[right]和x的差，则删除left所在的元素，left++
 * 否则删除right所在的元素，right--，直到left和right中有k个元素，即right-left+1==k
 * <p>
 * 2.二分法，因为k值已知，只需要找到区间左边界即可。左边指针为首元素，右边指针为arr.length-k。对于中间元素mid，可以组成区间[mid,mid+k-1]，如果arr[mid]和x的差>arr[mid+k]和x的差，则表明合适的区间应该在mid右边，left = mid+1
 * 如果arr[mid]和x的差<arr[mid+k]和x的差，则表示合适的区间在mid的左侧，right = mid
 */
class Solution1 {
    //1.双指针
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        //将区间内元素加入结果集
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    //2.二分
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //将区间内元素加入结果集
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left+k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

public class $658_FindKClosestElements {
}
