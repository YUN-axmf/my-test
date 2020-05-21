package test3;

import java.util.*;

public class Test3
{
	public static void main(String[] args)
	{
		String str;
		Scanner reader=new Scanner(System.in);
		System.out.print("请输入一行字符: ");
		str=reader.nextLine();
		Statistics test=new Statistics(str);
		test.count();
	}
}

class Statistics
{
	private String str;
	private int capLetNum=0;	//大写字母数
	private int lowLetNum=0;	//小写字母数
	private int digitNum=0;	//数字数
	private int spaceNum=0;	//空格数
	private int charNum=0;	//其他字符数
	
	public Statistics(String s)
	{
		str=s;
	}
	
	public void count()
	{
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
				capLetNum++;
			else if(str.charAt(i)>='a'&&str.charAt(i)<='z')
				lowLetNum++;
			else if(str.charAt(i)>='0'&&str.charAt(i)<='9')
				digitNum++;
			else if(str.charAt(i)==' ')
				spaceNum++;
			else
				charNum++;
		}
		System.out.println("该行字数信息如下: ");
		System.out.println("大写字母数:"+capLetNum+" 小写字母数:"+lowLetNum+" 数字数:"+digitNum+
				" 空格数:"+spaceNum+" 其它字符数:"+charNum);
	}
}
