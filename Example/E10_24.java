import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class E10_24
{
    public static void main(String args[])
    {
        new JPopupMenuWindow();
    }
}

class JPopupMenuWindow extends JFrame implements ActionListener
{
    JPopupMenu menu;
    JMenuItem i_copy ,i_cut,i_paste;
    JTextArea text;
    JPopupMenuWindow()
    {
        menu=new JPopupMenu();
        i_copy=new JMenuItem("Copy");
        i_cut=new JMenuItem("Cut");
        i_paste=new JMenuItem("Paste");
        menu.add(i_copy);
        menu.add(i_cut);
        menu.add(i_paste);
        text=new JTextArea();
        text.addMouseListener(new MouseAdapter(){
                                                    public void mousePressed (MouseEvent e){
                                                        if(e.getModifiers()==InputEvent.BUTTON3_MASK)
                                                            menu.show(text,e.getX(),e.getY());
                                                    }
                                                });
        add(new JScrollPane(text),BorderLayout.CENTER);
        i_copy.addActionListener(this);
        i_cut.addActionListener(this);
        i_paste.addActionListener(this);
        setBounds (120,120,200,220);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {        
        if(e.getSource()==i_copy)  text.copy();
        if(e.getSource()==i_cut)   text.cut();
        if(e.getSource()==i_paste) text.paste();
    }


}