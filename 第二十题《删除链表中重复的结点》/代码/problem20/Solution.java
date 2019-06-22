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
// 使用递归方法解答
public class Solution {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) {// 判断传进来的结点是否为null或者它的下一个结点是否为null
			return pHead;
		}

		if (pHead.val == pHead.next.val) {// 当前结点的值和它的下一个结点的值是一样时，返回与该值不同的结点
			ListNode current = pHead.next;
			while (current != null && current.val == pHead.val)// 不断地往下搜索，不断地更新current
			{
				current = current.next;
			}
			return deleteDuplication(current);
		} else {
			// 当前结点的值和它的下一个结点的值不一样时，把该结点的next指针指向本函数的返回值(传入参数为该结点的下一结点，起到一个鉴定的作用)，最后返回该结点
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
	}
}
