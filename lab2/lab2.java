import java.util.*;
class A
{
    void gys(int x,int y){}
}

class A_1 extends A
{
    
    void gys(int x,int y)
    {
        int sum=x*y;
        int z;
        if(x<y)
        {
            z=x;
            x=y;
            y=z;
        }
        while(y!=0)
        {
            z=x%y;
            x=y;
            y=z;
                        
        }
        System.out.println("Maximum common divisor "+x+";");
        System.out.println("Least common multiple "+sum/x+";");
    }
}

public class lab2
{
    public static void main(String args[])
    {
        System.out.println("Input two number:");
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        in.close();

        A aa;
        aa=new A_1();
        aa.gys(a,b);
    }
}