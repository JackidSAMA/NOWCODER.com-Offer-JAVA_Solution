package problem16;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer�����üӼ��˳����ӷ���
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */

public class Solution {
	public int Add(int num1, int num2) {
		// num1�����Ľ��
		// ����num2��Ϊ��λ������num2Ϊ0ʱ���������еĽ�λ���Ѵ������
		while (num2 != 0) {
			int carry = (num1 & num2) << 1;// ��ͳ�ƽ�����Ҫ��������������в����Ľ�λλ��
			num1 = num1 ^ num2;// ִ��������㣬����ֵ��num1
			num2 = carry;// num2Ϊ�����������в����Ľ�λλ��
		}
		return num1;// ��󷵻�num1
	}
}