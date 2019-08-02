
/**
 * String->char数组，如果字符大于等于'A'、小于等于'Z'，求出当前字符和'A'的差值，直接加上'a'就是对应的小写字符
 */
class Solution {
    public String toLowerCase(String str) {
        if (str.isEmpty()) return str;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] - 'A' + 'a');
            }
        }
        return new String(chars);
    }
}
public class $709_ToLowerCase {
}
