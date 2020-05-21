import java.util.*;

public class Test4
{
	public static void main(String[] args)
	{
		String str1;
		String str2;
		String str3;
		
		Scanner reader=new Scanner(System.in);

		System.out.print("请输入字符串1: ");
		str1=reader.nextLine();
		System.out.print("请输入字符串2: ");
		str2=reader.nextLine();
		System.out.print("请输入字符串3: ");
		str3=reader.nextLine();
		
		ConcatenateStr test=new ConcatenateStr(str1,str2,str3);
		System.out.println(test.concatenate());
	}
}

class ConcatenateStr
{
	private String str;
	private String str1;
	private String str2;
	private String str3;
	
	public ConcatenateStr(String str1,String str2,String str3)
	{
		this.str1=str1;
		this.str2=str2;
		this.str3=str3;
	}
	
	public String concatenate()
	{
		if(str1.length()<=str2.length() && str1.length()<=str2.length())
			str=str2+str3+str1;
		else if(str2.length()<=str1.length() && str2.length()<=str3.length())
			str=str1+str3+str2;
		else
			str=str1+str2+str3;
		return str;
	}
}
