/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cirriculumviewerController.Controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
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
                DefaultMutableTreeNode taskNode;
                for (int j = 0; j < rStr.getPracticTasksId().size(); j++) {
                    taskNode = new DefaultMutableTreeNode();
                    taskNode.setUserObject(controller.getPracticTaskById(rStr.getPracticTasksId().get(j).getTaskID()));
                    taskNode = new DefaultMutableTreeNode();
                    courseNode.add(taskNode);
                    DefaultMutableTreeNode taskState = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getTaskState().toString());
                    taskNode.add(taskState);
                    DefaultMutableTreeNode taskBall = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getBalls());
                    taskNode.add(taskBall);
                }
                for (int j = 0; j < rStr.getTheoryTasksId().size(); j++) {
                    taskNode = new DefaultMutableTreeNode(controller.getTheoryTaskById(rStr.getTheoryTasksId().get(j).getTaskID()));
                    courseNode.add(taskNode);
                    DefaultMutableTreeNode taskState = new DefaultMutableTreeNode(rStr.getTheoryTasksId().get(j).getTaskState().toString());
                    taskNode.add(taskState);
                    DefaultMutableTreeNode taskBall = new DefaultMutableTreeNode(rStr.getTheoryTasksId().get(j).getBalls());
                    taskNode.add(taskBall);
                }
                programmNode.add(courseNode);// добавляем курсы!!
                //добавляем в предыдущий нод
            } else {
                studentNode = new DefaultMutableTreeNode(controller.getStudentById(rStr.getStudentId()));//Студент!!!!!! 
                programmNode = new DefaultMutableTreeNode(controller.getStudentById(rStr.getStudentId()).getProgrammObject());   //Программа!!!  
                courseNode = new DefaultMutableTreeNode(controller.getCourseById(rStr.getCourseId())); //курс!!!!!!!! 
                DefaultMutableTreeNode taskNode;
                for (int j = 0; j < rStr.getPracticTasksId().size(); j++) {
                    taskNode = new DefaultMutableTreeNode(controller.getPracticTaskById(rStr.getPracticTasksId().get(j).getTaskID()));
                    courseNode.add(taskNode);
                    DefaultMutableTreeNode taskState = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getTaskState().toString());
                    taskNode.add(taskState);
                    DefaultMutableTreeNode taskBall = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getBalls());
                    taskNode.add(taskBall);
                }
                for (int j = 0; j < rStr.getTheoryTasksId().size(); j++) {
                    taskNode = new DefaultMutableTreeNode(controller.getTheoryTaskById(rStr.getTheoryTasksId().get(j).getTaskID()));
                    courseNode.add(taskNode);
                    DefaultMutableTreeNode taskState = new DefaultMutableTreeNode(rStr.getTheoryTasksId().get(j).getTaskState().toString());
                    taskNode.add(taskState);
                    DefaultMutableTreeNode taskBall = new DefaultMutableTreeNode(rStr.getTheoryTasksId().get(j).getBalls());
                    taskNode.add(taskBall);
                }

                studentId = rStr.getStudentId();
                root.add(studentNode);
                studentNode.add(programmNode);
                programmNode.add(courseNode);
                //создаем новый нод и студент ид переопределяем

            }

        }
        final JTextArea field = new JTextArea();
        field.setLineWrap(true);
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field.setText("");
                TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                if (tp != null) {
                    String parentRez = "";
                    TreePath parentPath = tp.getParentPath();
                    if (parentPath != null) {
                        //      String parent = parentPath.toString().replaceAll("[", "");
                        parentRez = parentPath.toString().replace("]", "");

                        // System.out.println(parentPath.toString());
                    }

                    String strPath = tp.toString().replace(parentRez + ",", "");
                    String strAdd = strPath.replace("]", "");
                    field.setText(strAdd);
                } else {
                    field.setText("");
                }
            }

        });
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(tree, v, h);

        tree.setShowsRootHandles(true);

        //  tree.setRootVisible(false);
        //  tree.setEditable(true);          
        // tree.setMaximumSize(new Dimension(100, 100));
        field.setPreferredSize(new Dimension(400, 400));

        add(tree);
        add(field, new BorderLayout().LINE_END);
        setSize(400, 500);
        setTitle("Cirriculum ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        this.setResizable(false);
        setVisible(true);
    }

    public void createCorseNode(DefaultMutableTreeNode courseNode, ReportString rStr, DefaultMutableTreeNode programmNode) {
        courseNode = new DefaultMutableTreeNode(controller.getCourseById(rStr.getCourseId()).getTitle());
        DefaultMutableTreeNode taskNode;
        for (int j = 0; j < rStr.getPracticTasksId().size(); j++) {
            taskNode = new DefaultMutableTreeNode();
            taskNode.setUserObject(controller.getPracticTaskById(rStr.getPracticTasksId().get(j).getTaskID()));
            taskNode = new DefaultMutableTreeNode();
            courseNode.add(taskNode);
            DefaultMutableTreeNode taskState = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getTaskState().toString());
            taskNode.add(taskState);
            DefaultMutableTreeNode taskBall = new DefaultMutableTreeNode(rStr.getPracticTasksId().get(j).getBalls());
            taskNode.add(taskBall);
        }
        for (int j = 0; j < rStr.getTheoryTasksId().size(); j++) {
            taskNode = new DefaultMutableTreeNode(controller.getTheoryTaskById(rStr.getTheoryTasksId().get(j).getTaskID()));
            courseNode.add(taskNode);
            DefaultMutableTreeNode taskState = new DefaultMutableTreeNode(rStr.getTheoryTasksId().get(j).getTaskState().toString());
            taskNode.add(taskState);
            DefaultMutableTreeNode taskBall = new DefaultMutableTreeNode(rStr.getTheoryTasksId().get(j).getBalls());
            taskNode.add(taskBall);
        }
        programmNode.add(courseNode);
    }
}
