import java.io.*;
import java.util.*;



public class lab4
{
    public static void main(String args[])
    {
        
        int n;
        byte b[]=new byte[25];
        String message;
        System.out.println("input the name File name ")
        Scanner input = new Scanner(System.in);
        message=input.next();
        input.close;
        message=message+".txt";
        try
        {
            File readFile =new File ("hello.txt");
            //File readFile = new File(message);
            FileinputStream in=new FileinputStream(readFile);
            while ((n=in.read(b,0,25))!=-1)
            {
                String s=new String(tom,0,n);
                System.out.print(s);
            }
            in.close;
            
        }
        catch(IOException e)
        {
            System.out.println("file read error"+e);
        }
    }
}
