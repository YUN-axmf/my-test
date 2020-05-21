public class Test2
{
	public static void main(String[] args)
	{
		Circle cir=new Circle(5);
		cir.show();
		cir.setRadius(2);
		cir.show();
		
		Cylinder cyl=new Cylinder(cir,8.2);
		cyl.show();
	}
}

class Circle
{
	private double radius;
	
	public Circle() 
	{
		radius=0;
	}
	
	public Circle(double r)
	{
		radius=r;
	}
	
	public void setRadius(double r)
	{
		radius=r;
	}
	
	public double getRadius()			//获取圆的半径
	{
		return radius;
	}
		
	public double getArea()			//获取圆的面积
	{
		return Math.PI*radius*radius;
	}
	
	public double getPerimeter()	//获取圆的周长
	{
		return 2*Math.PI*radius;
	}
	
	public void show()				//输出圆的信息
	{
		System.out.println("圆的信息如下: ");
		System.out.println("半径:"+radius+" 周长:"+this.getPerimeter()+" 面积:"+this.getArea());
	}
}

class Cylinder
{
	private double height;
	private Circle circle;
	
	public Cylinder(Circle circle, double height)
	{
		this.circle=circle;
		this.height=height;
	}
	
	public double getVolume() 	//获取圆柱体的体积
	{
		return circle.getArea()*height;	
	}
	
	public void show()			//输出圆柱体体积
	{
		System.out.println("以半径为"+circle.getRadius()+"的圆为底的圆柱体的体积如下: ");
		System.out.println("体积:"+this.getVolume());
	}
}
