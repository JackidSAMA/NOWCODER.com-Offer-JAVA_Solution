package problem14;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer��������ʽƥ�䡷
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� 
�ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 */

public class Solution {
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {// �пմ���1
			return false;
		}
		if (str.length == 0 && pattern.length == 0) {// �пմ���2
			return true;
		}
		if (pattern.length == 0) {// �пմ���3
			return false;
		}
		return check(str, pattern, 0, 0);// ��ʼ��Ҫ���жϺ���
	}

	public static boolean check(char[] str, char[] pattern, int str_point, int pattern_point) {

		if (str_point == str.length && pattern_point == pattern.length) {// ���ߵ�ָ����ߵ���ͷ��֤������ƥ��
			return true;
		}
		if (str.length != str_point && pattern.length == pattern_point) {// ���pattern��ָ�������꣬��ƥ��ʧ��
			return false;
		}

		if (pattern_point + 1 < pattern.length && pattern[pattern_point + 1] == '*') {
			// ���pattern_pointָ��ָ�����һ��Ԫ����*����������ָ��ָ���Ԫ����ͬ�Ļ���������·���ߣ�
			// һ��ֱ�ӷ���pattern_pointָ��ָ���Ԫ�أ�����str_pointָ��ָ���Ԫ�أ���pattern_point + 2��
			// ��������pattern_pointָ��ָ���Ԫ�أ�����str_pointָ��ָ���Ԫ�أ���str_point + 1��
			// ��������pattern_pointָ��ָ���Ԫ�أ�����str_pointָ��ָ���Ԫ�أ���str_point + 1��pattern_point + 2
			if ((str.length != str_point && pattern[pattern_point] == str[str_point])
					|| (str.length != str_point && pattern[pattern_point] == '.')) {
				return check(str, pattern, str_point, pattern_point + 2)
						|| check(str, pattern, str_point + 1, pattern_point)
						|| check(str, pattern, str_point + 1, pattern_point + 2);
			} else {
				// ���pattern_pointָ��ָ�����һ��Ԫ����*����������ָ��ָ���Ԫ�ء�������ͬ�Ļ���
				// ֻ��һ��·���ߣ�ֱ�ӷ���pattern_pointָ��ָ���Ԫ�أ�����str_pointָ��ָ���Ԫ�أ���pattern_point + 2
				return check(str, pattern, str_point, pattern_point + 2);
			}
		}
		// �������е�������ʾpattern_pointָ��ָ�����һ��Ԫ�ء�������* ��ô��ֻ�ܱȽ�����ָ��ָ���ַ��Ƿ����
		if ((str.length != str_point && pattern[pattern_point] == str[str_point])
				|| (str.length != str_point && pattern[pattern_point] == '.')) {
			return check(str, pattern, str_point + 1, pattern_point + 1);
		}
		// ���϶�û�����ص������ֻ�ܷ���false
		return false;
	}
}