 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;

public class E10_8{
    
    public static void main(String args[])
    {
MyWindow win =new MyWindow();
        
    }
}

class MyWindow extends JFrame
{
    JTextField text;
    PoliceStation police;
    MyWindow()
    {
        setLayout(new FlowLayout());
        text = new JTextField(10);
        police = new PoliceStation();
        add(text);
        text.addActionListener(police);
        setBounds(100,100,150,150);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class PoliceStation implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        String str=e.getActionCommand();
        System.out.println(str);
        System.out.println(str.length());
    }
}