package problem09;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《变态跳台阶》
 * Result:已通过了所有的测试用例
 */

/*
题目描述：
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。*/

public class Solution {
	public int JumpFloorII(int target) {
		int record[] = new int[target + 1];//创建具有target+1个元素的数组，方便数组下标与台阶级数相对应
		record[0] = 1;//初始化数组的第一个元素，即级数为0时，有1种跳法
		for (int i = 0; i < record.length; i++) {//从0级开始，一直计算到第target级的台阶
			for (int j = 0; j < i; j++) {//跳上一个target级的台阶的跳法是0级~(target-1)级台阶跳法的总和
				record[i] += record[j];
			}
		}
		return record[target];//返回下标为target的数组元素
	}
}
