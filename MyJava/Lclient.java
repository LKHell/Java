import java.io.*;
import java.net.*;
import java.util.*;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;  
// import java.io.InputStream;  
// import java.io.InputStreamReader;  
// import java.io.OutputStream;  
// import java.net.Socket;  
// import java.net.UnknownHostException;
// import java.util.Scanner;  
  

public class Lclient {  
    public static void main(String[] args) {
        
        String info=null; //初始化发送消息
        String reply=null;//初始化回应消息
        try { 
            
            //1.建立客户端socket连接，指定服务器位置及端口  
            Socket socket =new Socket("localhost",8800);  
            //2.得到socket读写流  
            OutputStream os=socket.getOutputStream();  
            BufferedWriter buffer_w=new BufferedWriter(new OutputStreamWriter(os));
            //输入流  
            InputStream is=socket.getInputStream();  
            BufferedReader buffer_r=new BufferedReader(new InputStreamReader(is));  
            //3.利用流按照一定的操作，对socket进行读写操作
            Scanner sc=new Scanner(System.in);//初始化Scanner sc
            System.out.print("请输入任意字符（输入ack开始接收传输文件）:");//显示提示字符
            info=sc.nextLine();//获取输入消息  
            buffer_w.write(info);//将消息写入buffer
            buffer_w.flush();  //清空buff
            socket.shutdownOutput(); //关闭socket输出 
            info = info.replaceAll("\n", "");//删除输入信息的回车
            if(info.equals("ack"))//判断传过来的是否为文件
            {
                File writeFile =new File("tes2.txt"); //设置本地保存文件路径以及名字
                FileWriter writer  =new FileWriter(writeFile);//FileWriter流
                BufferedWriter write_buffer =new BufferedWriter(writer);   //将BufferedWriter与FileReader
                System.out.println("test ack yes");
                while ((reply=buffer_r.readLine())!=null)//按行读取发送过来的消息
                {
                    write_buffer.write(reply);//将消息写入本地文件
                    write_buffer.newLine();//新一行
                }
                //关闭资源
                write_buffer.close();
                writer.close(); 
            }
            else
            {
                while ((reply=buffer_r.readLine())!=null)//按行读取发送过来的消息
                {
                    //接收服务器的相应  
                    System.out.println("server reply："+reply);               
                }
            }
            //4.关闭资源        
            buffer_r.close();  
            is.close();  
            buffer_w.close();  
            os.close();  
            socket.close();
        //抛出异常      
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
