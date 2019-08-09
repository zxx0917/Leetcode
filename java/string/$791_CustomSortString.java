/**
 * 使用数组记录T中的字符个数，然后遍历S，将数组中的字符按照S中字符的遍历顺序取出，最后将剩下的字符放到排序字符串的最后面即可
 */
class Solution {
    public String customSortString(String S, String T) {
        if (T.isEmpty() || S.isEmpty()) return T;
        int[] dict = new int[26];
        //计数
        for (char c : T.toCharArray()) {
            dict[c - 'a']++;
        }
        //遍历S
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            //如果T中有该字符，则加入结果字符串中
            if (dict[c - 'a'] > 0) {
                while (dict[c - 'a']-- > 0) {
                    sb.append(c);
                }
            }
        }
        //将剩余的字符加入结果字符串
        for (int i = 0; i < 26; i++) {
            if (dict[i] > 0) {
                while (dict[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }
}

public class $791_CustomSortString {
}
