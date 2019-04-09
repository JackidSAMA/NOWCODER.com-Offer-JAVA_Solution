package problem02;

public class Solution {
	/**
	 * @author Jackid
	 * JDK-version:1.8
	 * Problem:ţ����-��ָoffer���滻�ո�
	 * Result:��ͨ�������еĲ�������
	 */
	/*
		��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��  
	 */
	public String replaceSpace(StringBuffer str) {
		int old_length = str.length();// �ַ�������
		int space_amount = 0;// ԭ�ַ����пո������

		for (char i : str.toString().toCharArray()) {// �����ַ������Ի�ÿո������
			if (i == ' ') {
				space_amount += 2;
			}
		}

		str.setLength(str.length() + space_amount);// ��str����Ϊ���ո��滻��%20�������
		int pre = old_length - 1;// ԭ�ַ��������һ���ַ����±�
		int current = str.length() - 1;// ���ݺ��ַ��������һ���ַ����±�

		// ��ʼɨ�裡����
		while (pre != current)// ��preָ���currentָ���߲���һ��ʱ
		{
			if (str.charAt(pre) != ' ') {// ��ɨ�赽�ǿո���ַ�ʱ
				// �ַ���currentλ�ø���preλ�õ��ַ���Ȼ����ǰ��һ��(���ü�)
				str.setCharAt(current--, str.charAt(pre--));
			} else {// ��ɨ�赽�ո�ʱ
				// currentָ�������滻��Ŀ���ַ���"%20",ÿһ������滻����ǰ��һ��(���ü�)
				str.setCharAt(current--, '0');
				str.setCharAt(current--, '2');
				str.setCharAt(current--, '%');
				// ��Ϊ�滻��ɣ�����pre��ǰһ��
				pre--;
			}
		}

		// ��󷵻��ַ���
		return str.toString();
	}

}
