import java.io.*;
import java.util.*;

public class for_document
{
    public static void main(String args[])
    {
        
        try{
            FileInputStream fis = new FileInputStream("file_read.txt");   
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader_buffer=new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream("file_write.txt");   
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter write_buffer =new BufferedWriter(osw);
            
            String s=null;
            int i=0,ibegin=0,iend=0;
            Scanner intype=new Scanner(System.in);
            System.out.println("set begin");
            ibegin =intype.nextInt();
            System.out.println("set end"); 
            iend =intype.nextInt();
            intype.close();

            while ((s=reader_buffer.readLine())!=null)
            {
                i++;
                 if(i>=iend) 
                 {
                     break;
                 }
                 else
                 {
                      if(i>=ibegin)
                      { 
                        write_buffer.write(s);
                        write_buffer.newLine();
                      }
                }
            }
   System.out.println("finished");
            write_buffer.flush();
            write_buffer.close();
            reader_buffer.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}