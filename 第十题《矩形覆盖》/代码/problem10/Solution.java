package problem10;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer�����θ��ǡ�
 * Result:��ͨ�������еĲ�������
 */
/*
��Ŀ����:
���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����*/

public class Solution {
	public int RectCover(int target) {
		if (target <= 2) {// nΪ1ʱ����1�ַ�����nΪ2ʱ����2�ַ������ֱ�Ϊ2*1+2*1��1*2+1*2(������������������)
			return target;// ֱ�ӷ��ش�������target
		}
		int solution[] = new int[target + 1];
		solution[1] = 1;
		solution[2] = 2;// ����target+1��Ԫ�ص����飬ʹ�����±�պö�Ӧ��target
		for (int i = 3; i < solution.length; i++) {// ������ͷ���㵽������β��
			// ����һ�£�2*i�Ĵ��������
			// 2*(i-1)�Ĵ���μ���һ��2*1��С����(һ�����ŵ�С��)��
			// 2*(i-2)�Ĵ���μ�������1*2��С����(������ŵ�С��)
			// ��������ɵ�
			solution[i] = solution[i - 1] + solution[i - 2];
		}
		return solution[target];
	}
}
