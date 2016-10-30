package ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameController {
    private MyFrameModel theModel;
    private MyFrameView thView;

    public MyFrameController(MyFrameModel theModel, MyFrameView thView) {
        this.theModel = theModel;
        this.thView = thView;

        this.thView.addMyFrameListener(new MyFrameListener());
    }

    class MyFrameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = "";
            try {
                //firstNumeber = theView.getFirstNumber();
                s = thView.getText();
                //theModel.addTwoNumbers(firstNumeber,secondNumber);
                theModel.addSlovo(s);
                //theView.setCalcSolution(theModel.getCalculationValue());
                thView.setTextLabel(theModel.getS());
            } catch (NumberFormatException ex) {
                //theView.displayErrorMessage("You enter 2 integers");

            }
        }
    }
}
