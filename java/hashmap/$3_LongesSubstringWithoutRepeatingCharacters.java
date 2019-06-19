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
