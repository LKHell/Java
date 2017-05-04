import java.io.*;

public class for_document
{
    public static void main(String args[])
    {
        
        try{
            FileInputStream fis = new FileInputStream("file_read.txt");   
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader_buffer=new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream("file_w.txt");   
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter write_buffer =new BufferedWriter(osw);


            // File file_read=new File("file_read.txt");
            // File file_write=new File("file_w.txt");
            // FileReader   reader  =new FileReader(file_read);
            // BufferedReader reader_buffer=new BufferedReader(isr);
            // FileWriter writer  =new FileWriter(file_write);
            // BufferedWriter write_buffer =new BufferedWriter(osw);

            String s=null;
            int i=0;
            while ((s=reader_buffer.readLine())!=null)
            {
                i++;
                 if(i>=109234) 
                 {
                     break;
                 }
                 else
                 {
                      if(i>=49234)
                      { 
                        write_buffer.write(s);
                        write_buffer.newLine();
                      }
                }
            }
   System.out.println("finished");
            write_buffer.flush();
            write_buffer.close();
            // writer.close();
            // reader=new FileReader(file_write);
            // reader_buffer=new BufferedReader(reader);
          
            // while ((s=reader_buffer.readLine())!=null)
            // {
            //     System.out.println(s);
            // }
            // reader.close();
            reader_buffer.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}