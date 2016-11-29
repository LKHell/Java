import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class E10_34
{
    public static void main(String args[])
    {
        new ColorWin("ColorWin");
    }
}

class ColorWin extends JFrame implements ActionListener
{
    JButton buttonOpen,showColor;
    ColorWin(String s)
    {
        setTitle(s);
        buttonOpen=new JButton("open color win");
        showColor=new JButton("ss");
        buttonOpen.addActionListener(this);
        add(buttonOpen,BorderLayout.NORTH);
        add(showColor,BorderLayout.CENTER);
        setBounds(60,60,300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e)
    {
        Color newColor=JColorChooser.showDialog(this,"border",showColor.getBackground());
        if(newColor!=null)
            showColor.setBackground(newColor);
    }
}