import java.io.*;
import java.util.*;
public class File_Delete
{
    public static void main(String args[])
    {
        System.out.println("Set dir");
        Scanner inpath =new Scanner(System.in);
        String path=inpath.next();
        inpath.close();
        File dir=new File(path);
        Type_Set setting=new Type_Set("txt");
        
        File file_name[]=dir.listFiles(setting);
        for (int i=0;i<file_name.length;i++)
        {
            Date dt=new Date(file_name[i].lastModified());
            System.out.println(file_name[i].getName()+",Size: "+file_name[i].length()+" ,Time: "+dt);
        }
        
        System.out.println("\n Sum: "+file_name.length+'\n');
        
        // boolean boo_delete=false;
        // if(file_name.length>2)
        //     boo_delete=file_name[1].delete();
        // if(boo_delete)
        //     System.out.println("\n"+file_name[1].getName());
    }
}

class Type_Set implements FilenameFilter
{
    String str=null;
    Type_Set(String s)
    {
        str="."+s;
    }
    public boolean accept(File dir,String name)
    {
        return name.endsWith(str);
    }
}