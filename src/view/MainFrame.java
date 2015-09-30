/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import model.ReportString;

/**
 *
 * @author Elena_Kholkina
 */
public class MainFrame extends JFrame {

    private JTree tree;
  //  private ArrayList<ReportString> reportStrings ; 

    public MainFrame(List<ReportString> reportStrings) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Report");
        tree = new JTree(root);
        //create the child nodes
        int studentId=0;
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode();
        for (Iterator <ReportString> i = reportStrings.iterator(); i.hasNext();){
        ReportString rStr = i.next(); 
        if (rStr.getStudentId() == studentId){
        studentNode.add(new DefaultMutableTreeNode(rStr.getCourseId()));
            //добавляем в предыдущий нод
        }else{
        studentNode = new DefaultMutableTreeNode(rStr.getStudentId());
        studentId=rStr.getStudentId();
        root.add(studentNode);
            //создаем новый нод и студент ид переопределяем
        }}
        
        /*DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Student 1");
        DefaultMutableTreeNode courseNole = new DefaultMutableTreeNode("course 1"); 
        
        vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
        vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
        vegetableNode.add(new DefaultMutableTreeNode("Tomato   "));
        vegetableNode.add(new DefaultMutableTreeNode("Potato"));
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Student 2");
        fruitNode.add(new DefaultMutableTreeNode("Banana"));
        fruitNode.add(new DefaultMutableTreeNode("Mango"));
        fruitNode.add(new DefaultMutableTreeNode("Apple"));
        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
        fruitNode.add(new DefaultMutableTreeNode("Orange"));
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);*/

        //create the tree by passing in the root node
      //  tree = new JTree(root);
        add(tree);

        setTitle("Cirriculum ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    
      
    }
    
}
