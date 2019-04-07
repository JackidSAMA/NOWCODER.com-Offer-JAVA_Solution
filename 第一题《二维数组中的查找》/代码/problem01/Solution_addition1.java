package problem01;
import java.util.Arrays;
public class Solution_addition1 {
	/**
	 * @author Jackid
	 * JDK-version:1.8
	 * Problem:牛客网-剑指offer《二维数组中的查找》
	 * Result:已通过了所有的测试用例
	 */
	/*
	 * 题目描述： 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 */
	
	/*看起来简洁一点的写法*/
	public boolean Find(int target, int[][] array) {
		for (int[] i : array) {
			if (Arrays.binarySearch(i, target) >= 0) {
				return true;
			}
		}
		return false;
	}
}
