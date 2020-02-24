package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 本题采用滑动窗口法和HashSet，HashSet用于判定当前字符是否重复，如果重复的话改变窗口的位置
 */
public class $3_LongesSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int slow = 0, fast = 0, res = 0;
        Set<Character> set = new HashSet<>();
        //为什么要使用fast指针作为终止循环的条件而不是使用slow指针呢？
        //因为整个窗口的slow指针是从左往右移动的，当fast指针到达最后一个元素时，表示当前这个窗口内的不同元素最多，slow指针只能向右移动,
        //进一步缩小窗口，所以没有必要对slow之后的元素再进行判断。 例如ppkwe，当slow指针达到第二个p、fast指针到达e时，窗口中的元素是pkwe，
        //已经得到了结果，如果slow指针接着右移，窗口中的元素是kwe，所以使用fast指针作为终止条件最优。
        while (fast < chars.length) { 
            if (set.contains(chars[fast])) {
                slow++;
                fast = slow;
                set.clear();
            } else {
                set.add(chars[fast]);
                res = Math.max(res, fast - slow + 1);
                fast++;
            }
        }
        return res;
    }
}
