package problem08;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《跳台阶》
 * Result:已通过了所有的测试用例
 */

/*
题目描述:
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/

//迭代解法
//变形的斐波那契数列
public class Solution {
    public int JumpFloor(int target) {
    	int array[]= {1,1};//台阶数为0时，有1种跳法；台阶数为1时，有1种跳法。
    	if (target<2) {//当台阶数小于二时，以台阶数为下标，返回数组中相应的元素
			return array[target];
		}
    	
    	int temporary=0;//以变量的方式进行每一级台阶的方法数的计算主要是为了节约空间的开销
    	for (int i = 2; i <=target; i++) {
			temporary=array[0]+array[1];//当前台阶是由上一次的台阶跳1步或者跳2步组成的,f(n)=f(n-1)+f(n-2)
			array[0]=array[1];
			array[1]=temporary;
		}
    	return temporary;
    }
}