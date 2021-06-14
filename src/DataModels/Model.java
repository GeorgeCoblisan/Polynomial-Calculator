package DataModels;

import java.util.ArrayList;

public class Model {
    Polinom rez = new Polinom();
    ArrayList <String> rez_final = new ArrayList<String>();

    public Model() {
        reset();
    }
    public void reset() {
        rez_final.clear();
        rez = new Polinom();
    }

    public void adunare(ArrayList<String> input1, ArrayList<String> input2) {
        Polinom p1 = new Polinom(); Polinom p2 = new Polinom();
        p1 = p1.make(input1); p2 = p2.make(input2);
        int i=0, j = 0;
        Monom m;
        int nr1 = p1.nrMonoame(), nr2 = p2.nrMonoame();

        while(i < nr1 && j < nr2) {
            double coefP1 = p1.getMonom(i).getCoef();
            double coefP2 = p2.getMonom(j).getCoef();
            double powerP1 = p1.getMonom(i).getPower();
            double powerP2 = p2.getMonom(j).getPower();
            if(powerP1 == powerP2) {
                m = new Monom(coefP1 + coefP2, powerP1);
                i++; j++;
            }
            else if(powerP1 > powerP2) {
                m = new Monom(coefP1, powerP1);
                i++;
            }
            else {
                m = new Monom(coefP2, powerP2);
                j++;
            }
            rez.adaugaMonom(m);
        }
        while (i < nr1) {
            double coefP = p1.getMonom(i).getCoef();
            double powerP = p1.getMonom(i).getPower();
            m = new Monom(coefP, powerP);
            i++;
            rez.adaugaMonom(m);
        }
        while (j < nr2) {
            double coefQ = p2.getMonom(j).getCoef();
            double powerQ = p2.getMonom(j).getPower();
            m = new Monom(-coefQ, powerQ);
            j++;
            rez.adaugaMonom(m);
        }
        rez_final.add(rez.PtoString(0));
    }

    public void scadere(ArrayList<String> input1, ArrayList<String> input2) {
        Polinom p1 = new Polinom(); Polinom p2 = new Polinom();
        p1 = p1.make(input1); p2 = p2.make(input2);
        int i = 0, j = 0;
        Monom m;
        int nr1 = p1.nrMonoame(), nr2 = p2.nrMonoame();

        while(i < nr1 && j < nr2) {
            double coefP1 = p1.getMonom(i).getCoef();
            double coefP2 = p2.getMonom(j).getCoef();
            double powerP1 = p1.getMonom(i).getPower();
            double powerP2 = p2.getMonom(j).getPower();
            if(powerP1 == powerP2) {
                m = new Monom(coefP1 - coefP2, powerP1);
                i++; j++;
            }
            else if(powerP1 > powerP2) {
                m = new Monom(coefP1, powerP1);
                i++;
            }
            else {
                m = new Monom(coefP2, powerP2);
                j++;
            }
            rez.adaugaMonom(m);
        }
        while (i < nr1) {
            double coefP = p1.getMonom(i).getCoef();
            double powerP = p1.getMonom(i).getPower();
            m = new Monom(coefP, powerP);
            i++;
            rez.adaugaMonom(m);
        }
        while (j < nr2) {
            double coefQ = p2.getMonom(j).getCoef();
            double powerQ = p2.getMonom(j).getPower();
            m = new Monom(-coefQ, powerQ);
            j++;
            rez.adaugaMonom(m);
        }
        rez_final.add(rez.PtoString(0));
    }

    public void inmultire(ArrayList<String> input1, ArrayList<String> input2) {
        Polinom p1 = new Polinom(); Polinom p2 = new Polinom();
        Polinom rez1 = new Polinom();
        p1 = p1.make(input1); p2 = p2.make(input2);
        Monom m;
        int nr1 = p1.nrMonoame(), nr2 = p2.nrMonoame();

        for (int i = 0; i < nr1; i++) {
            double coefP1 = p1.getMonom(i).getCoef();
            double powerP1 = p1.getMonom(i).getPower();
            for (int j = 0; j < nr2; j++) {
                double coefP2 = p2.getMonom(j).getCoef();
                double powerP2 = p2.getMonom(j).getPower();
                m = new Monom(coefP1 * coefP2, powerP1 + powerP2);
                rez.adaugaMonom(m);
            }
        }
        rez1 = rez1.sort(rez);
        rez_final.add(rez1.PtoString(0));
    }

    public void impartire(ArrayList<String> input1, ArrayList<String> input2) {
        Polinom p1 = new Polinom(); Polinom p2 = new Polinom();
        Polinom divP2 = new Polinom();
        p1 = p1.make(input1); p2 = p2.make(input2);
        String div = "", rest = "";
        int i = 0;
        try {
            while (p1.getMonom(0).getPower() >= p2.getMonom(0).getPower()) {
                double coefP2 = p2.getMonom(0).getCoef();
                double powerP2 = p2.getMonom(0).getPower();
                Monom m1 = new Monom(coefP2, powerP2);
                Monom m2 = p1.getMonom(i);
                double coefM = m2.div(m1).getCoef();
                double powerM = p1.getMonom(i).div(m1).getPower();
                Monom m = new Monom(coefM, powerM);
                Polinom aux = new Polinom();
                aux.adaugaMonom(m);
                divP2.adaugaMonom(m);
                Polinom aux1 = new Polinom();
                aux1 = aux1.inmultire(p2, aux);
                p1 = p1.scadere(p1, aux1);
                p1.stergeMonom(0);
            }
        }
        catch(Exception E) {};
        rest = p1.PtoString(1);
        div = divP2.PtoString(1) + " r = "+rest;
        rez_final.add(div);
    }

    public void derivare(ArrayList<String> input) {
        Polinom p = new Polinom();
        p = p.make(input);
        rez = new Polinom();
        rez_final.removeAll(rez_final);
        Monom m;
        int nr = p.nrMonoame();
        for(int i=0; i<nr; i++) {
            double coef = p.getMonom(i).getCoef();
            double power = p.getMonom(i).getPower();
            if(power != 0) {
                m = new Monom(coef * power, power - 1);
                rez.adaugaMonom(m);
            }
        }
        rez_final.add(rez.PtoString(0));
    }

    public void integrare(ArrayList<String> input) {
        Polinom p = new Polinom();
        p = p.make(input);
        rez = new Polinom();
        rez_final.removeAll(rez_final);
        Monom m;
        int nr = p.nrMonoame();
        for(int i=0; i<nr; i++) {
            double coef = p.getMonom(i).getCoef();
            double power = p.getMonom(i).getPower();
            m = new Monom(coef/(power + 1), power + 1);
            rez.adaugaMonom(m);
        }
        rez_final.add(rez.PtoString(1));
    }

    public ArrayList<String> getRez() {
        return rez_final;
    }
}
