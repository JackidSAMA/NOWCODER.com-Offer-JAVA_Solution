package problem03;

/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����β��ͷ��ӡ����
 * Result:��ͨ�������еĲ�������
 */

/*��Ŀ������
����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��*/

//ջ�ⷨ
import java.util.ArrayList;
import java.util.Stack;

public class Solution_addition1 {
	ArrayList<Integer> record = new ArrayList<Integer>();// ����ArrayList����record��������¼������ÿ���ڵ����ֵ

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer>stack=new Stack<>();//����һ��ջ������������ڵ��ֵ
		
		while (listNode != null) {//��������������Ϊ��ʱ���ѽڵ��ջ
			stack.push(listNode.val);
			listNode=listNode.next;
		}
		
		while(!stack.empty())//��ջ�е�Ԫ��ȫ����ջ����������ӵ�ArrayList��
		{
			record.add(stack.pop());
		}
		
		return record;//����ArrayList
	}
}
