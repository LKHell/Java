import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class E10_6
{
    public static void main(String args[])
    {
        new WindowBox();
    }
}

class WindowBox extends JFrame
{
    Box baseBox,box_1,box_2;
    WindowBox()
    {
        box_1=Box.createVerticalBox();
        box_1.add(new JLabel("Name:"));
        box_1.add(Box.createVerticalStrut(8));
        box_1.add(new JLabel("Email"));
        box_1.add(Box.createVerticalStrut(8));
        box_1.add(new JLabel("Occupation"));

        box_2=Box.createVerticalBox();
        box_2.add(new JTextField(16));
        box_2.add(Box.createVerticalStrut(8));
        box_2.add(new JTextField(16));
        box_2.add(Box.createVerticalStrut(8));
        box_2.add(new JTextField(16));
        
        baseBox=Box.createHorizontalBox();
        baseBox.add(box_1);
        baseBox.add(Box.createHorizontalStrut(10));
        baseBox.add(box_2);

        setLayout(new FlowLayout());
        add(baseBox);
        validate();
        setBounds(120,125,300,150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}