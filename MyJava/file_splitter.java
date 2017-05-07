import java.io.*;
import java.util.*;

public class file_splitter
{
    public static void main(String args[])
    {
        
        try{
            Scanner intype=new Scanner(System.in);
            System.out.println("set file name");
            String filename=intype.next();
            FileInputStream fis = new FileInputStream(filename+".txt");   
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader_buffer=new BufferedReader(isr);

            FileOutputStream fos;   
            OutputStreamWriter osw ;
            BufferedWriter write_buffer=null ;
            
            String s=null;
            int i=0,ibegin=0,iend=0,part=0;
           
            System.out.println("set part");
            part =intype.nextInt();
            System.out.println("set begin");
            ibegin =intype.nextInt();
          
            for(int n=1;n<=part;n++)
            {   
                System.out.println("set end"); 
                iend =intype.nextInt();
                fos = new FileOutputStream(filename+"_"+n+".txt");
                osw = new OutputStreamWriter(fos, "UTF-8");
                write_buffer =new BufferedWriter(osw);
                System.out.println("part "+n);   
                while ((s=reader_buffer.readLine())!=null)
                {
                    i++;
                    if(i>=iend) 
                    {
                        ibegin=iend;
                        write_buffer.flush();
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
            }
            System.out.println("finished");
            intype.close();
            
            write_buffer.close();
            reader_buffer.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}