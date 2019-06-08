package problem19;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����ΪS���������֡�
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
�������:
��Ӧÿ�����԰����������������С���������
 */

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int pre = 0;//��1��ָ���ʼָ������Ŀ�ͷ
		int end = array.length - 1;//��2��ָ���ʼָ������Ľ�β
		ArrayList<Integer> target = new ArrayList<>();//��ĿҪ�󷵻�һ�����ϣ������е�Ԫ��Ϊ���������������
		int min = Integer.MAX_VALUE;//ȫ�ֱ���min��¼��ΪS���������ĳ˻���Сֵ
		while (pre < end) {//�������ָ�뻹û����һ��ʱ������ָ����ָ���Ԫ��֮����sum�Ƚ�
			if (array[pre] + array[end] == sum) {
				//���������ӽ����sum��ͬ���������˻���min���Ƚϣ�����Ҫ��ʱ����ȫ�ֱ���min�ͼ���target
				if (array[pre] * array[end] < min) {
					min = array[pre] * array[end];
					target.clear();
					target.add(array[pre]);
					target.add(array[end]);
				}
				//������ɺ�����ָ�����˴˿�£һ��
				pre++;end--;
			} else if (array[pre] + array[end] < sum) {
				//���������ӽ��С��sum����˵����Ҫ���������preָ����endָ�뿿��һ��
				pre++;
			} else {
				//���������ӽ������sum����˵����Ҫ��С������endָ����preָ�뿿��һ��
				end--;
			}
		}
		return target;//��󷵻ؼ���target
	}
}