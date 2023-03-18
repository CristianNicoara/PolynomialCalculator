package controller;

import model.Operatii;
import model.Polinom;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class CalculatorController{
    private CalculatorView view;
    private Polinom polinom1;
    private Polinom polinom2;

    public CalculatorController(CalculatorView view, Polinom polinom1, Polinom polinom2){
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
        this.view = view;

        this.view.addAdunareListener(new Adunare());
        this.view.addScadereListener(new Scadere());
        this.view.addInmultireListener(new Inmultire());
        this.view.addImpartireListener(new Impartire());
        this.view.addDerivareListener(new Derivare());
        this.view.addIntegrareListener(new Integrare());
    }

    class Adunare implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            view.refresh();
            Polinom polinomRezultat;
            String polinom1String = view.getPol1Field();
            String polinom2String = view.getPol2Field();
            try {
                polinom1 = polinom1.buildPolinom(polinom1String);
                polinom2 = polinom2.buildPolinom(polinom2String);
                polinomRezultat = Operatii.adunare(polinom1, polinom2);

                Collections.sort(polinomRezultat.getPolinom());
                view.setRezField(polinomRezultat.toString());
            }catch (Exception exception){
                view.showMessage(exception.getMessage());
            }
        }
    }

    class Scadere implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.refresh();
            Polinom polinomRezultat;
            String polinom1String = view.getPol1Field();
            String polinom2String = view.getPol2Field();
            try {
                polinom1 = polinom1.buildPolinom(polinom1String);
                polinom2 = polinom2.buildPolinom(polinom2String);
                polinomRezultat = Operatii.scadere(polinom1,polinom2);

                Collections.sort(polinomRezultat.getPolinom());
                view.setRezField(polinomRezultat.toString());
            }catch (Exception exception){
                view.showMessage(exception.getMessage());
            }
        }
    }

    class Inmultire implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.refresh();
            Polinom polinomRezultat;
            String polinom1String = view.getPol1Field();
            String polinom2String = view.getPol2Field();
            try {
                polinom1 = polinom1.buildPolinom(polinom1String);
                polinom2 = polinom2.buildPolinom(polinom2String);
                polinomRezultat = Operatii.inmultire(polinom1,polinom2);
                Collections.sort(polinomRezultat.getPolinom());

                view.setRezField(polinomRezultat.toString());
            }catch (Exception exception){
                view.showMessage(exception.getMessage());
            }
        }
    }

    class Impartire implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.refresh();
            String polinom1String = view.getPol1Field();
            String polinom2String = view.getPol2Field();
            label:
            try {
                polinom1 = polinom1.buildPolinom(polinom1String);
                polinom2 = polinom2.buildPolinom(polinom2String);
                if (polinom2.toString().equals("0")){
                    view.showMessage("Impartirea la zero este imposibila!");
                    break label;
                }
                polinom1 = polinom1.simplifyPolinom(polinom1);
                polinom2 = polinom2.simplifyPolinom(polinom2);
                Collections.sort(polinom1.getPolinom());
                Collections.sort(polinom2.getPolinom());
                List<Polinom> rezultat = Operatii.impartire(polinom1,polinom2);
                view.showMessage("Rezultat: "+rezultat.get(0).toString()+"\nRest: " + rezultat.get(1).toString());
            } catch (Exception exception){
                view.showMessage(exception.getMessage());
            }
        }
    }

    class Derivare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.refresh();
            Polinom polinomRezultat;
            String polSelectat = view.getPolinomDropDown();
            String polinomS;
            label:
            try {
                if (polSelectat.equals("Polinom 1")) {
                    polinomS = view.getPol1Field();
                    if (polinomS.equals("")){
                        view.showMessage("Introduceti polinomul 1");
                        break label;
                    }
                    polinom1 = polinom1.buildPolinom(polinomS);
                    polinomRezultat = Operatii.derivare(polinom1);
                } else {
                    polinomS = view.getPol2Field();
                    if (polinomS.equals("")) {
                        view.showMessage("Introduceti polinomul 2");
                        break label;
                    }
                    polinom2 = polinom2.buildPolinom(polinomS);
                    polinomRezultat = Operatii.derivare(polinom2);
                }
                Collections.sort(polinomRezultat.getPolinom());
                view.setRezField(polinomRezultat.toString());
            }catch (Exception exception){
                exception.getMessage();
            }
        }
    }

    class Integrare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.refresh();
            Polinom polinomRezultat;
            String polSelectat = view.getPolinomDropDown();
            String polinomS;
            label:
            try {
                if (polSelectat.equals("Polinom 1")) {
                    polinomS = view.getPol1Field();
                    if (polinomS.equals("")){
                        view.showMessage("Introduceti polinomul 1");
                        break label;
                    }
                    polinom1 = polinom1.buildPolinom(polinomS);
                    polinomRezultat = Operatii.integrare(polinom1);
                } else {
                    polinomS = view.getPol2Field();
                    if (polinomS.equals("")){
                        view.showMessage("Introduceti polinomul 2");
                        break label;
                    }
                    polinom2 = polinom2.buildPolinom(polinomS);
                    polinomRezultat = Operatii.integrare(polinom2);
                }
                Collections.sort(polinomRezultat.getPolinom());
                view.setRezField(polinomRezultat.toString() + "+C");
            }catch (Exception exception){
                exception.getMessage();
            }
        }
    }

}
