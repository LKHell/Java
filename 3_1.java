import java.util.*;
interface I 
{
    void f1(double a) throws myexception;
    void f2(double b) throws myexception;
    void f3(double c) throws myexception;
}

class myexception extends Exception
{
    Strings message;
    myexception(double x){
        message= x +"error";

    } 
    public String getmessage()
    {
        return message;
    }
}

class A implements I
{
    public double f1(double a) throws myexception
    {   

        if()
        {
            myexception ex = new myexception(a,b);
            throw (ex);
        }
        double b=0;
        b=-1+2*a;
        return b;
        //System.out.println("")
    }
}

public class 3_1{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        double y=0,x=0;
        x=in.nexDouble();

        I aa=new A();
        
        if(x<0)
        {
            try
            {
                y=aa.f1(x);
            }
            catch(myexception e)
            {
                System.out.println(e.getmessage);
            }
            
        }
        System.out.println(y);
    }
}