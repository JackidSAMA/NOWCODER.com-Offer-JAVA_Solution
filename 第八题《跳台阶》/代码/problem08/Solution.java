package problem08;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer����̨�ס�
 * Result:��ͨ�������еĲ�������
 */

/*
��Ŀ����:
һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������*/

//�����ⷨ
//���ε�쳲���������
public class Solution {
    public int JumpFloor(int target) {
    	int array[]= {1,1};//̨����Ϊ0ʱ����1��������̨����Ϊ1ʱ����1��������
    	if (target<2) {//��̨����С�ڶ�ʱ����̨����Ϊ�±꣬������������Ӧ��Ԫ��
			return array[target];
		}
    	
    	int temporary=0;//�Ա����ķ�ʽ����ÿһ��̨�׵ķ������ļ�����Ҫ��Ϊ�˽�Լ�ռ�Ŀ���
    	for (int i = 2; i <=target; i++) {
			temporary=array[0]+array[1];//��ǰ̨��������һ�ε�̨����1��������2����ɵ�,f(n)=f(n-1)+f(n-2)
			array[0]=array[1];
			array[1]=temporary;
		}
    	return temporary;
    }
}