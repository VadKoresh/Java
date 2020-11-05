package Clients;

public class Individuals extends Clients {


    public Individuals(double moneyCount) {
        super(moneyCount);
    }

    @Override
    public void getInfo() {
        System.out.println("Информация по вашему счету:\nБаланс: " + getMoneyCount());
        System.out.println("Условия пополнения счета: без ограничений");
        System.out.println("Условия снятия денежный средств: без ограничений");
    }
}
