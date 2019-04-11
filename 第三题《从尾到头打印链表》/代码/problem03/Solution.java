package problem03;

/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《从尾到头打印链表》
 * Result:已通过了所有的测试用例
 */

/*题目描述：
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。*/

//递归解法
import java.util.ArrayList;

public class Solution {
	ArrayList<Integer> record = new ArrayList<Integer>();//创建ArrayList对象record，用来记录链表中每个节点的数值

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {//判断当前结点是否为空
			printListFromTailToHead(listNode.next);//如果当前结点不为空，则递归调用printListFromTailToHead方法，其中方法参数为当前结点所指向的下一个结点
			record.add(listNode.val);//把当前结点的值添加进数组中，因为递归的关系，数组会从尾到头添加链表结点的值
		}
		return record;//给调用它的方法返回record数组
	}
}
