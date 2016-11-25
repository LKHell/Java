import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;

public class E10_10
{
    public static void main(String args[])
    {
        MathWindow win=new MathWindow();
    }
}

class MathWindow extends JFrame 
{
    JTextField inputText, showText;
    MathWindow()
    {
        inputText=new JTextField(10);
        showText= new JTextField(10);
        inputText.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    String s=inputText.getText();
                    try {
                        BigInteger n=new BigInteger(s);
                        n=n.pow(2);
                        showText.setText(n.toString());
                    }catch(NumberFormatException ee)
                    {
                        showText.setText("input integer");
                        inputText.setText(null);
                    }
                }
            });
        setLayout(new FlowLayout());
        add(inputText);
        add(showText);
        setBounds(100,200,260,190);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
