/**
 * 由题意可知，如果轮到起始玩家时整个字符串只有一个连续的"++"，则起始玩家必赢，所以可以使用递归，
 * 从第一个连续"++"开始，进行翻转，不断递归，如果接下来字符串中没有"++"，则返回true，否则返回false
 */
class Solution {
    public boolean canWin(String s) {
        char[] chars = s.toCharArray();
        return helper(chars);
    }

    private boolean helper(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '+' && chars[i - 1] == '+') {
                //进行翻转
                chars[i] = '-';
                chars[i - 1] = '-';
                //如果没有"++"
                if (!helper(chars)) {
                    //回退
                    chars[i] = '+';
                    chars[i - 1] = '+';
                    return true;
                }
                //回退
                chars[i] = '+';
                chars[i - 1] = '+';
            }
        }
        return false;
    }
}

public class $294_FlipGameII {
}
