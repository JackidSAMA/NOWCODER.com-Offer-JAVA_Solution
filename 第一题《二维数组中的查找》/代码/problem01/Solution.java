package problem01;
public class Solution {
	/**
	 * @author Jackid
	 * JDK-version:1.8
	 * Problem:ţ����-��ָoffer����ά�����еĲ��ҡ�
	 * Result:��ͨ�������еĲ�������
	 */
	/*
	 * ��Ŀ������ ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
	 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
	 */
	public boolean Find(int target, int[][] array) {
		try {
			int col_length = array[0].length;// ��¼�������������col_length��ʾ
			for (int[] i : array) {// ���������е�ÿһ��,����������i��ʾ
				if (i[0] <= target && i[col_length - 1] >= target) {// �ж�target�Ƿ��ڴ����鷶Χ�У���������ʼ��ά������һ�еı���
					// ������ʹ�ö��ֲ��ҷ�Ѱ��target�Ƿ��ڴ�������

					int start = 0;// �������ָ�룬ָ�������һ��Ԫ��
					int end = col_length - 1;// �����յ�ָ�룬ָ���������һ��Ԫ��
					while (start <= end) {
						int mid = (start + end) / 2;// �м�ָ�룬ָ��������м�Ԫ��
						if (target < i[mid]) {
							end = mid - 1;
						} else if (target > i[mid]) {
							start = mid + 1;
						} else {
							return true;// ��target���������е�Ԫ�ؼ�i[mid]ʱ��Ϊ�Ѿ��ҵ��������ֱ�ӷ���true���������ý�����
						}
					}
				}
			}
			return false;// ������������Ȼ�޷��ҵ�target���򷵻�false
		} catch (ArrayIndexOutOfBoundsException e) {// ��ֹ��������Ϊ�յ������ֱ�ӷ���false
			return false;
		}
	}
}
