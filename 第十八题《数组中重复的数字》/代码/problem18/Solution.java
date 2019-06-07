package problem18;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《数组中重复的数字》
 * Result:已通过了所有的测试用例
 */
/*题目描述:
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

public class Solution {
	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication in
	// C/C++
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value: true if the input is valid, and there are some duplications in
	// the array number
	// otherwise false
	public boolean duplicate(int numbers[], int length, int[] duplication) {

		for (int i = 0; i < length; i++) {// 遍历数组中的每一个数
			while (numbers[i] != i)// 直到这个数的值和它自己的位置相对应，否则一直做替换
			{
				if (numbers[numbers[i]] != numbers[i]) {// 在替换过程中，如果两个数不相同，则正常替换
					int temporary = numbers[numbers[i]];
					numbers[numbers[i]] = numbers[i];
					numbers[i] = temporary;
				} else {
					// 如果出现两个数相同的情况，则表示在数组中出现了重复的数字，将该数赋值给duplication[0],同时返回true
					duplication[0] = numbers[i];
					return true;
				}
			}
		}
		return false;// 找不到就返回false
	}
}