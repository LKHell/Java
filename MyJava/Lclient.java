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
        
        String info=null; //��ʼ��������Ϣ
        String reply=null;//��ʼ����Ӧ��Ϣ
        try { 
            
            //1.�����ͻ���socket���ӣ�ָ��������λ�ü��˿�  
            Socket socket =new Socket("localhost",8800);  
            //2.�õ�socket��д��  
            OutputStream os=socket.getOutputStream();  
            BufferedWriter buffer_w=new BufferedWriter(new OutputStreamWriter(os));
            //������  
            InputStream is=socket.getInputStream();  
            BufferedReader buffer_r=new BufferedReader(new InputStreamReader(is));  
            //3.����������һ���Ĳ�������socket���ж�д����
            Scanner sc=new Scanner(System.in);//��ʼ��Scanner sc
            System.out.print("�����������ַ�������ack��ʼ���մ����ļ���:");//��ʾ��ʾ�ַ�
            info=sc.nextLine();//��ȡ������Ϣ  
            buffer_w.write(info);//����Ϣд��buffer
            buffer_w.flush();  //���buff
            socket.shutdownOutput(); //�ر�socket��� 
            info = info.replaceAll("\n", "");//ɾ��������Ϣ�Ļس�
            if(info.equals("ack"))//�жϴ��������Ƿ�Ϊ�ļ�
            {
                File writeFile =new File("tes2.txt"); //���ñ��ر����ļ�·���Լ�����
                FileWriter writer  =new FileWriter(writeFile);//FileWriter��
                BufferedWriter write_buffer =new BufferedWriter(writer);   //��BufferedWriter��FileReader
                System.out.println("test ack yes");
                while ((reply=buffer_r.readLine())!=null)//���ж�ȡ���͹�������Ϣ
                {
                    write_buffer.write(reply);//����Ϣд�뱾���ļ�
                    write_buffer.newLine();//��һ��
                }
                //�ر���Դ
                write_buffer.close();
                writer.close(); 
            }
            else
            {
                while ((reply=buffer_r.readLine())!=null)//���ж�ȡ���͹�������Ϣ
                {
                    //���շ���������Ӧ  
                    System.out.println("server reply��"+reply);               
                }
            }
            //4.�ر���Դ        
            buffer_r.close();  
            is.close();  
            buffer_w.close();  
            os.close();  
            socket.close();
        //�׳��쳣      
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
