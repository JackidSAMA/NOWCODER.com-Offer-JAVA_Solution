package problem03;

/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����β��ͷ��ӡ����
 * Result:��ͨ�������еĲ�������
 */

/*��Ŀ������
����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList��*/

//�ݹ�ⷨ
import java.util.ArrayList;

public class Solution {
	ArrayList<Integer> record = new ArrayList<Integer>();//����ArrayList����record��������¼������ÿ���ڵ����ֵ

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {//�жϵ�ǰ����Ƿ�Ϊ��
			printListFromTailToHead(listNode.next);//�����ǰ��㲻Ϊ�գ���ݹ����printListFromTailToHead���������з�������Ϊ��ǰ�����ָ�����һ�����
			record.add(listNode.val);//�ѵ�ǰ����ֵ��ӽ������У���Ϊ�ݹ�Ĺ�ϵ��������β��ͷ����������ֵ
		}
		return record;//���������ķ�������record����
	}
}
