package problem12;
/**
 * @author Jackid
 * JDK-version:1.8
 * Problem:牛客网-剑指offer《矩阵中的路径》
 * Result:已通过了所有的测试用例
 */
/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如： 
 * a b c e 
 * s f c s 
 * a d e e 
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

public class Solution {

	static int[] matrix_visited;// 用于记录矩阵的元素的访问情况，0为未被访问，1为已经访问。

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		matrix_visited = new int[matrix.length];// 初始化数组

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {// 从矩阵中的每一个元素出发
				if (back(matrix, rows, cols, str, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	// matrix为矩阵，rows为矩阵总行数，cols为矩阵总列数，str为目标字符串，current_row为当前元素所在的行，current_col为当前元素所在的列，indexOfStr为目标字符串中搜索到第几个字符
	public static boolean back(char[] matrix, int rows, int cols, char[] str, int current_row, int current_col,
			int indexOfStr) {
		if (indexOfStr == str.length) {// 如果两者相同，则说明路径与目标字符串一致，返回true
			return true;
		}
		if (current_row >= rows || current_col >= cols || current_row < 0 || current_col < 0) {// 如果行数或者列数越界，则返回false
			return false;
		}
		if (matrix_visited[current_row * cols + current_col] == 1
				|| str[indexOfStr] != matrix[current_row * cols + current_col]) {// 如果该元素已经被访问过或者经过的路径与目标字符串不一致，则返回false
			return false;
		}
		// 前面的验证都通过后，开始下一个元素的搜索工作
		matrix_visited[current_row * cols + current_col] = 1;// 将本元素标志为已经访问
		// 向上下左右四个方向进行搜索，只要有一个方向返回true，就说明符合题目所要求的情况，返回true
		if (back(matrix, rows, cols, str, current_row + 1, current_col, indexOfStr + 1)
				|| back(matrix, rows, cols, str, current_row - 1, current_col, indexOfStr + 1)
				|| back(matrix, rows, cols, str, current_row, current_col + 1, indexOfStr + 1)
				|| back(matrix, rows, cols, str, current_row, current_col - 1, indexOfStr + 1)) {
			return true;
		}
		matrix_visited[current_row * cols + current_col] = 0;// 回溯时，将本元素恢复成未访问的状态
		return false;// 如果上述处理都没有返回，则说明经过本元素的路径都无法符合题目要求，返回false
	}
}
