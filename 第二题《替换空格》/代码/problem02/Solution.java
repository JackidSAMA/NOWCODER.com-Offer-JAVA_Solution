package problem02;

public class Solution {
	/**
	 * @author Jackid
	 * JDK-version:1.8
	 * Problem:牛客网-剑指offer《替换空格》
	 * Result:已通过了所有的测试用例
	 */
	/*
		请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。  
	 */
	public String replaceSpace(StringBuffer str) {
		int old_length = str.length();// 字符串长度
		int space_amount = 0;// 原字符串中空格的数量

		for (char i : str.toString().toCharArray()) {// 遍历字符串，以获得空格的数量
			if (i == ' ') {
				space_amount += 2;
			}
		}

		str.setLength(str.length() + space_amount);// 把str扩容为将空格替换成%20后的容量
		int pre = old_length - 1;// 原字符串的最后一个字符的下标
		int current = str.length() - 1;// 扩容后字符串的最后一个字符的下标

		// 开始扫描！！！
		while (pre != current)// 当pre指针和current指针走不到一起时
		{
			if (str.charAt(pre) != ' ') {// 当扫描到非空格的字符时
				// 字符串current位置复制pre位置的字符，然后都向前走一步(后置减)
				str.setCharAt(current--, str.charAt(pre--));
			} else {// 当扫描到空格时
				// current指针连续替换成目标字符串"%20",每一次完成替换都向前走一步(后置减)
				str.setCharAt(current--, '0');
				str.setCharAt(current--, '2');
				str.setCharAt(current--, '%');
				// 因为替换完成，所以pre往前一步
				pre--;
			}
		}

		// 最后返回字符串
		return str.toString();
	}

}
