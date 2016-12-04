import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Menu
{
    public static void main(String args[])
    {
        Menu_win win=new Menu_win("JFrame_Win");
    }
}

class Menu_win extends JFrame 
{
    JMenuBar menubar;
    JMenu menu1,menu2;
    JMenuItem item11,item12,item21,item22;
    Menu_win(String s)
    {
        setTitle(s);
        //setSize(160,170);
        //setLocation(120,120);
        setBounds(120,120,330,230);
        setVisible(true);
        menubar=new JMenuBar();
        
        menu1=new JMenu("File");
        item11=new JMenuItem("save",new ImageIcon("open.gif"));
        item12=new JMenuItem("paste",new ImageIcon("save.gif")); 
        item11.setAccelerator(KeyStroke.getKeyStroke('O'));
        item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menu1.add(item11);
        menu1.addSeparator();
        menu1.add(item12);
        menubar.add(menu1);
        
        menu2=new JMenu("Open");
        item21=new JMenuItem("item21");
        item22=new JMenuItem("item22"); 
        menu2.add(item21);
        menu2.add(item22);
        menubar.add(menu2);
       
        setJMenuBar(menubar);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}