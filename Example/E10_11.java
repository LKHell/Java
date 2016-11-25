import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class E10_11
{
    public static void main(String args[])
    {
        EditWindow win=new EditWindow("hello edit");
    }
}

class EditWindow extends JFrame implements ActionListener
{
    JMenuBar menubar;
    JMenu menu;
    JSplitPane splitPane;
    JMenuItem i_copy,i_cut,i_paste;
    JTextArea text1,text2;
    EditWindow(String s)
    {
        setTitle(s);
        setSize(260,270);
        setLocation(120,120);
        setVisible(true);
        menubar=new JMenuBar();
        menu=new JMenu("Edit");
        i_copy=new JMenuItem("Copy");
        i_cut=new JMenuItem("Cut");
        i_paste=new JMenuItem("Paste");

        menu.add(i_copy);
        menu.add(i_cut);
        menu.add(i_paste);
        menubar.add(menu);

        setJMenuBar(menubar);

        text1=new JTextArea();
        text2=new JTextArea();

        splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,text1,text2);
        splitPane.setDividerLocation(120);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(splitPane,BorderLayout.CENTER);
        validate();
        i_copy.addActionListener(this);
        i_cut.addActionListener(this);
        i_paste.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==i_copy)
            text1.copy();
        else if(e.getSource()==i_cut)
            text1.cut();
        else if(e.getSource()==i_paste)
            text2.paste();
    }
}