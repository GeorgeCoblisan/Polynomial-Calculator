package DataModels;

import java.util.ArrayList;
import java.util.List;

public class Polinom {
    List<Monom> m = new ArrayList<Monom>();
    int nr = 0;

    public void adaugaMonom(Monom m) {
        this.m.add(m);
        nr++;
    }
    public void stergeMonom(int i) {
        this.m.remove(i);
        nr--;
    }
    public int nrMonoame() {
        return nr;
    }
    public Monom getMonom(int i) {
        return m.get(i);
    }

    public String PtoString(int doublee) {
        String polinom = "", c = "", p = "";
        double coef;
        int coeff;
        for (Monom i : m) {
            if (doublee == 1) {
                coef = i.getCoef();
                if (i.getCoef() != 0) {
                    if (coef != 1 && coef != -1)
                        c = coef + "";
                    else if (coef == 1)
                        c = "";
                    else if (coef == -1)
                        c = "-";

                    if (i.getPower() != 0 && i.getPower() != 1)
                        p = "X^" + (int) i.getPower();
                    else if (i.getPower() == 1)
                        p = "X";
                    else
                        p = "";

                    if(coef == 1 && i.getPower() == 0)
                        c = coef + "";
                    polinom = polinom + c + p + "+";
                }
                else
                    polinom = polinom + "0" + "+";
            } else if (doublee == 0) {
                coeff = (int) i.getCoef();
                if (i.getCoef() != 0) {
                    if (coeff != 1 && coeff != -1)
                        c = coeff + "";
                    else if (coeff == 1)
                        c = "";
                    else if (coeff == -1)
                        c = "-";

                    if (i.getPower() != 0 && i.getPower() != 1)
                        p = "X^" + (int) i.getPower();
                    else if (i.getPower() == 1)
                        p = "X";
                    else
                        p = "";

                    if(coeff == 1 && i.getPower() == 0)
                        c = coeff + "";
                    polinom = polinom + c + p + "+";
                }
                else
                    polinom = polinom + "0" + "+";
            }
        }
        if(polinom != "0")
           polinom = polinom.substring(0, polinom.length() - 1) + "=0";
        return polinom;
    }

    public Polinom make(ArrayList<String> input1) {
        Polinom p1 = new Polinom();
        String regex = "[0-999]+";
        int i = 0, l1 = input1.size();
        double coef = 0, power = 0;
        boolean minus = false, plus = true, coef_done = false;
        if(input1.get(0).equals("-")) {
            minus = true; i = 1; }
        if(input1.get(0).equals("+")) {
            plus = true; i = 1; }
        if(input1.get(0).equals("X")) {
            coef = 1;
            coef_done = true;
            i=1;
        }
        while (i < l1) {
            if (input1.get(i).equals("+")) {
                plus = true; coef_done = false;
                if (power == 0)
                    if (minus == true) {
                        p1.adaugaMonom(new Monom(-coef, 1));
                        minus = false;
                    } else
                        p1.adaugaMonom(new Monom(coef, 1));
                else {
                    if (minus == true) {
                        p1.adaugaMonom(new Monom(-coef, power));
                        minus = false;
                    } else
                        p1.adaugaMonom(new Monom(coef, power));
                }
                coef = 0; power = 0; i++;
            }
            if (input1.get(i).equals("-")) {
                minus = true; coef_done = false;
                if (power == 0)
                    if (plus == true) {
                        p1.adaugaMonom(new Monom(coef, 1));
                        plus = false;
                    } else
                        p1.adaugaMonom(new Monom(-coef, 1));
                else {
                    if (plus == true) {
                        p1.adaugaMonom(new Monom(coef, power));
                        plus = false;
                    } else
                        p1.adaugaMonom(new Monom(-coef, power));
                }
                coef = 0; power = 0; i++;
            }
            if (input1.get(i).equals("=") && input1.get(i - 1).matches(regex)) {
                if(minus == true)
                    p1.adaugaMonom(new Monom(-coef, power));
                else
                    p1.adaugaMonom(new Monom(coef, power));
                i++;
            }
            if(input1.get(i).equals("=") && (input1.get(i-1).equals("X"))) {
                if(minus == true)
                    p1.adaugaMonom(new Monom(-coef, 1));
                else
                    p1.adaugaMonom(new Monom(coef, 1));
                i++;
            }
            if(input1.get(i).equals("X") && (input1.get(i-1).equals("+") || input1.get(i).equals("-"))) {
                coef = 1;
                coef_done = true;
                i++;
            }
            else if (input1.get(i).equals("X") && input1.get(i-1).matches(regex)) {
                coef_done = true; i++;  }
            if(input1.get(i).equals("^"))
                i++;
            if (coef_done == false) {
                if (input1.get(i).matches(regex)) {
                    coef = coef * 10 + Double.parseDouble(input1.get(i));
                    i++;
                }
            }
            if(coef_done == true) {
                if (input1.get(i).matches(regex)) {
                    power = power * 10 + Double.parseDouble(input1.get(i));
                    i++;
                }
            }
        }
        return p1;
    }

    public boolean check (ArrayList<String> input) {
        boolean k = true;
        int j = 1;
            String regex = "[0-999X^=+-]+";
            for (String i : input) {
                if (!i.matches(regex))
                    k = false;
                if (i.equals("X") && input.get(j).equals("X"))
                    k = false;
                if (i.equals("^") && input.get(j).equals("^"))
                    k = false;
                if (i.equals("+") && input.get(j).equals("+"))
                    k = false;
                if (i.equals("-") && input.get(j).equals("-"))
                    k = false;
                if (i.equals("=") && input.get(j).equals("="))
                    k = false;
                if (i.equals("+") && input.get(j).equals("-"))
                    k = false;
                if (i.equals("-") && input.get(j).equals("+"))
                    k = false;
                j++;
            }
        return k;
    }

    public Polinom sort(Polinom p) {
        Polinom rez = new Polinom();
        int len = p.nrMonoame();
        for(int i=0; i<len; i++) {
            double coef = p.getMonom(i).getCoef();
            double power = p.getMonom(i).getPower();
            for(int j=i+1; j<len; j++) {
                if(power == p.getMonom(j).getPower()) {
                    coef = coef + p.getMonom(j).getCoef();
                    p.stergeMonom(j);
                    len--;
                }
            }
            rez.adaugaMonom(new Monom(coef, power));
        }
        return rez;
    }

    public Polinom inmultire(Polinom p1, Polinom p2) {
        Monom m;
        int nr1 = p1.nrMonoame(), nr2 = p2.nrMonoame();
        Polinom rez = new Polinom();

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
        return rez;
    }
    public Polinom scadere(Polinom p1, Polinom p2) {
        int i = 0, j = 0;
        Monom m;
        int nr1 = p1.nrMonoame(), nr2 = p2.nrMonoame();
        Polinom rez = new Polinom();

        while (i < nr1 && j < nr2) {
            double coefP1 = p1.getMonom(i).getCoef();
            double coefP2 = p2.getMonom(j).getCoef();
            double powerP1 = p1.getMonom(i).getPower();
            double powerP2 = p2.getMonom(j).getPower();

            if (powerP1 == powerP2) {
                m = new Monom(coefP1 - coefP2, powerP1);
                i++;
                j++;
            } else if (powerP1 > powerP2) {
                m = new Monom(coefP1, powerP1);
                i++;
            } else {
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
        return rez;
    }
}

