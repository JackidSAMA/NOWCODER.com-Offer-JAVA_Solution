package problem07;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《斐波那契数列》
 * Result:已通过了所有的测试用例
 */

/*题目描述：
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39*/

// 迭代问题
public class Solution {
	public int Fibonacci(int n) {
		int array[] = { 0, 1 };
		if (n < 2) {
			return array[n];
		}
		int temporary = 0;
		for (int i = 2; i <= n; i++) {// 循环用于计次数
			temporary = array[0] + array[1];
			array[0] = array[1];
			array[1] = temporary;
		}
		return temporary;
	}
}
