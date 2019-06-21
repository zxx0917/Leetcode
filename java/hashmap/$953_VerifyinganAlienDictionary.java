package array;

/**
*因为给出的order只有小写，所以可以定义一个数组，将order对应的索引值放入数组，索引值越小优先级越高。然后两两比较words中的单词，比较过程中有三种情况：
1.前一个单词的字符优先级大于后一个单词的字符，直接跳出，比较后面的单词
2.前一个单词的字符优先级小于后一个单词字符，不符合要求，return false
3.两个字符相等，统计相等字符数，判断是否前一个单词长度>后一个单词（如apple和app）
*/
public class $953_VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        //1.将顺序按照对应的索引放入Map，字符对应的索引值越小表示顺序越靠前
        int[] flags = new int[26];
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            flags[chars[i] - 'a'] = i;
        }
        //2.对单词进行逐个比较
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i], str2 = words[i + 1];
            int len = Math.min(str1.length(), str2.length());
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (flags[str1.charAt(j) - 'a'] > flags[str2.charAt(j) - 'a']) {
                    //前一个单词的字符字典序大于后一个单词的字符，直接返回
                    return false;
                } else if (flags[str1.charAt(j) - 'a'] < flags[str2.charAt(j) - 'a']) {
                    //比较下一个
                    break;
                } else if (flags[str1.charAt(j) - 'a'] == flags[str2.charAt(j) - 'a']) {
                    //如果相等，累加相等字符个数
                    count++;
                }
            }
            //所有字符相同，但是长度不同
            if (count == len && str1.length() > str2.length()) return false;
        }
        return true;
    }
    
}
