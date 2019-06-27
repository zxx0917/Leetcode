package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 满足移位条件的字符串：两个字符串中两两字符差相等，如果为负数则将值+26，如"az"差为[25],"ba"差为[-1+26]。
 * 所以计算每个字符串中字符的差值，作为key储存在map中，储存形式为[1,1]，value为List，储存对应的字符串。
 * 如果只有一个字符的字符串储存为"*"
 */
public class $249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            //计算差值
            char[] chars = str.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                int diff = chars[i] - chars[i - 1] < 0 ? chars[i] - chars[i - 1] + 26 : chars[i] - chars[i - 1];
                sb.append(diff).append(",");
            }
            //如果只有一个元素，则将差值记为"*"
            String key = sb.toString().equals("") ? "*" : sb.substring(0, sb.length() - 1);
            //存入map
            List<String> list = map.get(key);
            if (list == null) list = new ArrayList<>();
            list.add(str);
            map.put(key, list);
            sb.delete(0,sb.length());
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
