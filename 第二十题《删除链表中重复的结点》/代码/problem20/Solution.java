package problem20;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer��ɾ���������ظ��Ľ�㡷
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 
���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 */

/*
public class ListNode {
   int val;
   ListNode next = null;

   ListNode(int val) {
       this.val = val;
   }
}
*/
public class Solution {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead==null||pHead.next==null) {
			return pHead;
		}
		
		if (pHead.val==pHead.next.val) {
			ListNode current=pHead.next;
			while(current!=null&&current.val==pHead.val)
			{
				current=current.next;
			}
			return deleteDuplication(current);
		}else {
			pHead.next=deleteDuplication(pHead.next);
			return pHead;
		}
	}
}
