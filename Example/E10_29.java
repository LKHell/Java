import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class E10_29
{
    public static void main(String args[])
    {
        MVCWin win=new MVCWin();
    }
}

class Lader
{
    private double above ,bottom ,height,area;
    public double getArea()
    {
        return (above+bottom)*height/2;
    }
    public void setAbove(double above)
    {
        this.above=above;
    }
    public void setBottom(double bottom)
    {
        this.bottom=bottom;
    }
    public void setHeight(double height)
    {
        this.height=height;
    }
}

class MVCWin extends JFrame implements ActionListener
{
    Lader lader;
    JTextField t_above,t_bottom,t_height;
    JTextArea showArea;
    JButton button;
    MVCWin()
    {
        lader=new Lader();
        t_above=new JTextField(5);
        t_bottom=new JTextField(5);
        t_height=new JTextField(5);
        showArea=new JTextArea();
        button=new JButton("Compute");
        JPanel pNorth=new JPanel();
        pNorth.add(new JLabel("above:"));
        pNorth.add(t_above);
        pNorth.add(new JLabel("bottom:"));
        pNorth.add(t_bottom);
        pNorth.add(new JLabel("height:"));
        pNorth.add(t_height);
        pNorth.add(button);
        button.addActionListener(this);
        add(pNorth,BorderLayout.NORTH);
        add(new JScrollPane(showArea),BorderLayout.CENTER);
        setBounds(100,100,630,160);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        try{
            double a=Double.parseDouble(t_above.getText().trim());
            double b=Double.parseDouble(t_bottom.getText().trim());
            double c=Double.parseDouble(t_height.getText().trim());
            lader.setAbove(a);
            lader.setBottom(b);
            lader.setHeight(c);
            showArea.append("area :"+lader.getArea()+"\n");
        }
        catch(Exception ex)
        {
            showArea.append("\n"+ex+"\n");
        }
    }
}
