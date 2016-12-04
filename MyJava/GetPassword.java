import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GetPassword
{
    public static void main(String args[])
    {
        new PASWin();
    }
}

class PASWin extends JFrame implements ActionListener
{
    JTextField show_text,source_text;
    JPasswordField password_text;
    PASWin()
    {
        show_text=new JTextField(10);
        password_text=new JPasswordField(10);
        show_text.addActionListener(this);
        password_text.addActionListener(this);
        setLayout(new FlowLayout());
        add(show_text);
        add(password_text);

        setBounds(200,200,300,100); /*x,y,width,height */
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public  void actionPerformed(ActionEvent e)
    {
        source_text=(JTextField)e.getSource();
        if(show_text==source_text)
        {
            this.setTitle(show_text.getText());
        }
        else if (password_text==source_text);
        {
            char c[]=password_text.getPassword();
            show_text.setText(new String(c));
        }
    }
}