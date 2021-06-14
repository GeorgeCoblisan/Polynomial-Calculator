package Controller;

import DataModels.Model;
import DataModels.Polinom;
import GraphicalUserInterface.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        v.addReset(new reset());
        v.CalcListener(new adunare());
        v.CalcListener(new scadere());
        v.CalcListener(new inmultire());
        v.CalcListener(new impartire());
        v.CalcListener(new derivare());
        v.CalcListener(new integrare());
    }

    class reset implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.reset();
            view.reset();
        }
    }

    class adunare implements ActionListener {
        Polinom p = new Polinom();
        public void actionPerformed(ActionEvent e) {
            String s = (String)view.op.getSelectedItem();
            if (s.equals("+")) {
                if (e.getSource() == view.calc) {
                    String[] input1 = view.getInputP1();
                    ArrayList<String> inputP1 = new ArrayList<String>();
                    String[] input2 = view.getInputP2();
                    ArrayList<String> inputP2 = new ArrayList<String>();
                    for (String i : input1)
                        inputP1.add(i);
                    for (String i : input2)
                        inputP2.add(i);
                    if(p.check(inputP1) == false || p.check(inputP2) == false)
                        view.setError();
                    else if(p.check(inputP1) == true && p.check(inputP2) == true){
                        model.adunare(inputP1, inputP2);
                        view.setRez();
                    }
                }
            }
        }
    }

    class scadere implements ActionListener {
        Polinom p = new Polinom();
        public void actionPerformed(ActionEvent e) {
            String s = (String)view.op.getSelectedItem();
            if (s.equals("-")) {
                if (e.getSource() == view.calc) {
                    String[] input1 = view.getInputP1();
                    ArrayList<String> inputP1 = new ArrayList<String>();
                    String[] input2 = view.getInputP2();
                    ArrayList<String> inputP2 = new ArrayList<String>();
                    for (String i : input1)
                        inputP1.add(i);
                    for (String i : input2)
                        inputP2.add(i);
                    if(p.check(inputP1) == false || p.check(inputP2) == false)
                        view.setError();
                    else if(p.check(inputP1) == true && p.check(inputP2) == true){
                        model.scadere(inputP1, inputP2);
                        view.setRez();
                    }
                }
            }
        }
    }

    class inmultire implements ActionListener {
        Polinom p = new Polinom();
        public void actionPerformed(ActionEvent e) {
            String s = (String)view.op.getSelectedItem();
            if (s.equals("*")) {
                if (e.getSource() == view.calc) {
                    String[] input1 = view.getInputP1();
                    ArrayList<String> inputP1 = new ArrayList<String>();
                    String[] input2 = view.getInputP2();
                    ArrayList<String> inputP2 = new ArrayList<String>();
                    for (String i : input1)
                        inputP1.add(i);
                    for (String i : input2)
                        inputP2.add(i);
                    if(p.check(inputP1) == false || p.check(inputP2) == false)
                        view.setError();
                    else if(p.check(inputP1) == true && p.check(inputP2) == true){
                        model.inmultire(inputP1, inputP2);
                        view.setRez();
                    }
                }
            }
        }
    }

    class impartire implements ActionListener {
        Polinom p = new Polinom();
        public void actionPerformed(ActionEvent e) {
            String s = (String)view.op.getSelectedItem();
            if (s.equals("/")) {
                if (e.getSource() == view.calc) {
                    String[] input1 = view.getInputP1();
                    ArrayList<String> inputP1 = new ArrayList<String>();
                    String[] input2 = view.getInputP2();
                    ArrayList<String> inputP2 = new ArrayList<String>();
                    for (String i : input1)
                        inputP1.add(i);
                    for (String i : input2)
                        inputP2.add(i);
                    if(p.check(inputP1) == false || p.check(inputP2) == false)
                        view.setError();
                    else if(p.check(inputP1) == true && p.check(inputP2) == true){
                        model.impartire(inputP1, inputP2);
                        view.setRez();
                    }
                }
            }
        }
    }

    class derivare implements ActionListener {
        Polinom p = new Polinom();
        public void actionPerformed(ActionEvent e) {
            String s = (String)view.op.getSelectedItem();
            if (s.equals("derivate")) {
                if (e.getSource() == view.calc) {
                    String[] input1 = view.getInputP1();
                    ArrayList<String> inputP1 = new ArrayList<String>();
                    String[] input2 = view.getInputP2();
                    ArrayList<String> inputP2 = new ArrayList<String>();
                    for (String i : input1)
                        inputP1.add(i);
                    for (String i : input2)
                        inputP2.add(i);
                    if(p.check(inputP1) == false || p.check(inputP2) == false)
                        view.setError();
                    else if(p.check(inputP1) == true && p.check(inputP2) == true){
                        model.derivare(inputP1);
                        view.setRez();
                        model.derivare(inputP2);
                        view.setRez();
                    }
                }
            }
        }
    }

    class integrare implements ActionListener {
        Polinom p = new Polinom();
        public void actionPerformed(ActionEvent e) {
            String s = (String)view.op.getSelectedItem();
            if (s.equals("integral")) {
                if (e.getSource() == view.calc) {
                    String[] input1 = view.getInputP1();
                    ArrayList<String> inputP1 = new ArrayList<String>();
                    String[] input2 = view.getInputP2();
                    ArrayList<String> inputP2 = new ArrayList<String>();
                    for (String i : input1)
                        inputP1.add(i);
                    for (String i : input2)
                        inputP2.add(i);
                    if(p.check(inputP1) == false || p.check(inputP2) == false)
                        view.setError();
                    else if(p.check(inputP1) == true && p.check(inputP2) == true){
                        model.integrare(inputP1);
                        view.setRez();
                        model.integrare(inputP2);
                        view.setRez();
                    }
                }
            }
        }
    }
}
