import java.io.*;

public class E9_4
{
    public static void main(String args[])
    {
        File file =new File("hello.txt");
        char b[]="test for E9_4".toCharArray();
        
      
        
        try{
            FileWriter out =new FileWriter(file,true);
            out.write(b);
          
            out.write("test_2");
            out.close();
            FileReader in =new FileReader(file);
            int n=0;
            while ((n=in.read(b,0,2))!=-1)
            {
                String str =new String(b,0,n);
                System.out.print(str);
            }
            System.out.println();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    }
}