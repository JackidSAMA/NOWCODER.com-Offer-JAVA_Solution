package problem07;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer��쳲��������С�
 * Result:��ͨ�������еĲ�������
 */

/*��Ŀ������
��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
n<=39*/

// ��������
public class Solution {
	public int Fibonacci(int n) {
		int array[] = { 0, 1 };
		if (n < 2) {
			return array[n];
		}
		int temporary = 0;
		for (int i = 2; i <= n; i++) {// ѭ�����ڼƴ���
			temporary = array[0] + array[1];
			array[0] = array[1];
			array[1] = temporary;
		}
		return temporary;
	}
}
