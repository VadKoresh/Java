package PVD;


public class Tochki {
    private double znachenie;
    private int numberTochki;

    public Tochki(int numberTochki){
        this.numberTochki = numberTochki;
    }

    public double getZnachenie() {
        return znachenie;
    }

    public void setZnachenie(double znachenie) {
        this.znachenie = znachenie;
    }

    public int getNumberTochki() {
        return numberTochki;
    }

    public String toString(){
        return numberTochki + "-" + znachenie;
    }
}
