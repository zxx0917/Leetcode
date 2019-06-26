package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 创建两个Set，一个用于储存已经遍历过的子字符串，一个用于储存符合条件的子字符串
 */
public class $187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 10) return res;
        //储存已经遍历过的子字符串
        Set<String> set1 = new HashSet<>();
        //储存符合条件的子字符串
        Set<String> set2 = new HashSet<>();
        for(int i = 0;i + 10 <= s.length();i++){
            String seq = s.substring(i,i+10);
            if(set1.contains(seq)){
                set2.add(seq);
            }
            set1.add(seq);
        }
        res.addAll(set2);
        return res;
    }
}
