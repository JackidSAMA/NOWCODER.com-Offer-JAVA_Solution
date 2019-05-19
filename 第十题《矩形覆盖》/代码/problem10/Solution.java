package problem10;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《矩形覆盖》
 * Result:已通过了所有的测试用例
 */
/*
题目描述:
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？*/

public class Solution {
	public int RectCover(int target) {
		if (target <= 2) {// n为1时，有1种方法；n为2时，有2种方法，分别为2*1+2*1和1*2+1*2(横着两个和竖着两个)
			return target;// 直接返回传进来的target
		}
		int solution[] = new int[target + 1];
		solution[1] = 1;
		solution[2] = 2;// 创建target+1个元素的数组，使数组下标刚好对应着target
		for (int i = 3; i < solution.length; i++) {// 从数组头计算到到数组尾。
			// 想象一下，2*i的大矩形是由
			// 2*(i-1)的大矩形加上一个2*1的小矩形(一块竖着的小的)、
			// 2*(i-2)的大矩形加上两个1*2的小矩形(两块横着的小的)
			// 这两者组成的
			solution[i] = solution[i - 1] + solution[i - 2];
		}
		return solution[target];
	}
}
