import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class E10_35
{
    public static void main(String args[])
    {
        new FileWindow();
    }
}

class FileWindow extends JFrame implements ActionListener
{
    JButton button;
    JTextArea text_area;
    JFileChooser file_chooser;
    FileWindow()
    {
        file_chooser=new JFileChooser ("C:/");
    
    button=new JButton("open File");
    text_area=new JTextArea("Show text");
    button.addActionListener(this);
    add(button,BorderLayout.NORTH);
    add(new JScrollPane(text_area),BorderLayout.CENTER);
    setBounds(60,60,300,300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        text_area.setText(null);
        int n=file_chooser.showOpenDialog(null);
        File file=file_chooser.getSelectedFile();
        try{
            FileReader readfile=new FileReader(file);
            BufferedReader in=new BufferedReader(readfile);
            String s=null;
            while((s=in.readLine())!=null)
             text_area.append(s+"\n");
        }
        catch(IOException ee){}
    }
}
