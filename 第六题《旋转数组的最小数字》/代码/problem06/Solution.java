package problem06;

import java.util.Arrays;

/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����ת�������С���֡�
 * Result:��ͨ�������еĲ�������
 */

/*��Ŀ����:
��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء� 
��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��*/

public class Solution {
	public int minNumberInRotateArray(int[] array) {

		int start = 0;//ָ��startָ�������һ��Ԫ��
		int end = array.length - 1;//ָ��endָ���������һ��Ԫ��

		while (start < end) {// ����Ԫ�ش���1��ʱ�����ѭ��
			if (array[start] < array[end]) {// �����������һ��Ԫ�ش��ڵ�һ��Ԫ�أ���˵����������ת��0��Ԫ�أ������ֱ�ӷ��������һ��Ԫ��
				return array[start];
			}

			if (end - start == 1) {// ���ǰ���±����1����˵��������С������endָ��ָ���Ԫ�أ�ֱ�ӷ���array[end]
				return array[end];
			}

			int mid = (start + end) / 2;// ��midָ����и���

			if (array[start] == array[end] && array[mid] == array[end]) {// ���start��mid��endָ��ָ���Ԫ�ؾ���ȣ�����Ҫͨ��˳�����ȷ���÷�Χ���������СԪ��
				return eachFind(array, start, end);
			}

			// ���������û����������ʱ�����к��Ĳ���
			if (array[start] <= array[mid]) {// ��midָ���Ԫ�ز�С��startָ���Ԫ��ʱ��˵����С��Ԫ���ڸ÷�Χ���Ұ벿�֣���mid��ֵ��start
				start = mid;
			} else if (array[end] >= array[mid]) {// ��midָ���Ԫ�ز�����endָ���Ԫ��ʱ��˵����С��Ԫ���ڸ÷�Χ���Ұ벿�֣���mid��ֵ��end
				end = mid;
			}

		}

		return start == end ? array[start] : 0;// ���鳤��Ϊ1ʱ�����ص�һ��Ԫ�أ����鳤��Ϊ0ʱ������0
	}

	public int eachFind(int[] array, int start, int end) {// ˳�����
		int result = Integer.MAX_VALUE;
		for (int i : Arrays.copyOfRange(array, start, end)) {// �������ķ�Χ����
			result = result < i ? result : i;
		}
		return result;// ���ؽ��
	}

}