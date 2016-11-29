import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class E10_23
{
    public static void main(String args[])
    {
        JFrame fr=new JFrame();
        fr.add(new LP(),BorderLayout.CENTER);
        fr.setVisible(true);
        fr.setBounds(20,12,300,300);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.validate();
    }
}

class LP extends JLayeredPane implements MouseListener,MouseMotionListener
{
    JButton button;
    JLabel label;
    int x,y,a,b,x0,y0;
    LP()
    {
        button=new JButton("button of mouse ");
        label=new JLabel("label of mouse");
        button.addMouseListener(this);
        button.addMouseMotionListener(this);
        label.addMouseListener(this);
        label.addMouseMotionListener(this);
        setLayout(new FlowLayout());
        add(label,JLayeredPane.DEFAULT_LAYER);
        add(button,JLayeredPane.DEFAULT_LAYER);
    }
    public void mousePressed(MouseEvent e)
    {
        JComponent com=null;
        com=(JComponent)e.getSource();
        setLayer(com,JLayeredPane.DRAG_LAYER);
        a=com.getBounds().x;
        b=com.getBounds().y;
        x0=e.getX();
        y0=e.getY();
    }

    public void mouseReleased(MouseEvent e)
    {
        JComponent com=null;
        com=(JComponent)e.getSource();
        setLayer(com,JLayeredPane.DEFAULT_LAYER);
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void mouseDragged(MouseEvent e)
    {
        JComponent com=null;
        if (e.getSource()instanceof JComponent)
        {
            com=(JComponent)e.getSource();
            a=com.getBounds().x;
            b=com.getBounds().y;
            x=e.getX();
            y=e.getY();
            a=a+x;
            b=b+y;
            com.setLocation(a-x0,b-y0);
        }
    }
}