package problem15;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《求1+2+3+...+n》
 * Result:已通过了所有的测试用例
 */
/*题目描述:
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class Solution {
	// 该题的关键在于递归调用的终止点，即如何使递归不再进行。
	public int Sum_Solution(int n) {
		int ans = n;
		// 短路与：在&&(短路与)左边的事件结果一旦被判定为false，右边的事件一律不执行
		// 利用短路与的特点，可以实现终止递归的效果
		// java必须要有接收返回数据的载体,可以是变量、打印语句、if等等
		boolean flag = ans != 0 && (ans += Sum_Solution(n - 1)) > 0;
		return ans;
	}
}