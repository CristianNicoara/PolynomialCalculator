package model;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class PolinomTest {
    Polinom polinom1 = new Polinom();
    Polinom polinom2 = new Polinom();
    Polinom polinomRezultat1 = new Polinom();
    Polinom polinomCat = new Polinom();
    Polinom polinomRest = new Polinom();

    @Test
    public void testAdunare() {
        String polinom1S = "20x^4+5x^12-3x+5";
        String polinom2S = "3x+5x-4x^4+12x^3";
        String polinomRezS = "5x^12+16x^4+12x^3+5x+5";
        try {
            polinom1 = polinom1.buildPolinom(polinom1S);
            polinom2 = polinom2.buildPolinom(polinom2S);
            polinomRezultat1 = polinomRezultat1.buildPolinom(polinomRezS);
        } catch (Exception exception){
            exception.getMessage();
        }
        Polinom polinomRezultat = Operatii.adunare(polinom1, polinom2);
        Collections.sort(polinomRezultat.getPolinom());

        assert (polinomRezultat1.toString().equals(polinomRezultat.toString()));
    }

    @Test
    public void testScadere() {
        String polinom1S = "20x^4+5x^12-3x+5";
        String polinom2S = "3x+5x-4x^4+12x^3";
        String polinomRezS = "5x^12+24x^4-12x^3-11x+5";
        try {
            polinom1 = polinom1.buildPolinom(polinom1S);
            polinom2 = polinom2.buildPolinom(polinom2S);
            polinomRezultat1 = polinomRezultat1.buildPolinom(polinomRezS);
        } catch (Exception exception){
            exception.getMessage();
        }
        Polinom polinomRezultat = Operatii.scadere(polinom1, polinom2);
        Collections.sort(polinomRezultat.getPolinom());

        assert (polinomRezultat1.toString().equals(polinomRezultat.toString()));
    }

    @Test
    public void testInmultire() {
        String polinom1S = "20x^4+5x^12-3x+5";
        String polinom2S = "3x+5x-4x^4+12x^3";
        String polinomRezS = "-20x^16+60x^15+40x^13-80x^8+240x^7+172x^5-56x^4+60x^3-24x^2+40x";
        try {
            polinom1 = polinom1.buildPolinom(polinom1S);
            polinom2 = polinom2.buildPolinom(polinom2S);
            polinomRezultat1 = polinomRezultat1.buildPolinom(polinomRezS);
        } catch (Exception exception){
            exception.getMessage();
        }
        Polinom polinomRezultat = Operatii.inmultire(polinom1, polinom2);
        Collections.sort(polinomRezultat.getPolinom());

        assert (polinomRezultat1.toString().equals(polinomRezultat.toString()));
    }

   @Test
    public void testImpartire(){
        String polinom1S = "2x^3-4x+5";
        String polinom2S = "x^2+1";
        String polinomCatS = "2x";
        String polinomRestS = "-6x+5";
        try {
            polinom1 = polinom1.buildPolinom(polinom1S);
            polinom2 = polinom2.buildPolinom(polinom2S);
            polinomCat = polinomCat.buildPolinom(polinomCatS);
            polinomRest = polinomRest.buildPolinom(polinomRestS);
        }catch (Exception exception){
            exception.getMessage();
        }
        List<Polinom> rezultat = Operatii.impartire(polinom1,polinom2);

        assert (polinomCat.toString().equals(rezultat.get(0).toString()) && polinomRest.toString().equals(rezultat.get(1).toString()));
    }

    @Test
    public void testDerivare() {
        String polinomS = "20x^4+5x^12-3x+5";
        String polinomRezS = "60x^11+80x^3-3";
        try {
            polinom1 = polinom1.buildPolinom(polinomS);
            polinomRezultat1 = polinomRezultat1.buildPolinom(polinomRezS);
        }catch (Exception exception){
            exception.getMessage();
        }
        Polinom polinomRezultat = Operatii.derivare(polinom1);
        Collections.sort(polinomRezultat.getPolinom());

        assert (polinomRezultat1.toString().equals(polinomRezultat.toString()));
    }

    @Test
    public void testIntegrare() {
        String polinomS = "60x^11+80x^3-3";
        String polinomRezS = "5x^12+20x^4-3x";
        try {
            polinom1 = polinom1.buildPolinom(polinomS);
            polinomRezultat1 = polinomRezultat1.buildPolinom(polinomRezS);
        }catch (Exception exception){
            exception.getMessage();
        }
        Polinom polinomRezultat = Operatii.integrare(polinom1);
        Collections.sort(polinomRezultat.getPolinom());

        assert (polinomRezultat1.toString().equals(polinomRezultat.toString()));
    }
}
