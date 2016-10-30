package ex;

public class CalculatorModel {
    private int calculationValue;
    public void addTwoNumbers(int firstNumbers,int secondNumbers){
        calculationValue = firstNumbers + secondNumbers;
    }

    public int getCalculationValue(){
        return calculationValue;
    }
}

