package array;

import java.util.Arrays;
import java.util.Comparator;

public class $748_ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        //1.先对单词进行排序，使其按长度排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //2.获得牌照中的字母，并用字典表保存字母以及出现次数
        int[] dic = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                dic[c - 'a']++;
            }
        }

        //3.逐个比较word，遇到满足条件的就直接返回
        for (String word : words) {
            int[] wordDic = new int[26];
            boolean flag = true;
            //记录word各个单词出现的次数
            for (char c : word.toCharArray()) {
                wordDic[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (dic[i] != 0 && dic[i] > wordDic[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return word;
        }
        return "";
    }
}
