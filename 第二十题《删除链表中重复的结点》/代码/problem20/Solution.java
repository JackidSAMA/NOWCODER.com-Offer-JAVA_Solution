package problem20;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《删除链表中重复的结点》
 * Result:已通过了所有的测试用例
 */
/*题目描述:
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
