/**
 * 由题意知，整个字符串可以分为s.length/(2*k)组，最后剩下s.length%(2*k)个，如"abcgfer"，k=3，可以分为2组，剩余1个
 * 每组范围内的字符翻转前面k个，而最后剩余的字符需要分两种情况，如果剩余的个数小于k，则全部翻转，否则翻转k个。
 */
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        if (len == 0 || k == 0) return "";
        //分组
        int group = len / (2 * k);
        int rest = len % (2 * k);
        int count = 0;//记录当前处理的元素位置
        char[] chars = s.toCharArray();

        //先处理组内字符
        for (int i = 1; i <= group; i++) {
            reverse(chars, count, count + k - 1);
            //更新位置
            count += 2 * k;
        }
        //处理最后剩余元素
        if (rest < k && rest > 0) {
            //全部翻转
            reverse(chars, count, s.length() - 1);
        }
        if(rest > 0 && rest >= k){
            //部分翻转
            reverse(chars, count, count + k - 1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            char temp = chars[start + i];
            chars[start + i] = chars[end - i];
            chars[end - i] = temp;
        }
    }
}

public class $541_ReverseStringII {
}
