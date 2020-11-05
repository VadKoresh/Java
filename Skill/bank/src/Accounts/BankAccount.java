package Accounts;

public class BankAccount {

    protected double moneyCaunt;

    public BankAccount(double moneyCaunt) {
        this.moneyCaunt = moneyCaunt;
    }

    public boolean removalMoney(double sum) {
        boolean status = false;
        if (sum <= moneyCaunt) {
            moneyCaunt -= sum;
            status = true;
        } else {
            System.out.println("Ошибка! У Вас недостаточно средств, чтобы снять данную сумму");
        }
        return status;
    }

    public void addingMoney(double sum) {
        moneyCaunt += sum;
    }

    public Double getAccBank() {
        return moneyCaunt;
    }

    public boolean send(BankAccount account, double money) {
        boolean status = false;
        if (removalMoney(money)) {
            account.addingMoney(money);
            status = true;
        }
        return status;
    }
}
