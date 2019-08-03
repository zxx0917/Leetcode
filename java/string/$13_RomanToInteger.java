import java.util.HashMap;
import java.util.Map;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 首先将字符和对应的数值加入Map，然后从输入的最右边数开始，如果前一个字符比当前字符代表的数字小，则代表要用后面的数减去前面的数，如XL，代表的数为50-10=40
 * 如果当前字符小于等于前一个字符，则直接累加当前字符代表的数
 */
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s.length() == 0) return 0;
        int sum = 0, cur = s.length() - 1;
        //从后往前
        while (cur >= 0) {
            //找到前一个字符
            if (cur > 0) {
                //如果前一个字符代表的数小于当前字符
                if (map.get(s.charAt(cur - 1)) < map.get(s.charAt(cur))) {
                    sum += map.get(s.charAt(cur)) - map.get(s.charAt(cur - 1));
                    cur -= 2;
                } else {
                    //   如果前一个字符代表的数大于等于当前字符
                    sum += map.get(s.charAt(cur));
                    cur--;
                }
            } else {
                //到达第一个字符
                sum += map.get(s.charAt(cur));
                cur--;
            }
        }
        return sum;
    }
}

public class $13_RomanToInteger {
}
