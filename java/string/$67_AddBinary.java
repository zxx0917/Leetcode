/**
 * 这种两数相加的题，如果数是x进制，设进位变量为sum，则每位的值为(a+b+sum)%x，需要进位的值为(a+b+sum)/x
 * 此题首先将短的字符串用0补齐(补在高位)，使得两个数同样长度，然后从字符串末尾开始相加，如1100+111->补齐为1100+0111
 * 然后再使用上述的规律进行逐位计算。
 */
class Solution {
    public String addBinary(String a, String b) {
        //保证a长b短
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        //补齐
        //需要补齐的0数
        int count = a.length() - b.length();
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) {
            sb.append('0');
        }
        b = sb.toString() + b;
        int sum = 0;
        sb.delete(0, sb.length());
        //从末尾计算
        for (int i = a.length() - 1; i >= 0; i--) {
            //当前位数
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(i) - '0';
            sb.append((num1 + num2 + sum) % 2);
            //当前进位数
            sum = (num1 + num2 + sum) / 2;
        }
        //判断最高位是否还需要进位
        if (sum != 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}

public class $67_AddBinary {
}
