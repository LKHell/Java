import java.io.*;
import java.util.*;



public class lab4
{
    public static void main(String args[])
    {
        
        int n;
        byte b[]=new byte[2];
        String message;
        System.out.println("input the name File name ");
        Scanner input = new Scanner(System.in);
        message=input.next();
        input.close();
        message=message+".txt";
        try
        {
            //File readFile =new File ("hello.txt");
            File readFile = new File(message);
            FileInputStream in=new FileInputStream(readFile);
            while ((n=in.read(b,0,2))!=-1)
            {
                String s=new String(b,0,n);
                System.out.print(s);
            }
            in.close();
            
        }
        catch(IOException e)
        {
            System.out.println("file read error"+e);
        }
    }
}
