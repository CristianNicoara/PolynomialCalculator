package model;

public class Monom implements Comparable<Monom>{
    private Double coeficient;
    private Integer exponent;

    public Monom(Double coeficient, Integer exopnent) {
        this.coeficient = coeficient;
        this.exponent = exopnent;
    }


    public Double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }

    public Integer getExponent() {
        return exponent;
    }

    public Monom getMonom(){
        return this;
    }

    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        String monom = "";
        if (exponent == 0)
        {
            monom += coeficient;
        } else if(exponent == 1){
            if (coeficient == 1.0) {
                monom += "x";
            } else if (coeficient == -1.0)
                monom += "-x";
            else
                monom += coeficient + "x";
        } else {
            if (coeficient == 1.0) {
                monom += "x^" + exponent;
            } else if (coeficient == -1.0)
                monom += "-x^" + exponent;
            else
                monom += coeficient + "x^" + exponent;
        }
        return monom;
    }

    @Override
    public int compareTo(Monom monom) {
        if (this.exponent < monom.exponent)
            return 1;
        else if (this.exponent > monom.exponent)
            return -1;
        return 0;
    }
}
