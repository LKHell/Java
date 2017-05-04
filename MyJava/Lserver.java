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
        String info=null;   //��ȡ���Կͻ��˵���Ϣ
        String reply=null;  //�������ͻ��˵���Ϣ
        File file =new File("./testdir/test.txt");//Ҫ�����ļ���·��
        try {
            FileReader reader  =new FileReader(file);//FileReader��
            BufferedReader reader_buffer=new BufferedReader(reader);//��BufferedReader��FileReader����  
            
            //1.����һ��������Socket(ServerSocket)��ָ���˿�  
            ServerSocket serverSocket=new ServerSocket(8800);   
            while(true)
            {
                //2.ʹ��accept()������ֹ�ȴ���������������� 
                Socket socket=serverSocket.accept();  
                //3.���������  
                InputStream is=socket.getInputStream();  
                BufferedReader buffer_r=new BufferedReader(new InputStreamReader(is));  
                //��������  
                OutputStream os=socket.getOutputStream();  
                BufferedWriter buffer_w=new BufferedWriter(new OutputStreamWriter(os));
                //4.��ȡ�û�������Ϣ  
                //info=null;  
                
                while(!((info=buffer_r.readLine())==null))//���ж�ȡֱ������
                {  
                    System.out.println("client info��"+info);  //��ʾ���Կͻ��˵���Ϣ
                    reply=info;  //��¼
                }  
                if(reply.equals("ack"))//�жϷ���������Ϣ�Ƿ�Ϊack
                {
                    System.out.println("ACK  "+reply);
                    while ((reply=reader_buffer.readLine())!=null)//���ļ��������ж�ȡ
                {
                    buffer_w.write(reply); //�����ļ�����
                    buffer_w.newLine();//��ȡ��һ��
                }
                buffer_w.flush();//���buffer  
                }
                else
                {
                System.out.println("nak  "+reply);
                reply = reply.toUpperCase();//������������ĸ��д
                buffer_w.write(reply);  //д�������
                buffer_w.flush();  //��������
                }
                reply=null;
                // while(!((info=buffer_r.readLine())==null))
                // {  
                //     System.out.println("ack info��"+info);  
                //     reply=info;  
                // }                 
                //5.�ر���Դ  
                buffer_w.close();  
                os.close();  
                buffer_r.close();  
                is.close();  
            }
        //�׳��쳣
        } catch (IOException e) {  
            e.printStackTrace();  
        }      
    }  
}  