import javax.swing.*;

public class E10_1 
{
    public static void main(String args[])
    {
        JFrame frame1=new JFrame("frame1");
        JFrame frame2=new JFrame("frame2");

        /*set size of frame*/
        frame1.setBounds(60,100,188,108);
        frame2.setBounds(260,100,188,120);
        frame1.setVisible(true);
        frame2.setVisible(true);
        /**/
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /**/
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}