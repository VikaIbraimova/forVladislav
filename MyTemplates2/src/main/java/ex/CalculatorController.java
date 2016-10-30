package ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vika on 30.10.16.
 */
public class CalculatorController {
    private CalculatorModel theModel;
    private CalculatorView theView;

    public CalculatorController(CalculatorModel theModel, CalculatorView theView) {
        this.theModel = theModel;
        this.theView = theView;

        //this.theView.addCalculateListener(new CalculateListener());
        this.theView.addCalculationListener(new CalculateListener());

    }

    class CalculateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int firstNumeber,secondNumber = 0;
            try {
                firstNumeber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();
                theModel.addTwoNumbers(firstNumeber,secondNumber);
                theView.setCalcSolution(theModel.getCalculationValue());
            } catch (NumberFormatException ex) {
                theView.displayErrorMessage("You enter 2 integers");
            }
        }
    }

    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();

    }
}

