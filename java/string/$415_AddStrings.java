/**
 * 1.字符串补齐，注意是在短字符串的高位补0，如2343+43，补齐为2343+0043
 * 2.从低位开始计算，sum表示进位的量，当前位的值为(a+b+sum)%10，进位值为sum=(a+b+sum)/10
 * 3.最后判定最高位是否需要进位
 */
class Solution {
    public String addStrings(String num1, String num2) {
        //1.补齐字符串
        //1.1 保证第一个字符串长，第二个短
        if (num1.length() < num2.length()) {
            String tmp = num2;
            num2 = num1;
            num1 = tmp;
        }

        //1.2 补齐
        StringBuilder sb = new StringBuilder();
        int count = num1.length() - num2.length();
        while (count-- > 0) {
            sb.append(0);
        }
        num2 = sb.toString() + num2;
        sb.delete(0, sb.length());
        //2.计算
        int sum = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num = num1.charAt(i) - '0' + num2.charAt(i) - '0' + sum;
            sb.append(num % 10);
            sum = num / 10;
        }
        //3.判断最高位是否需要进位
        if (sum != 0) sb.append(1);
        return sb.reverse().toString();
    }

}

public class $415_AddStrings {
}
