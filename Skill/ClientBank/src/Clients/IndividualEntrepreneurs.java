package Clients;

public class IndividualEntrepreneurs extends Clients {

    private final double FEE_MORE_RESERVATION_MONEY = 0.005;
    private final double FEE_LESS_RESERVATION_MONEY = 0.01;
    private final double RESERVATION_MONEY = 1000.0;

    public IndividualEntrepreneurs(double moneyCount) {
        super(moneyCount);
    }

    public void addingMoney(double money) {
        if (money < RESERVATION_MONEY) {
            moneyCount += money - money * FEE_LESS_RESERVATION_MONEY;
        } else {
            moneyCount += money - money * FEE_MORE_RESERVATION_MONEY;
        }
    }

    @Override
    public void getInfo() {
        System.out.println("Информация по вашему счету:\nБаланс: " + getMoneyCount());
        System.out.println(
            "Условия пополнения счета:  пополнение с комиссией " + FEE_LESS_RESERVATION_MONEY * 100
                + " " +
                "%, если сумма меньше " + RESERVATION_MONEY + " рублей.\n" +
                "И с комиссией " + FEE_MORE_RESERVATION_MONEY * 100
                + " %, если сумма больше либо равна "
                + RESERVATION_MONEY + " рублей");
        System.out.println("Условия снятия денежный средств: без ограничений");
    }
}
