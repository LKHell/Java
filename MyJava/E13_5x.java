import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class E13_5x
{
    public static void main(String args[])
    {
        new JAWin();
    }
}

class JAWin extends JFrame implements ActionListener
{
    Panel center_p,north_p;
    Button button_t,button_c; //button_trangle ,button_circle
    CardLayout card;
    JAWin()
    {
        setBackground(Color.green);
        setLayout(new BorderLayout());
        center_p=new Panel();
        north_p=new Panel();
        card=new CardLayout();
        center_p.setLayout(card);
        Circle circle=new Circle();
        Trangle trangle=new Trangle();
        
        center_p.add("Trangle",trangle);
        center_p.add("Circle",circle);

        button_c=new Button("Area of circle");
        button_t=new Button("Area of trangle");
        button_c.addActionListener(this);
        button_t.addActionListener(this);

        north_p.add(button_c);
        north_p.add(button_t);

        add(center_p,BorderLayout.CENTER);
        add(north_p,BorderLayout.NORTH);

        setBounds(120,120,370,200);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button_c)
            card.show(center_p,"Circle");
        else if(e.getSource()==button_t)
            card.show(center_p,"Trangle");
    }
}
class Circle extends Panel implements ActionListener
{
    double r,area;
    TextField R=null,Area=null;
    Button button_ok;
    Circle()
    {
        R=new TextField(10);
        Area=new TextField(10);
        button_ok=new Button("OK");
        add(new Label("input R"));
        add(R);
        add(new Label("Area is "));
        add(Area);
        add(button_ok);
        button_ok.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            r=Double.parseDouble(R.getText());
            area=Math.PI*r*r;
            Area.setText(" "+area);
        }catch(Exception ee)
        {
            R.setText("set R");
        }
    }
}
class Trangle extends Panel implements ActionListener
{
    double a=0,b=0,c=0,area;
    TextField Ta=new TextField(6),
              Tb=new TextField(6),
              Tc=new TextField(6),
              TArea=new TextField(24);
              
    Button button_ok=new Button("OK");
    Trangle()
    {
        add(new Label("Set a, b ,c"));
        add(Ta);
        add(Tb);
        add(Tc);
        add(new Label("Area of trangle"));
        add(TArea);
        add(button_ok);
        button_ok.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        try{
            a=Double.parseDouble(Ta.getText());
            b=Double.parseDouble(Tb.getText());
            c=Double.parseDouble(Tc.getText());
            if(a+b>c&&a+c>b&&b+c>a)
            {
                double p=(a+b+c)/2;
                area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
                TArea.setText(""+area);
            }
            else
            {

            }
        }catch(Exception ee)
        {
            TArea.setText("error");
        }
    }
}