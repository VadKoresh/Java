package Clients;

public abstract class Clients {

    protected double moneyCount;

    public Clients(double moneyCount) {
        this.moneyCount = moneyCount;
    }

    public void addingMoney(double money) {
        moneyCount += money;
    }

    public void removeMoney(double money) {
        if (money <= moneyCount) {
            moneyCount -= money;
        } else {
            System.out.println("Ошибка! У Вас недостаточно сдедств!");
        }
    }

    protected double getMoneyCount() {
        return moneyCount;
    }

    public abstract void getInfo();
}
