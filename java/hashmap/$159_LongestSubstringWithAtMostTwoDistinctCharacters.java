package array;

import java.util.*;

/**
 * 使用滑动窗口，两个指针指代窗口起始和结束位置，使用Map储存子串内字符和对应的最右边索引值。
 * 当窗口内元素种类少于等于2时右边位置右移，如果元素种类等于3时，窗口左边位置右移，删除元素以保证窗口中只有两种元素.
 */
public class $159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int slow = 0, fast = 0, res = 0;
        Map<Character,Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        while (fast < chars.length) {
            if(map.size() < 3){
                //窗口右边移动
                map.put(chars[fast],fast++);
            }
            if(map.size() == 3){
                //窗口左边移动
                int del = Collections.min(map.values());
                map.remove(chars[del]);
                slow = del+1;
            }
            res = Math.max(res,fast-slow);
        }
        return res;
    }

    public static void main(String[] args) {
        new $159_LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
