package problem18;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer���������ظ������֡�
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� 
������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 */

public class Solution {
	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication in
	// C/C++
	// ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
	// Return value: true if the input is valid, and there are some duplications in
	// the array number
	// otherwise false
	public boolean duplicate(int numbers[], int length, int[] duplication) {

		for (int i = 0; i < length; i++) {// ���������е�ÿһ����
			while (numbers[i] != i)// ֱ���������ֵ�����Լ���λ�����Ӧ������һֱ���滻
			{
				if (numbers[numbers[i]] != numbers[i]) {// ���滻�����У��������������ͬ���������滻
					int temporary = numbers[numbers[i]];
					numbers[numbers[i]] = numbers[i];
					numbers[i] = temporary;
				} else {
					// ���������������ͬ����������ʾ�������г������ظ������֣���������ֵ��duplication[0],ͬʱ����true
					duplication[0] = numbers[i];
					return true;
				}
			}
		}
		return false;// �Ҳ����ͷ���false
	}
}