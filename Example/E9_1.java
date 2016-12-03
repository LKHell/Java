import java.io.*;

class FileAccept implements FilenameFilter
{
    String str=null;
    FileAccept(String s)
    {
        str="."+s;  
    }
    public boolean accept(File dir,String name)
    {
        return name.endsWith(str); /* return file which name ends with str */
    }
}

public class E9_1
{
    public static void main(String args[])
    {
        
        File dir=new File ("/Users/__your account_/java");            /*  for Windows  */
                            /* or C:/users/xxx/zzz  */
        FileAccept acceptCondition=new FileAccept("java"); /*  set file type = 'java' */
       
        File fileName[]=dir.listFiles(acceptCondition);/*  select the file endsWith 'java' */
        for(int i=0;i<fileName.length;i++)
        {
            System.out.printf("\n File Name :%s, Size: %d",fileName[i].getName(),fileName[i].length());
        }
        boolean boo=false;

        /* use for delete file  */        
        // if(fileName.length>0)
        //     boo=fileName[0].delete();

        // if(boo)
        //     System.out.println("\n File Name:"+fileName[0].getName()+" ,deleted");    
        
    }

}