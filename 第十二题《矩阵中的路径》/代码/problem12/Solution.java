package problem12;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer�������е�·����
 * Result:��ͨ�������еĲ�������
 */
/*
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� 
 * ���磺 
 * a b c e 
 * s f c s 
 * a d e e 
 * ������3 X 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 */

public class Solution {

	static int[] matrix_visited;// ���ڼ�¼�����Ԫ�صķ��������0Ϊδ�����ʣ�1Ϊ�Ѿ����ʡ�

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		matrix_visited = new int[matrix.length];// ��ʼ������

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {// �Ӿ����е�ÿһ��Ԫ�س���
				if (back(matrix, rows, cols, str, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	// matrixΪ����rowsΪ������������colsΪ������������strΪĿ���ַ�����current_rowΪ��ǰԪ�����ڵ��У�current_colΪ��ǰԪ�����ڵ��У�indexOfStrΪĿ���ַ������������ڼ����ַ�
	public static boolean back(char[] matrix, int rows, int cols, char[] str, int current_row, int current_col,
			int indexOfStr) {
		if (indexOfStr == str.length) {// ���������ͬ����˵��·����Ŀ���ַ���һ�£�����true
			return true;
		}
		if (current_row >= rows || current_col >= cols || current_row < 0 || current_col < 0) {// ���������������Խ�磬�򷵻�false
			return false;
		}
		if (matrix_visited[current_row * cols + current_col] == 1
				|| str[indexOfStr] != matrix[current_row * cols + current_col]) {// �����Ԫ���Ѿ������ʹ����߾�����·����Ŀ���ַ�����һ�£��򷵻�false
			return false;
		}
		// ǰ�����֤��ͨ���󣬿�ʼ��һ��Ԫ�ص���������
		matrix_visited[current_row * cols + current_col] = 1;// ����Ԫ�ر�־Ϊ�Ѿ�����
		// �����������ĸ��������������ֻҪ��һ�����򷵻�true����˵��������Ŀ��Ҫ������������true
		if (back(matrix, rows, cols, str, current_row + 1, current_col, indexOfStr + 1)
				|| back(matrix, rows, cols, str, current_row - 1, current_col, indexOfStr + 1)
				|| back(matrix, rows, cols, str, current_row, current_col + 1, indexOfStr + 1)
				|| back(matrix, rows, cols, str, current_row, current_col - 1, indexOfStr + 1)) {
			return true;
		}
		matrix_visited[current_row * cols + current_col] = 0;// ����ʱ������Ԫ�ػָ���δ���ʵ�״̬
		return false;// �����������û�з��أ���˵��������Ԫ�ص�·�����޷�������ĿҪ�󣬷���false
	}
}
