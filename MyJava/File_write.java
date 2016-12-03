import java.io.*;
import java.util.*;

public class File_write
{
    public static void main(String args[])
    {
        System.out.println("Input the name of file");
        Scanner in=new Scanner(System.in);
        String input=in.next();
        in.close();
        
        File file_name=new File(input);
        
        byte b[]="testd".getBytes();
        try
        {
            FileOutputStream outStream=new FileOutputStream(file_name);
            outStream.write(b);
            outStream.close();
            FileInputStream inStream=new FileInputStream(file_name);
            int n=0;
            while((n=inStream.read(b,0,2))!=-1)
            {
                String str=new String(b,0,n);
                System.out.print(str);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}