package com.summerzhou;

/**
 * 本题并不复杂，可以创建一个int变量从String的低位来逐个转变为数字，即res = res * 10 + (str.charAt(i)-'0')。
 * 难点在于res范围的判定，可能会超出Integer.MAX_VALUE，有两种情况，当res和MAX_VALUE差一位时，res大于Integer.MAX_VALUE/10，
 * 或者res等于Integer.MAX_VALUE/10，但即将加上的最后一位大于Integer.MAX_VALUE的最后一位，这时直接按照题意返回Integer的最大值或最小值即可。
 */
class Solution {
	public int myAtoi(String str) {
		// 除去前后空白
		str = str.trim();
		if (str.isEmpty())
			return 0;
		// 如果第一个字符不是'+'、'-'和数字，直接返回0；
		if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '+' && str.charAt(0) != '-')
			return 0;
		// 接下来输出的数是正数还是负数，即第一个字符是否为'-'
		boolean negative = str.charAt(0) == '-';
		// 判断第一个字符是否是数字，如果是数字，从第一个字符开始遍历，否则从第二个字符开始遍历。
		int i = Character.isDigit(str.charAt(0)) ? 0 : 1;
		// 创建一个变量，用来计算累积数字
		int res = 0;
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			// 判断累计数加上当前数字时是否会超出整数限制
			if (res > Integer.MAX_VALUE / 10
					|| (res == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
				return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			res = res * 10 + (str.charAt(i) - '0');
			i++;
		}
		return negative ? -res : res;
	}
}

public class $8_StringToInteger {

}
