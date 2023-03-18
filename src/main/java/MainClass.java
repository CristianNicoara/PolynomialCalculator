import controller.CalculatorController;
import model.Polinom;
import view.CalculatorView;


public class MainClass {
    public static void main(String[] args) {
       CalculatorView calculatorView = new CalculatorView();
       CalculatorController calculatorController = new CalculatorController(calculatorView, new Polinom(),new Polinom());
    }
}
