package problem04;

/**
 * @author Jackid JDK-version:1.8 Problem:牛客网-剑指offer《重建二叉树》 Result:已通过了所有的测试用例
 */

/*
 * 题目描述： 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class Solution {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);// 初始化参数并进入递归
	}

	public TreeNode reConstructBinaryTree(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {// 每一次调用都是一棵新树
		if (startpre > endpre || startin > endin) {// 子树没有元素时，返回null
			return null;
		}
		TreeNode root = new TreeNode(pre[startpre]);// 将该范围数组的第一个元素设置为根节点

		for (int i = startin; i <= endin; i++) {
			if (in[i] == pre[startpre]) {// 找到根节点时
				// 根节点前面的所有位置都是它的左子树，left指针指向左子树
				root.left = reConstructBinaryTree(pre, startpre + 1, startpre + i - startin, in, startin, i - 1);
				// 根节点后面的所有位置都是它的右子树，right指针指向右子树
				root.right = reConstructBinaryTree(pre, startpre - startin + i + 1, endpre, in, i + 1, endin);
				break;
			}
		}
		return root;// 返回根节点
	}
}
