package problem11;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《二进制中1的个数》
 * Result:已通过了所有的测试用例
 */
/*
 * 题目描述: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class Solution {
	public int NumberOf1(int n) {
		int sum = 0;//统计n的二进制中“1”的个数的变量
		while (n != 0) {
			sum++;
			n = n & (n - 1);//n & (n - 1)这个与运算将目标数的二进制形式中的最右边的“1”消除掉
		}
		return sum;
	}
}
