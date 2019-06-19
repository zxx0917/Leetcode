package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 将每一行键盘字符和对应的行数放入Map，注意小写也要存入
 * 对于输入的word，比较每个字符是否位于同一行，不是的话直接返回
 */
public class $500_KeyboardRow {
    public String[] findWords(String[] words) {
        String[] strs = new String[]{"QWERTYUIOPqwertyuiop","ASDFGHJKLasdfghjkl","ZXCVBNMzxcvbnm"};
        //将每一行键盘字符和对应的行数放入Map
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            char[] chars = strs[i].toCharArray();
            for(char c : chars){
                map.put(c,i);
            }
        }


        List<String> res = new ArrayList<>();
        for(String word:words){
            char[] wordChars = word.toCharArray();
            int line = map.get(wordChars[0]);
            boolean flag = true;
            for(char c : wordChars){
                if(map.get(c) != line){
                    //标识符
                    flag = false;
                    break;
                }
            }
            //符合条件的加入集合
            if(flag) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}
