/**
 * 因为涉及查找，且给出的数组是有序的，所以优先考虑二分查找。
 * 这里的二分查找使用左闭右开模式，即[left,right)，对于属于数组范围内的target，直接返回left，
 * 对于特殊情况，如果target大于数组中的最大值，则left会等于letters.length，直接返回数组的最后一个元素
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                left = mid + 1;
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid;
            }
        }
        //如果target大于最后一个元素，则返回第一个元素
        if (left == letters.length) return letters[0];
        return letters[left];
    }
}

public class $744_FindSmallestLetterGreaterThanTarget {
}
