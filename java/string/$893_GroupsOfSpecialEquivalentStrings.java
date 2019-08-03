import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 因为所有 A[i] 都具有相同的长度，所以没有必要考虑长度问题了
 * 奇数位和偶数位上的所有字符分别一致，就是一组，如abcde、cdabe，两者奇数位上均是a/c/e，偶数位上都是b/d，最后都能通过有限次的交换得到对方
 * 搜集每个字符串中奇数位和偶数位的字符，按字典序排好序后使用Set来筛选，
 * 如abcde的奇数位为ace，偶数位为bd，拼接出来加入Set，即acebd；acbde的奇数位为abe，偶数位为cd，最后拼接为abccd，不为同一组
 */
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
            char[] chars = str.toCharArray();
            String odd = "", even = "";
            for (int i = 0; i < chars.length; i++) {
                //如果是奇数位
                if ((i & 1) == 1) {
                    odd += str.charAt(i);
                } else {
                    //如果为偶数位
                    even += str.charAt(i);
                }
            }
            //排序后拼接
            char[] oddArr = odd.toCharArray();
            Arrays.sort(oddArr);
            char[] evenArr = even.toCharArray();
            Arrays.sort(evenArr);
            set.add(new String(oddArr) + new String(evenArr));
        }

        return set.size();
    }
}

public class $893_GroupsOfSpecialEquivalentStrings {
}
