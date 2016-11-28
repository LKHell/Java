import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import javax.swing.event.*;

public class E10_17
{
    public static void main(String args[])
    {
        new TreeWin();
    }
}

class Student
{
    String name;
    double score;
    Student(String name,double score)
    {
        this.name=name;
        this.score=score;
    }
    /* -------- */
    public String toString()
    {
        return name;
    }
    /* -------- */
}

class TreeWin extends JFrame implements TreeSelectionListener
{
    JTree tree;
    JTextArea show_text;
    TreeWin()
    {
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("Collage");
        DefaultMutableTreeNode node=new DefaultMutableTreeNode("Student");
        DefaultMutableTreeNode node_1=new DefaultMutableTreeNode(new Student("LiA",99));
        DefaultMutableTreeNode node_2=new DefaultMutableTreeNode(new Student("ZhangB",92));
        DefaultMutableTreeNode node_3=new DefaultMutableTreeNode(new Student("ChenC",74));

        root.add(node);
        node.add(node_1);
        node.add(node_2);
        node.add(node_3);

        tree=new JTree(root);
        tree.addTreeSelectionListener(this);
        show_text=new JTextArea();
        setLayout(new GridLayout(1,2));
        add(new JScrollPane(tree));
        add(new JScrollPane(show_text));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(80,80,300,300);
        validate();

    }
    public void valueChanged(TreeSelectionEvent e)
    {
        DefaultMutableTreeNode node=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        if(node.isLeaf())
        {
            Student s=(Student)node.getUserObject();
            show_text.append(s.name+","+s.score+"\n");
        }else{
            show_text.setText(null);
        }
    }
}