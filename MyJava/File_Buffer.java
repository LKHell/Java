import java.io.*;

public class File_Buffer
{
    public static void main(String args[])
    {
        File file_read=new File("file_read.txt");
        File file_write=new File("file_write.txt");
        try
        {
            FileReader reader=new FileReader(file_read);
            BufferedReader reader_buffered=new BufferedReader(reader);
            FileWriter writer=new FileWriter(file_write);
            BufferedWriter writer_buffered=new BufferedWriter(writer);

            String s=null;
            int i=0;
            while((s=reader_buffered.readLine())!=null)
            {
                i++;
                writer_buffered.write(i+" "+s);
                writer_buffered.newLine();
            }
            writer_buffered.flush();
            writer_buffered.close();
            writer.close();

            reader=new FileReader(file_write);
            reader_buffered =new BufferedReader(reader);
            while ((s=reader_buffered.readLine())!=null)
            {
                System.out.println(s);
            }
            reader.close();
            reader_buffered.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}