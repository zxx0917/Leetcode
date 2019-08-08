import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        //构建一个Map，加入数字和对应的字符
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        helper("", 0, digits, map);
        return res;
    }

    //count表示当前计算的是digits哪个字符
    private void helper(String str, int count, String digits, Map<Integer, String> map) {
        //终止条件:如果遍历到了最后一个字符，加入结果集
        if (count == digits.length()) {
            res.add(str);
            return;
        }

        //当前遍历到的数字
        char num = digits.charAt(count);
        //获取对应的字符字符串
        String charStr = map.get(num - '0');
        for (int i = 0; i < charStr.length(); i++) {
            helper(str + charStr.charAt(i), count + 1, digits, map);
        }
    }
}


public class $17_LetterCombinationsOfAPhoneNumber {
}
