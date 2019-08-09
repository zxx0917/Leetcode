/**
 * 分割两个输入字符串，得到两个复数的实部和虚部，比如第一个复数为a1+b1i，第二个为a2+b2i，
 * 则结果为(a1*a2-b1*b2)+(a1*b2+b1*a2)*i
 */
class Solution {
    public String complexNumberMultiply(String a, String b) {
        if (a.isEmpty()) return b;
        //将两个输入从+分割
        String[] aField = a.split("\\+");
        String[] bField = b.split("\\+");
        int a1 = Integer.valueOf(aField[0]), b1 = Integer.valueOf(aField[1].substring(0, aField[1].length() - 1));
        int a2 = Integer.valueOf(bField[0]), b2 = Integer.valueOf(bField[1].substring(0, bField[1].length() - 1));
        int newA = a1 * a2 - b1 * b2, newB = a1 * b2 + b1 * a2;
        return newA + "+" + newB + "i";
    }
}

public class $537_ComplexNumberMultiplication {
}
