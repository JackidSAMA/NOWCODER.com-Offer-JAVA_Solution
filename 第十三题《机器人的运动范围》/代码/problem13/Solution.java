package problem13;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《机器人的运动范围》
 * Result:已通过了所有的测试用例
 */
/*题目描述:
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
每一次只能向左，右，上，下四个方向移动一格，
但是不能进入行坐标和列坐标的数位之和大于k的格子。 
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
请问该机器人能够达到多少个格子？
 */

public class Solution {
	static int visited[][];//标记已经被访问的格子，由1或0表示
	static int[] x = { 1, 0, -1, 0 };// 右、下、左、上
	static int[] y = { 0, 1, 0, -1 };// 右、下、左、上

	public int movingCount(int threshold, int rows, int cols)// threshold指的是题目中的k，rows为m，cols为n
	{
		visited = new int[rows][cols];//初始化数组
		if (threshold < 0)//k小于0，则地图上所有点都不符合题意，返回0
			return 0;
		else
			return find(threshold, rows, cols, 0, 0);//初始化并开始寻找
	}

	//find(...)是搜索函数，用来搜索地图中的格子
	public static int find(int threshold, int rows, int cols, int current_row, int current_col) {
		int road = 1;//能进入到该函数的都是新的格子，所以格子数为1
		visited[current_row][current_col] = 1;//将该格子标记为已访问
		for (int i = 0; i < 4; i++) {//四个方向分别搜索
			if (judge(threshold, rows, cols, current_row + y[i], current_col + x[i]))
				//符合要求时，进入下一个格子的搜索
				road += find(threshold, rows, cols, current_row + y[i], current_col + x[i]);//向四个方向收集符合要求的格子的数量
		}
		return road;//返回搜索得到的格子数
	}

	//judge(...)是判断函数，用来判断当前格子是否合法。
	public static boolean judge(int threshold, int rows, int cols, int current_row, int current_col) {
		if (current_row >= rows || current_row < 0 || current_col >= cols || current_col < 0)//判断是否超出地图界限
			return false;

		if (visited[current_row][current_col] == 1)//判断格子是否被访问过
			return false;

		//以下是判断行坐标和列坐标的数位之和是否大于k
		int sum = 0;
		String string_current_row = String.valueOf(current_row);
		String string_current_col = String.valueOf(current_col);

		for (int i = 0; i < string_current_row.length(); i++)
			sum += Integer.valueOf(string_current_row.substring(i, i + 1));

		for (int i = 0; i < string_current_col.length(); i++)
			sum += Integer.valueOf(string_current_col.substring(i, i + 1));

		if (sum > threshold)
			return false;

		//以上判断均通过则返回true
		return true;
	}
}
