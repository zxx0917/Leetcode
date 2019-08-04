import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 排序规则：字符日志在数字日志之前，字符日志先按照内容的字典序排列，如果内容相同再按照标识符排序，数字日志按照输入的顺序排序
 * 所以使用两个集合来保存字符日志和数字日志，然后分别排序字符日志和数字日志，最后将数字日志添加到字符日志之后即可
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) return new String[]{};
        List<String> charList = new ArrayList<>(), numList = new ArrayList<>();
        //1.分离出字符日志和数字日志：判断每个日志最后一个字符是数字还是字符
        for (String log : logs) {
            char c = log.charAt(log.length() - 1);
            if (c >= '0' && c <= '9') numList.add(log);
            else charList.add(log);
        }

        //2.对字符日志排序
        charList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //分离出日志内容和日志头
                int s1Flag = s1.indexOf(" ");
                String s1Content = s1.substring(s1Flag + 1, s1.length());
                String s1Head = s1.substring(0, s1Flag);
                int s2Flag = s2.indexOf(" ");
                String s2Content = s2.substring(s2Flag + 1, s2.length());
                String s2Head = s2.substring(0, s2Flag);
                //首先判断内容是否相同
                if (!s1Content.equals(s2Content)) return s1Content.compareTo(s2Content);
                //如果内容相同比较日志头
                return s1Head.compareTo(s2Head);
            }
        });

        //3.将数字日志添加到排序号的字符日志之后，返回结果
        charList.addAll(numList);
        return charList.toArray(new String[charList.size()]);
    }
}

public class $937_ReorderLogFiles {
}
