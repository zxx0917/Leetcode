import java.util.HashSet;
import java.util.Set;

/**
 * 规则：如果本地名称中有.，则保留.前后的内容；如果本地名称中有+，则忽略+后所有内容
 * 所以可以遍历email地址，按照上述规则处理字符串，然后将处理好的字符串加入Set，通过Set，最后返回size即可
 * 这里在处理时直接将字符串放入StringBuilder中进行处理
 */
class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder(email);
            for(int i = 0;i < sb.length();i++){
                //除去本地名称中的'.'
                if(sb.charAt(i) == '.' && i < sb.indexOf("@")){
                    sb.deleteCharAt(i);
                }else if(sb.charAt(i) == '+'){
                    //第一次碰到'+'，删除其后到@之前的字符，直接跳出
                    sb.delete(i,sb.indexOf("@"));
                    break;
                }
            }
            //将新地址加入set
            set.add(sb.toString());
        }
        return set.size();
    }
}

public class $929_UniqueEmailAddresses {
}
