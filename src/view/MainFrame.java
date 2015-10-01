/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cirriculumviewerController.Controller;
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
    Controller controller = new Controller();
    //  private JTree tree;

    public MainFrame(List<ReportString> reportStrings) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Report");
        tree = new JTree(root);

        //create the child nodes
        int studentId = 0;
        int courseId = 0;
        DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode();
        DefaultMutableTreeNode programmNode = new DefaultMutableTreeNode();
        DefaultMutableTreeNode courseNode = new DefaultMutableTreeNode();
        for (Iterator<ReportString> i = reportStrings.iterator(); i.hasNext();) {
            ReportString rStr = i.next();
            if (rStr.getStudentId() == studentId) {

                courseNode = new DefaultMutableTreeNode(controller.getCourseById(rStr.getCourseId()).getTitle());
                for (int j = 0; j < rStr.getPracticTasksId().size(); j++) {
                    DefaultMutableTreeNode taskNode = new DefaultMutableTreeNode(controller.getPracticTaskById(rStr.getPracticTasksId().get(j).getTaskID()).getTitle());
                    courseNode.add(taskNode);
                }
                for (int j = 0; j < rStr.getTheoryTasksId().size(); j++) {
                    DefaultMutableTreeNode taskNode = new DefaultMutableTreeNode(controller.getTheoryTaskById(rStr.getTheoryTasksId().get(j).getTaskID()).getTitle());
                    courseNode.add(taskNode);
                }
                programmNode.add(courseNode);// добавляем курсы!!
                //добавляем в предыдущий нод
            } else {
                studentNode = new DefaultMutableTreeNode(controller.getStudentById(rStr.getStudentId()).getFullName());//Студент!!!!!! 
                programmNode = new DefaultMutableTreeNode(controller.getStudentById(rStr.getStudentId()).getProgrammObject().getTitle());   //Программа!!!  
                courseNode = new DefaultMutableTreeNode(controller.getCourseById(rStr.getCourseId()).getTitle()); //курс!!!!!!!! 
                for (int j = 0; j < rStr.getPracticTasksId().size(); j++) {
                    DefaultMutableTreeNode taskNode = new DefaultMutableTreeNode(controller.getPracticTaskById(rStr.getPracticTasksId().get(j).getTaskID()).getTitle());

                    courseNode.add(taskNode);
                    DefaultMutableTreeNode taskState = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getTaskState().toString());
                    taskNode.add(taskState);
                    DefaultMutableTreeNode taskBall = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getBalls());
                    taskNode.add(taskBall);
                }
                for (int j = 0; j < rStr.getTheoryTasksId().size(); j++) {
                    DefaultMutableTreeNode taskNode = new DefaultMutableTreeNode(rStr.getTheoryTasksId().get(j).getTaskID());
                    courseNode.add(taskNode);
                }

                studentId = rStr.getStudentId();
                root.add(studentNode);
                studentNode.add(programmNode);
                programmNode.add(courseNode);
                //создаем новый нод и студент ид переопределяем

            }

            add(tree);
            add(tree);
            setTitle("Cirriculum ");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setVisible(true);

        }
    }
}
