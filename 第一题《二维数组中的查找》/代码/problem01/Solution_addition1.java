package problem01;
import java.util.Arrays;
public class Solution_addition1 {
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
	
	/*���������һ���д��*/
	public boolean Find(int target, int[][] array) {
		for (int[] i : array) {
			if (Arrays.binarySearch(i, target) >= 0) {
				return true;
			}
		}
		return false;
	}
}
