package Accounts;

import java.util.Calendar;

public class DepositAccount extends BankAccount {

    private final int LIMIT_MONTH = 1;

    private Calendar thisDay = Calendar.getInstance();

    public DepositAccount(double moneyCaunt) {
        super(moneyCaunt);
    }

    public boolean removalMoney(double sum) {
        boolean status = false;
        if (limit()) {
            System.out.println("Ошибка! 1 месяц с последнего снятия средст еще не прошли.");
        } else if (sum <= moneyCaunt) {
            moneyCaunt -= sum;
            thisDay.add(Calendar.MONTH, LIMIT_MONTH);
            status = true;
        } else {
            System.out.println("Ошибка! У Вас недостаточно средств, чтобы снять данную сумму");
        }
        return status;
    }

    private boolean limit() {
        Calendar thisDay1 = Calendar.getInstance();
        return thisDay1.getTime().before(this.thisDay.getTime());
    }
}
