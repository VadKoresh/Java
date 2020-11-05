package Accounts;

public class CardAccount extends BankAccount {

    private final double FEE = 0.01;

    public CardAccount(double moneyCaunt) {
        super(moneyCaunt);
    }

    public boolean removalMoney(double sum) {
        boolean status = false;
        if (sum + sum * FEE <= moneyCaunt) {
            this.moneyCaunt -= sum + sum * FEE;
            status = true;
        } else {
            System.out.println("Ошибка! У Вас недостаточно средств, чтобы снять данную сумму");
        }
        return status;
    }
}
