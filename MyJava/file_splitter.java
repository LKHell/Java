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
            int i=0,part=0,
                int_begin=0,int_part_end=0,int_set_end=0;
           
            System.out.println("set part");
            part =intype.nextInt();
            System.out.println("set begin");
            int_begin =intype.nextInt();
            
            if(int_begin>=0)
            {
                for(int n=1;n<=part;n++)
                {   
                    for(;;)
                    {
                        System.out.println("set end ( -1 == lastline)");
                        int_set_end =intype.nextInt();
                        if(int_set_end==-1)
                        {
                            int_part_end =-1;
                            break;
                        }else if (int_set_end>int_part_end){
                            int_part_end = int_set_end;
                            break;
                        }else{
                            System.out.println("error input again.");
                        }
                    }
                    
                    fos = new FileOutputStream(filename+"_"+n+".txt");
                    osw = new OutputStreamWriter(fos, "UTF-8");
                    write_buffer =new BufferedWriter(osw);
                    System.out.println("part "+n);   
                    while ((s=reader_buffer.readLine())!=null)
                    {
                        i++;
                        if(int_part_end==-1)
                        {
                            if(i>=int_begin)
                            { 
                                write_buffer.write(s);
                                write_buffer.newLine();
                            }
                        }
                        else
                        {
                            if(i>=int_part_end) 
                            {
                                int_begin=int_part_end;
                                write_buffer.flush();
                                break;
                            }
                            else
                            {
                                if(i>=int_begin)
                                { 
                                    write_buffer.write(s);
                                    write_buffer.newLine();
                                }
                            }
                        }
                        
                    }
                }
                System.out.println("finished");
                write_buffer.close();
                reader_buffer.close();

            }
            else
            {
                System.out.println("error for set begin");
            }
       
            intype.close();
            
            
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}