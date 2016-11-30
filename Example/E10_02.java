import javax.swing.*;
import java.awt.event.*;
public class E10_02
{
    public static void main (String args[])
    {
        FirstWin win=new FirstWin("one window");
    }
}

class FirstWin extends JFrame 
{
    JMenuBar menubar;
    JMenu menu;
    JMenuItem item1,item2;
    FirstWin(String s)
    {
        setTitle(s);
        setSize(160,170);
        setLocation(120,120);
        setVisible(true);
        menubar = new JMenuBar();
        menu=new JMenu("file");
        item1=new JMenuItem("open",new ImageIcon("open.gif"));
        item2=new JMenuItem("save",new ImageIcon("save.gif"));

        item1.setAccelerator(KeyStroke.getKeyStroke('O'));
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);
        menubar.add(menu);
        setJMenuBar(menubar);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}