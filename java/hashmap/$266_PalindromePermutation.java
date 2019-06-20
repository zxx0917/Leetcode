package array;

import java.util.HashMap;
import java.util.Map;
/**
 * 回文排列有两种类型：
 * 1.奇数个字符，只有一个字符总数为奇数，其余总数都为偶数
 * 2.偶数个字符，所有字符数总数为偶数
 * 所以最多只有一个字符的出现次数为奇数
 * 这里使用Map记录每个字符出现的次数，最后遍历Map即可
 */
public class $266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s.length() == 0) return true;
        Map<Character,Integer> map = new HashMap<>();
        int total = s.length();
        //统计出现次数
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = 0;
        for(int val : map.values()){
            if(val % 2 != 0){
                count++;
            }
            if(count > 1) return false;
        }
        return true;
    }
}
