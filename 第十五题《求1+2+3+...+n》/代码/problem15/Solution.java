package problem15;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����1+2+3+...+n��
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */

public class Solution {
	// ����Ĺؼ����ڵݹ���õ���ֹ�㣬�����ʹ�ݹ鲻�ٽ��С�
	public int Sum_Solution(int n) {
		int ans = n;
		// ��·�룺��&&(��·��)��ߵ��¼����һ�����ж�Ϊfalse���ұߵ��¼�һ�ɲ�ִ��
		// ���ö�·����ص㣬����ʵ����ֹ�ݹ��Ч��
		// java����Ҫ�н��շ������ݵ�����,�����Ǳ�������ӡ��䡢if�ȵ�
		boolean flag = ans != 0 && (ans += Sum_Solution(n - 1)) > 0;
		return ans;
	}
}