package array;

import java.util.Comparator;
import java.util.List;

public class $648_WordReplace {
}

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        //1.把字典词根按照长度进行排序
        dict.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        //判断句子中的每次，是否以对应词根为开头
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < words.length;i++){
            for(String root : dict){
                if(root.length() > words[i].length())
                    break;
                if(words[i].startsWith(root))
                    words[i] = root;
            }
            sb.append(words[i]).append(" ");
        }

        return sb.substring(0,sb.length()-1);
    }
}