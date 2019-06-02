package problem14;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《正则表达式匹配》
 * Result:已通过了所有的测试用例
 */
/*题目描述:
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

public class Solution {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {// 判空处理1
			return false;
		}
		if (str.length == 0 && pattern.length == 0) {// 判空处理2
			return true;
		}
		if (pattern.length == 0) {// 判空处理3
			return false;
		}
		return check(str, pattern, 0, 0);// 开始主要的判断函数
	}

	public static boolean check(char[] str, char[] pattern, int str_point, int pattern_point) {

		if (str_point == str.length && pattern_point == pattern.length) {// 两者的指针均走到尽头，证明两者匹配
			return true;
		}
		if (str.length != str_point && pattern.length == pattern_point) {// 如果pattern的指针先走完，则匹配失败
			return false;
		}

		if (pattern_point + 1 < pattern.length && pattern[pattern_point + 1] == '*') {
			// 如果pattern_point指针指向的下一个元素是*，而且两个指针指向的元素相同的话，有三条路可走：
			// 一、直接放弃pattern_point指针指向的元素，保留str_point指针指向的元素，即pattern_point + 2。
			// 二、保留pattern_point指针指向的元素，放弃str_point指针指向的元素，即str_point + 1。
			// 三、放弃pattern_point指针指向的元素，放弃str_point指针指向的元素，即str_point + 1，pattern_point + 2
			if ((str.length != str_point && pattern[pattern_point] == str[str_point])
					|| (str.length != str_point && pattern[pattern_point] == '.')) {
				return check(str, pattern, str_point, pattern_point + 2)
						|| check(str, pattern, str_point + 1, pattern_point)
						|| check(str, pattern, str_point + 1, pattern_point + 2);
			} else {
				// 如果pattern_point指针指向的下一个元素是*，而且两个指针指向的元素【不】相同的话，
				// 只有一条路可走：直接放弃pattern_point指针指向的元素，保留str_point指针指向的元素，即pattern_point + 2
				return check(str, pattern, str_point, pattern_point + 2);
			}
		}
		// 如若进行到这里，则表示pattern_point指针指向的下一个元素【不】是* 那么就只能比较两个指针指向字符是否相等
		if ((str.length != str_point && pattern[pattern_point] == str[str_point])
				|| (str.length != str_point && pattern[pattern_point] == '.')) {
			return check(str, pattern, str_point + 1, pattern_point + 1);
		}
		// 以上都没被拦截到，最后只能返回false
		return false;
	}
}