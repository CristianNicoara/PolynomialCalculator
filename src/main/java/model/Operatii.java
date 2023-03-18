package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operatii {

    public static Polinom adunare(Polinom polinom1, Polinom polinom2){
        polinom1 = polinom1.simplifyPolinom(polinom1);
        polinom2 = polinom2.simplifyPolinom(polinom2);
        Polinom polinomRezultat = new Polinom();
        for(Monom monom: polinom1.getPolinom()){
            for (Monom monom2: polinom2.getPolinom()){
                if (monom.getExponent() == monom2.getExponent()){
                    polinomRezultat.getPolinom().add(new Monom(monom.getCoeficient()+monom2.getCoeficient(), monom.getExponent()));
                }
            }
        }
        polinomRezultat = polinomRezultat.insertIntoPolinom(polinom1,polinomRezultat);
        polinomRezultat = polinomRezultat.insertIntoPolinom(polinom2,polinomRezultat);

        return polinomRezultat;
    }

    public static Polinom scadere(Polinom polinom1, Polinom polinom2){
        polinom1 = polinom1.simplifyPolinom(polinom1);
        polinom2 = polinom2.simplifyPolinom(polinom2);
        Polinom polinomRezultat = new Polinom();
        for(Monom monom: polinom1.getPolinom()){
            for (Monom monom2: polinom2.getPolinom()){
                if (monom.getExponent() == monom2.getExponent()){
                    polinomRezultat.getPolinom().add(new Monom(monom.getCoeficient() - monom2.getCoeficient(), monom.getExponent()));
                }
            }
        }
        for (Monom m: polinom2.getPolinom()){
            m.setCoeficient(-m.getCoeficient());
        }
        polinomRezultat = polinomRezultat.insertIntoPolinom(polinom1,polinomRezultat);
        polinomRezultat = polinomRezultat.insertIntoPolinom(polinom2,polinomRezultat);

        return polinomRezultat;
    }

    public static Polinom inmultire(Polinom polinom1, Polinom polinom2){
        polinom1 = polinom1.simplifyPolinom(polinom1);
        polinom2 = polinom2.simplifyPolinom(polinom2);
        Polinom polinomRezultat = new Polinom();
        for (Monom m1: polinom1.getPolinom()){
            for (Monom m2: polinom2.getPolinom()){
                polinomRezultat.getPolinom().add(new Monom(m1.getCoeficient() * m2.getCoeficient(), m1.getExponent() + m2.getExponent()));
            }
        }

        polinomRezultat = polinomRezultat.simplifyPolinom(polinomRezultat);

        return polinomRezultat;
    }

    public static List<Polinom> impartire(Polinom polinom1, Polinom polinom2){
        List<Polinom> rezultat = new ArrayList<>();
        Polinom cat = new Polinom();
        while (polinom1.getPolinom().get(0).getExponent() >= polinom2.getPolinom().get(0).getExponent()){
            Monom m1 = polinom1.getPolinom().get(0).getMonom();
            Monom m2 = polinom2.getPolinom().get(0).getMonom();
            Double coeficient = m1.getCoeficient() / m2.getCoeficient();
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            coeficient = Double.parseDouble(df.format(coeficient).replaceAll(",",""));
            Monom m3 = new Monom(coeficient, m1.getExponent() - m2.getExponent());
            cat.getPolinom().add(m3);
            Polinom aux = new Polinom();
            //Inmultirea
            for (Monom monom1: polinom2.getPolinom()){
                aux.getPolinom().add(new Monom(monom1.getCoeficient() * m3.getCoeficient(), monom1.getExponent() + m3.getExponent()));
            }
            Polinom aux2 = Operatii.scadere(polinom1,aux);
            aux2.getPolinom().remove(0);
            polinom1.setPolinom(aux2.getPolinom());
            Collections.sort(polinom1.getPolinom());
            if (polinom1.getPolinom().size() == 0)
                break;
        }
        rezultat.add(cat);
        rezultat.add(polinom1);

        return rezultat;
    }

    public static Polinom derivare(Polinom polinom){
        Polinom polinomRezultat = new Polinom();
        polinom = polinom.simplifyPolinom(polinom);
        for (Monom m:polinom.getPolinom()){
            if (m.getExponent() != 0) {
                polinomRezultat.getPolinom().add(new Monom(m.getCoeficient() * m.getExponent(), m.getExponent() - 1));
            }
        }

        return polinomRezultat;
    }

    public static Polinom integrare(Polinom polinom){
        Polinom polinomRezultat = new Polinom();
        polinom = polinom.simplifyPolinom(polinom);
        for (Monom m:polinom.getPolinom()) {
            Double coeficient = m.getCoeficient() * (1.0 / (m.getExponent() + 1));
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            coeficient = Double.parseDouble(df.format(coeficient).replaceAll(",",""));
            Integer exponent = m.getExponent() + 1;
            polinomRezultat.getPolinom().add(new Monom(coeficient, exponent));
        }

        return polinomRezultat;
    }
}
