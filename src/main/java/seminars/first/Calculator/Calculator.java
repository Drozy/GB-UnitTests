package seminars.first.Calculator;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    /**
     * Метод вычисления суммы покупки со скидкой
     *
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки в %
     * @return сумма покупки со скидкой
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("Purchase amount must be greater than 0");
        }
        if (discountAmount < 0 | discountAmount > 100) {
            throw new IllegalArgumentException("Discount amount must be from 0 to 100");
        }
        return purchaseAmount * (100 - discountAmount) / 100;
    }
}