package problem04;

/**
 * @author Jackid JDK-version:1.8 Problem:ţ����-��ָoffer���ؽ��������� Result:��ͨ�������еĲ�������
 */

/*
 * ��Ŀ������ ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */

public class Solution {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);// ��ʼ������������ݹ�
	}

	public TreeNode reConstructBinaryTree(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {// ÿһ�ε��ö���һ������
		if (startpre > endpre || startin > endin) {// ����û��Ԫ��ʱ������null
			return null;
		}
		TreeNode root = new TreeNode(pre[startpre]);// ���÷�Χ����ĵ�һ��Ԫ������Ϊ���ڵ�

		for (int i = startin; i <= endin; i++) {
			if (in[i] == pre[startpre]) {// �ҵ����ڵ�ʱ
				// ���ڵ�ǰ�������λ�ö���������������leftָ��ָ��������
				root.left = reConstructBinaryTree(pre, startpre + 1, startpre + i - startin, in, startin, i - 1);
				// ���ڵ���������λ�ö���������������rightָ��ָ��������
				root.right = reConstructBinaryTree(pre, startpre - startin + i + 1, endpre, in, i + 1, endin);
				break;
			}
		}
		return root;// ���ظ��ڵ�
	}
}
