import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class E10_15
{
    public static void main(String args[])
    {
        new ReadFileWindow();
    }
}

class ReadFileWindow extends JFrame implements ItemListener
{
    JComboBox list;
    JTextArea showText;
    ReadFileWindow()
    {
        showText=new JTextArea(12,12);
        /* *warning* */
        list=new JComboBox();
            list.addItem("E10_01.java");
            list.addItem("E10_11.java");
        
        /* *warning* */    
        add(list,BorderLayout.NORTH);
        add(new JScrollPane(showText));
        validate();
        list.addItemListener(this);
        setBounds(120,120,500,370);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void itemStateChanged(ItemEvent e)
    {
        String file_name=(list.getSelectedItem()).toString();
        File read_file=new File(file_name);
        showText.setText(null);
        try{
            FileReader inFile=new FileReader(read_file);
            BufferedReader inBuffer=new BufferedReader(inFile);
            String s=null;
            int i=0;
            while((s=inBuffer.readLine())!=null)
                showText.append("\n"+s);
            inFile.close();
            inBuffer.close();
        }
        catch(IOException ex){
            showText.setText(ex.toString());
        }
        
    }
}