package problem17;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer�������˻����顷
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
����ʹ�ó�����
 */

public class Solution {
	public int[] multiply(int[] A) {
		int[] result = new int[A.length];// ����һ����A��������һ��������
		if (result.length < 2) {// ���A��Ԫ����������2��ֱ�ӷ������Ǵ��������飬��Ϊ��������
			return result;
		}

		// ���˻���Ϊ�����֣�һ����ΪA[0]*A[1]*...*A[i-1]����һ����ΪA[i+1]*...*A[n-1]���������������˼��ɵó����
		// �Ƚ�result[]����ɵ�һ���ֵĽ��
		result[0] = 1;
		for (int i = 1; i < result.length; i++) {
			result[i] = result[i - 1] * A[i - 1];
		}

		// ��ʱ��result[]Ϊ��һ���֣�temporaryΪ�ڶ����֣����ڽ���һ������ڶ�������ˡ�
		int temporary = 1;
		for (int i = result.length - 2; i >= 0; i--) {
			temporary *= A[i + 1];
			result[i] *= temporary;
		}

		return result;// ���ؽ��
	}
}