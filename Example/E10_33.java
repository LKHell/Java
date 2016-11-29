import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.regex.*;

public class E10_33
{
    public static void main(String args[])
    {
        new Dwindow();
    }
}

class Dwindow extends JFrame implements ActionListener
{
    JButton inNumber;
    JTextArea save;
    Pattern p;
    Matcher m;
    Dwindow()
    {
        inNumber=new JButton("input button");
        inNumber.addActionListener(this);
        save=new JTextArea(12,16);
        add(inNumber,BorderLayout.NORTH);
        add(new JScrollPane(save),BorderLayout.CENTER);
        p=Pattern.compile("\\D+");
        setBounds(60,60,300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        String str=JOptionPane.showInputDialog(null,"input string","information_input",JOptionPane.INFORMATION_MESSAGE);
        if(str!=null)
        {
            m=p.matcher(str);
            while(m.find())
            {
                JOptionPane.showMessageDialog(this,"error","information_error",JOptionPane.WARNING_MESSAGE);
                str=JOptionPane.showInputDialog(null,"please input string ");
                m=p.matcher(str);
            }
            int n=JOptionPane.showConfirmDialog(this,"confirm","information_comfirm",JOptionPane.YES_NO_OPTION);
            if (n==JOptionPane.YES_NO_OPTION)
                save.append("\n"+str);
        }
    }
}