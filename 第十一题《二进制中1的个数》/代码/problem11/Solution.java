package problem11;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����������1�ĸ�����
 * Result:��ͨ�������еĲ�������
 */
/*
 * ��Ŀ����: ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */

public class Solution {
	public int NumberOf1(int n) {
		int sum = 0;//ͳ��n�Ķ������С�1���ĸ����ı���
		while (n != 0) {
			sum++;
			n = n & (n - 1);//n & (n - 1)��������㽫Ŀ�����Ķ�������ʽ�е����ұߵġ�1��������
		}
		return sum;
	}
}
