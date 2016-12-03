import java.io.*;
import java.util.*;

public class Files_in_dir
{
    public static void main(String args[])
    {
       
        System.out.println("set tpye");
        Scanner intype=new Scanner(System.in);
        String setType =intype.next();
     
        System.out.println("set path"); 
        String setPath =intype.next();
        intype.close();

        File dir =new File(setPath);

        FileType accepttype=new FileType(setType);
       
        File file_list[]= dir.listFiles(accepttype);
                            /* .listFiles   */
        
        for (int i=0;i<file_list.length;i++)
            System.out.printf("\n file name: %s ,Size: %d",file_list[i].getName(),file_list[i].length()); 

        /*  file_list.length is the total number of file
         *  file_list[i].length() is the Size of file 
         *  .getName() is the name of file */        
            
    }
}

class FileType implements FilenameFilter
{
    String str=null;
    FileType(String s)
    {
        str="."+s;
    }
    public boolean accept(File dir,String name)
    {
        return name.endsWith(str);
    }

}