package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 将J中的宝石类型放入Set中，遍历S，判断当前石头类型是否是宝石，即是否在Set中
 */
public class $771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        //1.将J中的宝石类型放入Set中
        Set<Character> set = new HashSet<>();
        for(char c : J.toCharArray()){
            set.add(c);
        }
        //2.遍历S，判断当前石头类型是否是宝石，即是否在Set中
        int res = 0;
        for(char c : S.toCharArray()){
            if(set.contains(c)){
                res++;
            }
        }
        return res;
    }
}
