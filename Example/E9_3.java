import java.io.*;

public class E9_3
{
    public static void main(String args[])
    {
        File file_name=new File ("hello.txt") ;
        byte b[]="welcome ".getBytes();
        try
        {
            FileOutputStream out =new FileOutputStream (file_name);
            out.write(b);
            out.close();
            FileInputStream in= new FileInputStream(file_name);
            int n=0;
            while((n=in.read(b,0,2))!=-1)
            {
                String str=new String(b,0,n);
                System.out.println(str);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}