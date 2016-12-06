import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class OpenFile
{
    public static void main(String args[])
    {
        new FileWindow();
    }
}

class FileWindow extends JFrame implements ActionListener
{
    JButton button;
    JTextArea text;
    JFileChooser chooser;
    FileWindow()
    {
        chooser=new JFileChooser("/users/37238/java");
        button =new JButton("File");
        text=new JTextArea("show");
        button.addActionListener(this);
        add(button,BorderLayout.NORTH);
        add(new JScrollPane(text),BorderLayout.CENTER);
        setBounds(60,60,300,300);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        text.setText(null);
        int n=chooser.showOpenDialog(null);
        File file=chooser.getSelectedFile();
        try
        {
            FileReader reader=new FileReader(file);
            BufferedReader buffer=new BufferedReader(reader);
            String s=null;
            while ((s=buffer.readLine())!=null)
            {
                text.append(s+"\n");
            }
        }
        catch(IOException ee){}
    }
}