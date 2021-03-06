package problem01;
public class Solution {
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
	public boolean Find(int target, int[][] array) {
		try {
			int col_length = array[0].length;// 记录数组的列数，用col_length表示
			for (int[] i : array) {// 遍历数组中的每一行,用整型数组i表示
				if (i[0] <= target && i[col_length - 1] >= target) {// 判断target是否在此数组范围中，不存在则开始二维数组下一行的遍历
					// 以下是使用二分查找法寻找target是否在此数组中

					int start = 0;// 定义起点指针，指向数组第一个元素
					int end = col_length - 1;// 定义终点指针，指向数组最后一个元素
					while (start <= end) {
						int mid = (start + end) / 2;// 中间指针，指向数组的中间元素
						if (target < i[mid]) {
							end = mid - 1;
						} else if (target > i[mid]) {
							start = mid + 1;
						} else {
							return true;// 当target等于数组中的元素即i[mid]时，为已经找到的情况，直接返回true，函数调用结束。
						}
					}
				}
			}
			return false;// 遍历完数组依然无法找到target，则返回false
		} catch (ArrayIndexOutOfBoundsException e) {// 防止出现数组为空的情况，直接返回false
			return false;
		}
	}
}
