package problem13;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:ţ����-��ָoffer�������˵��˶���Χ��
 * Result:��ͨ�������еĲ�������
 */
/*��Ŀ����:
������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���
ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� 
���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
���ʸû������ܹ��ﵽ���ٸ����ӣ�
 */

public class Solution {
	static int visited[][];//����Ѿ������ʵĸ��ӣ���1��0��ʾ
	static int[] x = { 1, 0, -1, 0 };// �ҡ��¡�����
	static int[] y = { 0, 1, 0, -1 };// �ҡ��¡�����

	public int movingCount(int threshold, int rows, int cols)// thresholdָ������Ŀ�е�k��rowsΪm��colsΪn
	{
		visited = new int[rows][cols];//��ʼ������
		if (threshold < 0)//kС��0�����ͼ�����е㶼���������⣬����0
			return 0;
		else
			return find(threshold, rows, cols, 0, 0);//��ʼ������ʼѰ��
	}

	//find(...)����������������������ͼ�еĸ���
	public static int find(int threshold, int rows, int cols, int current_row, int current_col) {
		int road = 1;//�ܽ��뵽�ú����Ķ����µĸ��ӣ����Ը�����Ϊ1
		visited[current_row][current_col] = 1;//���ø��ӱ��Ϊ�ѷ���
		for (int i = 0; i < 4; i++) {//�ĸ�����ֱ�����
			if (judge(threshold, rows, cols, current_row + y[i], current_col + x[i]))
				//����Ҫ��ʱ��������һ�����ӵ�����
				road += find(threshold, rows, cols, current_row + y[i], current_col + x[i]);//���ĸ������ռ�����Ҫ��ĸ��ӵ�����
		}
		return road;//���������õ��ĸ�����
	}

	//judge(...)���жϺ����������жϵ�ǰ�����Ƿ�Ϸ���
	public static boolean judge(int threshold, int rows, int cols, int current_row, int current_col) {
		if (current_row >= rows || current_row < 0 || current_col >= cols || current_col < 0)//�ж��Ƿ񳬳���ͼ����
			return false;

		if (visited[current_row][current_col] == 1)//�жϸ����Ƿ񱻷��ʹ�
			return false;

		//�������ж�����������������λ֮���Ƿ����k
		int sum = 0;
		String string_current_row = String.valueOf(current_row);
		String string_current_col = String.valueOf(current_col);

		for (int i = 0; i < string_current_row.length(); i++)
			sum += Integer.valueOf(string_current_row.substring(i, i + 1));

		for (int i = 0; i < string_current_col.length(); i++)
			sum += Integer.valueOf(string_current_col.substring(i, i + 1));

		if (sum > threshold)
			return false;

		//�����жϾ�ͨ���򷵻�true
		return true;
	}
}
