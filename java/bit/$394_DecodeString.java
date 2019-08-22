import java.util.Stack;

/**
 * 遇到括号问题首先考虑使用栈，这里最难的地方在于内括号的处理，如2[a3[c]]，结果为acccaccc
 * 所以我们创建一个栈，除了]之外全都压栈，然后对于每个括号处理好的结果直接压入栈中，如果没有内括号，则每个括号的结果放在栈底，如果有内括号，内括号的结果参加下一个括号的计算
 */
class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //遇到]就弹栈
            char c = s.charAt(i);
            if (c == ']') {
                String str = "";
                //累积需要叠加的字符串，直到第一个[出现
                while (!strStack.peek().equals("[")) {
                    str = strStack.pop() + str;
                }
                //弹出[
                strStack.pop();
                //获取需要叠加的数字
                String numStr = "";
                while ((!strStack.isEmpty()) && (strStack.peek().charAt(0) >= '0' && strStack.peek().charAt(0) <= '9')) {
                    numStr = strStack.pop().charAt(0) + numStr;
                }
                int count = Integer.parseInt(numStr);

                //将字符串重复，并放入栈中，继续下一次的累积
                String subStr = "";
                while (count-- > 0) {
                    subStr += str;
                }
                strStack.push(subStr);
            } else {
                //除了[都压栈
                strStack.push(c + "");
            }
        }
        //最后结果保留在Stack中
        String res = "";
        while (!strStack.isEmpty()) {
            res = strStack.pop() + res;
        }
        return res;
    }
}

public class $394_DecodeString {
}
