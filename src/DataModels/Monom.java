package DataModels;

public class Monom {
    double coef, power;

    Monom(double coef, double power) {
        this.coef = coef;
        this.power = power;
    }

    public double getCoef() {
        return coef;
    }
    public double getPower() {
        return power;
    }
    public Monom div(Monom m) {
        Monom aux = new Monom(this.coef / m.getCoef(), power - m.getPower());
        return aux;
    }
}
