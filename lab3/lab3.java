import java.util.*;

interface N
{  
    void f(int a ,int b)throws myexception;
    void f2(int a,int b) throws myexception;
} 

class myexception extends Exception
{  
    String message;   
    myexception(int a,int b)
    {    
        message=a+" or "+b+" is not positive integer";
    }   
    public String getmessage()
    {   
        return message;   
    }  
}  


class A implements N 
{  
    public void f(int a ,int b)throws myexception
    {   
        if(a<=0||b<=0)
        {       
            myexception ex=new myexception(a,b); 
            throw(ex);    
        }   
        int c;
        if(a<b)
        {    
            c=a;    
            a=b;    
            b=c;    
        }    
        
        while(b!=0)
        {    
            c=a%b;    
            a=b;    
            b=c;   
        }     
         System.out.println("Maximum common divisor "+a+";");
       
        }  


    public void f2(int a ,int b)throws myexception
    {   
        if(a<=0||b<=0)
        {       
            myexception ex=new myexception(a,b); 
            throw(ex);    
        }   
        
        int c,sum;
           //
        sum=a*b;   //
        
        if(a<b)
        {    
            c=a;    
            a=b;    
            b=c;    
        }    
        
        while(b!=0)
        {    
            c=a%b;    
            a=b;    
            b=c;   
        }     
        
        System.out.println("Least common multiple "+sum/a+";");
    }  
}  

public class lab3

{
    public static void main(String args[])
    {    
        System.out.println("Input 2  positive integers");      
        Scanner in=new Scanner(System.in);           
        int a=in.nextInt();          
        int b=in.nextInt();          
        in.close();  

        N aa=new A(); //N 
      
        try
        {     
            aa.f(a, b);     
        }     
        catch(myexception y)
        {    
            
            System.out.println(y.getmessage());    
        }      
        try
        {     
           aa.f2(a, b);     
        }     
        catch(myexception y)
        {     
            System.out.println(y.getmessage());    
        }      
    } 
}