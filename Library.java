import java.util.ArrayList;
import java.util.*;

public class Library
{
	public static void main(String[] args)
	{		
		ArrayList<LibBook> book=new ArrayList<LibBook>();
		book.add(new LibBook("C Primer Plus","人民邮电出版社","Stephen Prata",89));
		book.add(new LibBook("Java核心技术","机械工业出版社","Cay S. Horstmann",119));
		book.add(new LibBook("离散数学及其应用","机械工业出版社","Kenneth H. Rosen",59));
		book.add(new LibBook("万历十五年","三联书店","黄仁宇",40));
		book.add(new LibBook("品读国学经典","三联书店","夏海",45));
		
		Scanner reader=new Scanner(System.in);
		
		Administration administrator=new Administration();
		
		//增加图书
		administrator.addBook(book.get(0));
		administrator.addBook(book.get(1));
		administrator.addBook(book.get(2));
		administrator.addBook(book.get(3));
		administrator.getBookInfo();
		
		//修改图书
		int j;
		System.out.print("请输入要修改图书的编号: ");
		j=reader.nextInt();
		administrator.setBook(j, book.get(4));
		administrator.getBookInfo();
		
		//删除图书
		int i;
		System.out.print("请输入要删除图书的编号: ");		
		i=reader.nextInt();
		administrator.delBook(i);
		administrator.getBookInfo();	
		
		User user=new User("张三");
		user.getInfo();							//查询借阅信息
		user.setName("李四");						//修改用户信息
		user.borrowBook(book.get(1));			//借书
		user.getInfo();
		user.borrowBook(book.get(2));
		user.returnBook();						//还书
		user.getInfo();
		user=null;								//退出
	}
}

class User
{
	private String name;
	private LibBook userBook=null;
	
	public User(String name)
	{
		this.name=name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void borrowBook(LibBook book)
	{
		if(userBook!=null)
			System.out.println("请先归还借阅图书");
		else
			userBook=book;
	}
	
	public void returnBook()
	{
		userBook=null;
	}
	
	public void getInfo()
	{
		if(userBook==null)
			System.out.println(name+"无借阅图书");
		else
		{
			System.out.println(name+"借阅图书信息如下: ");
			System.out.println("书名:"+userBook.getBookName()+
					", 出版社:"+userBook.getPress()+
					", 作者:"+userBook.getAuthor()+
					", 价格:"+userBook.getPrice());
		}
	}
}

class LibBook
{
	private String bookName;  
	private String press;     
	private String author;
	private double price;
	
	public LibBook(String bookName,String press,String author,double price)
	{
		this.bookName=bookName;
		this.press=press;
		this.author=author;
		this.price=price;
	}
	
	public String getBookName()
	{
		return bookName;
	}
	
	public String getPress()
	{
		return press;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public double getPrice()
	{
		return price;
	}
}

class Administration
{
	private ArrayList<LibBook> books=new ArrayList<LibBook>();
	
	public void addBook(LibBook aBook)
	{
		books.add(aBook);
	}
	
	public void delBook(int id)
	{
		books.remove(id-1);
	}
	
	public void setBook(int i,LibBook aBook)
	{
		books.set(i-1,aBook);
	}
	
	public void getBookInfo()
	{
		System.out.println("图书信息如下: ");
		for(int i=0;i<books.size();i++)
			System.out.println((i+1)+". 书名:"+books.get(i).getBookName()+
					", 出版社:"+books.get(i).getPress()+
					", 作者:"+books.get(i).getAuthor()+
					", 价格:"+books.get(i).getPrice());
	}
}
