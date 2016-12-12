import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class N35
{
    public static void main(String args[])
    {
        new FileWin();
    }
}

class FileWin extends JFrame implements ActionListener
{
    JButton button;
    JTextArea text;
    JFileChooser file_chooser;
    JMenuBar menubar;
    JMenu menu1,menu2;
    JMenuItem item1,item2;
    FileWin()
    {
        setTitle("sss");
        file_chooser=new JFileChooser("C:/");
        button =new JButton("open file");
        text=new JTextArea();
        
        add(button,BorderLayout.NORTH);
        
        add(new JScrollPane(text),BorderLayout.CENTER);

        menubar=new JMenuBar();
        menu1=new JMenu("OPen");
        menu2=new JMenu("other");
        
        item1=new JMenuItem("item1");

        item2=new JMenuItem("item2");
        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menubar.add(menu1);
        menubar.add(menu2);

        setJMenuBar(menubar);
        button.addActionListener(this);        
        item1.addActionListener(this);
        setBounds(60,100,300,300);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        text.setText(null);
        int n=file_chooser.showOpenDialog(null);
        if (n==JFileChooser.APPROVE_OPTION){
        File file=file_chooser.getSelectedFile();
        try
        {
            FileReader reader=new FileReader(file);
            BufferedReader buffer=new BufferedReader(reader);
            String str=null;
            if(e.getSource()==item1)
                text.append("ss\n");
            if(e.getSource()==button)
                setTitle("from button");
            while((str=buffer.readLine())!=null)
            {
                text.append(str+"\n");

            }
           
        } catch(IOException ee){
                
        }}
    }
}