package problem09;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����̬��̨�ס�
 * Result:��ͨ�������еĲ�������
 */

/*
��Ŀ������
һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������*/

public class Solution {
	public int JumpFloorII(int target) {
		int record[] = new int[target + 1];//��������target+1��Ԫ�ص����飬���������±���̨�׼������Ӧ
		record[0] = 1;//��ʼ������ĵ�һ��Ԫ�أ�������Ϊ0ʱ����1������
		for (int i = 0; i < record.length; i++) {//��0����ʼ��һֱ���㵽��target����̨��
			for (int j = 0; j < i; j++) {//����һ��target����̨�׵�������0��~(target-1)��̨���������ܺ�
				record[i] += record[j];
			}
		}
		return record[target];//�����±�Ϊtarget������Ԫ��
	}
}
