package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom{
    private List<Monom> polinom;

    public Polinom(List<Monom> polinom) {
        this.polinom = polinom;
    }

    public Polinom(){
        this.polinom = new ArrayList<Monom>();
    }

    public List<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(List<Monom> polinom) {
        this.polinom = polinom;
    }

    public int stringSplit(String string){
        int length;
        String[] a = string.split("\\+|-");
        length = a.length;
        if (a[0].equals(""))
            length--;
        return length;
    }

    public void validare(String polinom) throws Exception{
        char[] a = polinom.toCharArray();
        for (int i = 0; i < a.length; i++){
            if (a[i] == '^'){
                if (i < a.length -1) {
                    if (a[i - 1] != 'x')
                        throw new Exception("Date de intrare invalide!");
                    else if (a[i + 1] == '-') {
                        if (a[i + 2] < '0' || a[i + 2] > '9')
                            throw new Exception("Date de intrare invalide!");
                    } else {
                        if (a[i + 1] < '0' || a[i + 1] > '9')
                            throw new Exception("Date de intrare invalide!");
                    }
                } else
                    throw new Exception("Date de intrare invalide!");
            }
            if (a[i] <= 42 || a[i] == 44 || a[i] == 46 || a[i] == 47 || (a[i] >= 58 && a[i] <= 93) || (a[i] >=95 && a[i] <= 119) || (a[i] >= 121 && a[i] <= 127))
                throw new Exception("Date de intrare invalide!");
            if (a[i] == 'x'){
                if (i < a.length-1) {
                    if (a[i + 1] != '+' && a[i + 1] != '-') {
                        if (a[i + 1] != '^')
                            throw new Exception("Date de intrare invalide!");
                    }
                }
            }
        }
    }

    public Polinom buildPolinom(String polinomString) throws Exception{
        validare(polinomString);
        if (polinomString.equals(""))
            throw new Exception("Introduceti ambele polinoame!");
        Pattern pattern = Pattern.compile("([+-])?([0-9]+)?(x)?(\\^([+-]?[0-9]+))?");
        Matcher matcher = pattern.matcher(polinomString);
        List<Monom> polinom = new ArrayList<Monom>();
        int nr = 0;
        int length = stringSplit(polinomString);
        while(matcher.find()){
            Double coeficient;
            if (matcher.group(1) == null || matcher.group(1).equals("+")){
                if (matcher.group(2) == null)
                    coeficient = 1.0;
                else
                    coeficient = Double.parseDouble(matcher.group(2));
            }else{
                if (matcher.group(2) == null)
                    coeficient = -1.0;
                else
                    coeficient = -(Double.parseDouble(matcher.group(2)));
            }
            Integer exponent;
            if (matcher.group(5) == null){
                if (matcher.group(3) == null){
                    exponent = 0;
                }else {
                    exponent = 1;
                }
            }else{
                exponent = Integer.parseInt(matcher.group(5));
            }
            if (exponent < 0)
                nr++;
            if (polinom.size() + nr < length)
                polinom.add(new Monom(coeficient, exponent));
        }
        return new Polinom(polinom);
    }

     public Polinom insertIntoPolinom(Polinom polSursa, Polinom polRez){
         for(Monom monom: polSursa.getPolinom()){
             boolean q = true;
             for(Monom monom2: polRez.getPolinom()){
                 if (monom.getExponent() == monom2.getExponent()){
                     q = false;
                 }
             }
             if (q){
                 polRez.getPolinom().add(monom);
             }
         }
         return polRez;
     }

     public Polinom simplifyPolinom(Polinom polinom){
        ArrayList<Monom> listaProvizorie = new ArrayList<>();
        Polinom polinomFinal = new Polinom();
        Monom m3 = new Monom(0.0,0);
        for (Monom m: polinom.getPolinom()){
            listaProvizorie.add(new Monom(m.getCoeficient(), m.getExponent()));
        }
        for (Monom m1: polinom.getPolinom()){
            boolean q = true;
            for (Monom m2: listaProvizorie){
                if (m1.getExponent() == m2.getExponent() && m1.getCoeficient() != m2.getCoeficient()){
                    q = false;
                    if(m1.getExponent() != m3.getExponent()){
                        polinomFinal.getPolinom().add(new Monom(m1.getCoeficient() + m2.getCoeficient(), m1.getExponent()));
                        m3 = new Monom(m1.getCoeficient() + m2.getCoeficient(), m1.getExponent());
                    }
                }
            }
            if (q){
                polinomFinal.getPolinom().add(new Monom(m1.getCoeficient(), m1.getExponent()));
            }
        }

        return polinomFinal;
     }

    public String toString(){
        String polinomS = "";
        for (Monom m: polinom) {
            if (m.getCoeficient() != 0.0) {
                if (m.getCoeficient() > 0 && polinomS.length() != 0) {
                    polinomS += "+" + m.toString();
                }else{
                    polinomS += m.toString();
                }
            }
        }
        if (polinomS.equals(""))
            return "0";
        else
            return  polinomS;
    }

}