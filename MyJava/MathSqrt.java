import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.math.*;

public class MathSqrt
{
    public static void main(String args[])
    {
        MathWindow win=new MathWindow();
    }
}
class MathWindow extends JFrame implements ActionListener
{
    JTextField inputText,showText;
    
    MathWindow()
    {
        inputText=new JTextField(10);
        showText=new JTextField(10);
        inputText.addActionListener(this);
        setLayout(new FlowLayout());
        add(inputText);
        add(showText);
        setBounds(200,200,300,200);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String s=inputText.getText();
       
        try{
            //BigInteger n=new  BigInteger(s);
            //n=n.pow(1/2);
            
            //String str=" "+n;
            int i =Integer.parseInt(s);
            int i2=Integer.parseInt(inputText.getText().trim());/*for other*/
           // double d=Math.sqrt(i);
            double d=Math.pow(i,1.0/2);
           // String double_str=""+d;
            String double_str=String.format("%.4f",d);
            
            showText.setText(double_str);
        }
        catch (NumberFormatException ee)
        {
            showText.setText("e");
            inputText.setText(null);
        }
    }
}