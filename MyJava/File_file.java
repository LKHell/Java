import java.io.*;

public class File_file
{
    public static void main(String args[])
    {
        File file=new File("testfile_file.txt");
        char b[]="test for FileReader and FileWriter".toCharArray();
        try 
        {
            FileWriter out=new FileWriter(file,true);
            out.write(b);
            out.write("test2 \n");
            out.close();
            FileReader in=new FileReader(file);
            int n=0;
            while((n=in.read(b,0,2))!=-1)
            {
                String str=new String(b,0,n);
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