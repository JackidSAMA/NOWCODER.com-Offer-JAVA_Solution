package problem16;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《不用加减乘除做加法》
 * Result:已通过了所有的测试用例
 */
/*题目描述:
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Solution {
	public int Add(int num1, int num2) {
		// num1是最后的结果
		// 利用num2作为进位数，当num2为0时，表明所有的进位均已处理完毕
		while (num2 != 0) {
			int carry = (num1 & num2) << 1;// 先统计接下来要发生的异或运算中产生的进位位置
			num1 = num1 ^ num2;// 执行异或运算，并赋值给num1
			num2 = carry;// num2为这次异或运算中产生的进位位置
		}
		return num1;// 最后返回num1
	}
}