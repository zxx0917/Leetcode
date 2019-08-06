import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 使用栈来解决这题。
 * 如果遇到了左括号，则压入栈，如果遇到了右括号，则弹栈
 * 有以下几种情况：
 * 1.如果弹出的左括号和当前右括号不匹配，则返回false
 * 2.左括号的数量多于右括号，则遍历完后stack中不为空，返回false
 * 3.右括号数量多于左括号，则在遍历期间stack为空，返回false
 */
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        //创建Map，储存左括号和对应的柚括号
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //压栈
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.isEmpty()) {
                return false;
            } else {
                //弹栈
                Character leftC = stack.pop();
                if (map.get(leftC) != c) return false;
            }
        }
        //如果栈不为空，表示还有左括号没有对应的右括号
        return stack.isEmpty();
    }
}

public class $20_ValidParentheses {
}
