import java.io.*;

public class E9_5
{
    public static void main(String args[])
    {
        File file_read=new File("hello.txt"),
             file_write=new File("test9_5_2.txt");
        try{
            FileReader   reader  =new FileReader(file_read);
            BufferedReader reader_buffer=new BufferedReader(reader);

            FileWriter writer  =new FileWriter(file_write);
            BufferedWriter write_buffer =new BufferedWriter(writer);

            String s=null;
            int i=0;
            while ((s=reader_buffer.readLine())!=null)
            {
                i++;
                write_buffer.write(i+" "+s);
                write_buffer.newLine();
            }

            write_buffer.flush();
            write_buffer.close();
            write_buffer.close();

            
            reader=new FileReader(file_read);
            reader_buffer=new BufferedReader(reader);
            while ((s=reader_buffer.readLine())!=null)
            {
                System.out.println(s);
            }

            reader.close();
            reader_buffer.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}