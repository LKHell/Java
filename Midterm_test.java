import java.util.*;


interface I 
{
    double round(double r);
    double triangle(double r, double h)throws myexception;
    double shadow(double r, double h)throws myexception;
}

class myexception extends Exception
{
    String message;
    myexception(double r,double h)
    {
        message="R<H";
    }

    String getmessage()
    {
        return message;
    }
}

class A implements I
{
    public double round(double r)
    {
        return r*r*Math.PI/2;
    }

    public double triangle(double r, double h)throws myexception
    {
        if(r<h)
        {
            myexception ex =new myexception (r,h);
            throw(ex);
        }
        return r*h;
    }

    public double shadow(double r,double h)throws myexception
    {
         if(r<h)
        {
            myexception ex =new myexception (r,h);
            throw(ex);
        }
		//double z = r*h ;
		//	double x= r*r*3.14/2;
       // return x-z;
		return r*r*Math.PI/2-r*h;
    }
}

public class Midterm_test
{
    public static void main(String args[])
    {
        double r,h,s;
        Scanner in =new Scanner(System.in);
	while(true)
	{
		System.out.println("please input R and H :");
         	
		r=in.nextDouble();
         	h=in.nextDouble();
		
		I aa =new A();
		try
		{
			s=aa.shadow(r,h);
			String double_str=String.format("%.4f",s);
			/* ----- */
			System.out.println("S is "+double_str);
			in.close();
			break;
		}
		catch (myexception y)
		{
		    System.out.println(y.getmessage());
		}
	}
    }
}
