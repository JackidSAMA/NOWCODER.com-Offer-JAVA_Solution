package problem03;

/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《从尾到头打印链表》
 * Result:已通过了所有的测试用例
 */

/*题目描述：
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。*/

//栈解法
import java.util.ArrayList;
import java.util.Stack;

public class Solution_addition1 {
	ArrayList<Integer> record = new ArrayList<Integer>();// 创建ArrayList对象record，用来记录链表中每个节点的数值

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer>stack=new Stack<>();//定义一个栈用来储存链表节点的值
		
		while (listNode != null) {//遍历链表，当链表不为空时，把节点进栈
			stack.push(listNode.val);
			listNode=listNode.next;
		}
		
		while(!stack.empty())//把栈中的元素全部出栈，并依次添加到ArrayList中
		{
			record.add(stack.pop());
		}
		
		return record;//返回ArrayList
	}
}
