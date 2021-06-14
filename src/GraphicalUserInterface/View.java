package GraphicalUserInterface;

import DataModels.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {

    Model model;
    JFrame frame = new JFrame();
    JPanel panelLeft = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelRight = new JPanel();
    JTextField p1 = new JTextField();
    JTextField p2 = new JTextField();
    JLabel tp1 = new JLabel("Enter the first polynomial");
    JLabel tp2 = new JLabel("Enter the second polynomial");
    JLabel text_result = new JLabel("Result");
    JLabel text_op = new JLabel("Select operation");
    JTextArea rez = new JTextArea(5, 20);
    public JButton calc = new JButton("Compute");
    JButton reset = new JButton("Reset");
    String operations[] = {"+", "-", "*", "/", "derivate", "integral"};
    public JComboBox op = new JComboBox(operations);

    public View(Model model) {
        this.model = model;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("Polynomial Calculator");

        rez.setEditable(false);

        panelLeft.setLayout(new GridLayout(4, 1));
        panelLeft.add(tp1);
        panelLeft.add(p1);
        panelLeft.add(tp2);
        panelLeft.add(p2);

        panelCenter.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCenter.add(text_op);
        panelCenter.add(op);
        panelCenter.add(calc);
        panelCenter.add(reset);


        panelRight.setLayout(new GridLayout(4, 3));
        panelRight.add(text_result);
        panelRight.add(rez);

        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelRight, BorderLayout.EAST);
    }

    public void CalcListener(ActionListener mal) {
        calc.addActionListener(mal);
    }
    public void reset() {
        rez.setText("");
        p1.setText("");
        p2.setText("");
    }
    public void addReset(ActionListener mal) {
        reset.addActionListener(mal);
    }
    public String[] getInputP1() {
        String txt = p1.getText();
        String[] content = txt.split("");
        return content;
    }
    public String[] getInputP2() {
        String txt = p2.getText();
        String[] content = txt.split("");
        return content;
    }
    public void setRez() {
        for(String i: model.getRez())
            rez.append(i + "");
        rez.append("\n");
    }
    public void setError() {
        rez.append("Date invalide! Introduceti 2 polinoame de forma: aX^2+bX+c=0");
    }
}

