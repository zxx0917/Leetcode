import java.util.ArrayList;
import java.util.List;

/**
 * 如果一个字符串由重复子字符串获得，则可以将字符串分为n组，所以只需要找出能和s.length整除的数，就是可能的子字符串的长度，然后根据可能的字符串长度判断字符串是否能够分成相同的子字符串即可
 * 如果s长度为12，则可能的子字符串长度为2或3或4或6，判断字符串是否能分成相同的6/4/3/2组
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i <= len/2;i++){
            if(len % i == 0)
                list.add(i);
        }
        //逐个判定
        for(int subLen : list){
            String subStr = s.substring(0,subLen);
            int cur = subLen;
            //记录判定结果
            boolean flag = true;
            while(cur < s.length()){
                //下一组子字符串和第一组子字符串相等，继续比较
                if(s.substring(cur,cur+subLen).equals(subStr)){
                    cur += subLen;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}

public class $459_RepeatedSubstringPattern {
}
