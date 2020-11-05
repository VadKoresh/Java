package Clients;

public class LegalEntities extends Clients {

    private final double FEE = 0.01;

    public LegalEntities(double moneyCount) {
        super(moneyCount);
    }

    public void removeMoney(double money) {
        if (money + money * FEE <= moneyCount) {
            moneyCount -= money + money * FEE;
        } else {
            System.out.println("Ошибка! У Вас недостаточно сдедств!");
        }
    }

    @Override
    public void getInfo() {
        System.out.println("Информация по вашему счету:\nБаланс: " + getMoneyCount());
        System.out.println("Условия пополнения счета: без ограничений");
        System.out
            .println("Условия снятия денежный средств: снятие с комиссией " + FEE * 100 + " %.");
    }
}
