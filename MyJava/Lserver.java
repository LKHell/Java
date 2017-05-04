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
  
public class Lserver 
{  
    public static void main(String[] args) 
    {  
        String info=null;   //获取来自客户端的信息
        String reply=null;  //回馈给客户端的信息
        File file =new File("./testdir/test.txt");//要传送文件的路径
        try {
            FileReader reader  =new FileReader(file);//FileReader流
            BufferedReader reader_buffer=new BufferedReader(reader);//将BufferedReader与FileReader连接  
            
            //1.建立一个服务器Socket(ServerSocket)绑定指定端口  
            ServerSocket serverSocket=new ServerSocket(8800);   
            while(true)
            {
                //2.使用accept()方法阻止等待监听，获得新连接 
                Socket socket=serverSocket.accept();  
                //3.获得输入流  
                InputStream is=socket.getInputStream();  
                BufferedReader buffer_r=new BufferedReader(new InputStreamReader(is));  
                //获得输出流  
                OutputStream os=socket.getOutputStream();  
                BufferedWriter buffer_w=new BufferedWriter(new OutputStreamWriter(os));
                //4.读取用户输入信息  
                //info=null;  
                
                while(!((info=buffer_r.readLine())==null))//逐行读取直到结束
                {  
                    System.out.println("client info："+info);  //显示来自客户端的信息
                    reply=info;  //记录
                }  
                if(reply.equals("ack"))//判断发过来的消息是否为ack
                {
                    System.out.println("ACK  "+reply);
                    while ((reply=reader_buffer.readLine())!=null)//将文件内容逐行读取
                {
                    buffer_w.write(reply); //发送文件内容
                    buffer_w.newLine();//读取新一行
                }
                buffer_w.flush();//清空buffer  
                }
                else
                {
                System.out.println("nak  "+reply);
                reply = reply.toUpperCase();//将发过来的字母大写
                buffer_w.write(reply);  //写入输出流
                buffer_w.flush();  //清空输出流
                }
                reply=null;
                // while(!((info=buffer_r.readLine())==null))
                // {  
                //     System.out.println("ack info："+info);  
                //     reply=info;  
                // }                 
                //5.关闭资源  
                buffer_w.close();  
                os.close();  
                buffer_r.close();  
                is.close();  
            }
        //抛出异常
        } catch (IOException e) {  
            e.printStackTrace();  
        }      
    }  
}  