public class Test5
{
	public static void main(String[] args)
	{
		Rectangle rec1=new Rectangle(0,0,5,4);
		Rectangle rec2=new Rectangle(2,3,7,9);
		Rectangle rec3=new Rectangle(9,7,6,6);
		Rectangle rec4=new Rectangle(-2,-7,2,3);
		Rectangle rec5=new Rectangle(7,-1,1,2);
		
		Position test1=new Position(rec1,rec2);
		Position test2=new Position(rec1,rec3);
		Position test3=new Position(rec1,rec4);
		Position test4=new Position(rec1,rec5);
		
		rec1.getInfo();
		rec2.getInfo();
		test1.position();
		
		System.out.println();
		rec1.getInfo();
		rec3.getInfo();
		test2.position();
		
		System.out.println();
		rec1.getInfo();
		rec4.getInfo();
		test3.position();
		
		System.out.println();
		rec1.getInfo();
		rec5.getInfo();
		test4.position();
	}
}

class Rectangle
{
	//(x,y)为矩形左上角顶点的坐标
	private double x;
	private double y;
	private double width;
	private double height;
	
	public Rectangle(double x,double y,double width,double height)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double computeArea()
	{
		return width*height;
	}
	
	public double computePer()
	{
		return 2*(width+height);
	}
	
	public void getInfo()
	{
		System.out.println("矩形的信息如下: ");
		System.out.println("周长:"+this.computePer()+" 面积:"+this.computeArea());
	}
}

class Position
{
	private Rectangle rec1;
	private Rectangle rec2;
	
	public Position(Rectangle rec1,Rectangle rec2)
	{
		this.rec1=rec1;
		this.rec2=rec2;
	}
	
	public void position()
	{
		//(x1,y1)为矩形rec1右下角顶点的坐标
		double x1=rec1.getX()+rec1.getWidth();
		double y1=rec1.getY()-rec1.getHeight();
		
		//(x2,y2)为矩形rec2右下角顶点的坐标
		double x2=rec2.getX()+rec2.getWidth();
		double y2=rec2.getY()-rec2.getHeight();

		//boolean isIntersect=(rec2.getX()>=rec1.getX()&&rec2.getX()<=x1)
		//		&&(rec2.getY()>=y2&&rec2.getY()<=rec1.getY());
				
		//矩形2在矩形1的左边
		boolean isLeft=x2<rec1.getX();
		
		//矩形2在矩形1的右边
		boolean isRight=rec2.getX()>x1;
		
		//矩形2在矩形1的上面
		boolean isAbove=y2>rec1.getY();
				
		//矩形2在矩形1的下面
		boolean isBelow=rec2.getY()<y1;
		
		//矩形1与矩形2相交
		boolean isIntersect=!(isLeft||isRight||isAbove||isBelow);
		
		//判断矩形1是否与矩形2相交
		if(isIntersect)
			System.out.println("两矩形相交");
		else
		{
			System.out.println("两矩形不相交");
		
			//判断矩形2是否在矩形1的左边
			if(isLeft)
				System.out.println("矩形2在矩形1的左边");
		
			//判断矩形2是否在矩形1的右边
			else if(isRight)
				System.out.println("矩形2在矩形1的右边");
		
			//判断矩形2是否在矩形1的上面
			if(isAbove)
				System.out.println("矩形2在矩形1的上面");
		
			//判断矩形2是否在矩形1的下面
			else if(isBelow)
				System.out.println("矩形2在矩形1的下面");
		}
	}
}
