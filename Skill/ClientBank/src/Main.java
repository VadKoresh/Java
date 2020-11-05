import Clients.Clients;
import Clients.Individuals;
import Clients.LegalEntities;
import Clients.IndividualEntrepreneurs;

import java.util.Scanner;

public class Main {

    private static String action;
    private static String command;

    public static void main(String[] args) {
        Clients individuals = new Individuals(10000);
        Clients legalEntities = new LegalEntities(10000);
        Clients individEntities = new IndividualEntrepreneurs(1000);

        for (; ; ) {
            action = setAction();
            if (action.equalsIgnoreCase("физлицо")) {
                command = operations();
                if (command.equalsIgnoreCase("снять")) {
                    individuals.removeMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Пополнить")) {
                    individuals.addingMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Инфо")) {
                    individuals.getInfo();
                    System.out.println("================================================\n");
                }
                //===================================================================
            } else if (action.equalsIgnoreCase("юрлицо")) {
                command = operations();
                if (command.equalsIgnoreCase("снять")) {
                    legalEntities.removeMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Пополнить")) {
                    legalEntities.addingMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Инфо")) {
                    legalEntities.getInfo();
                    System.out.println("================================================\n");
                }
                //===================================================================
            } else if (action.equalsIgnoreCase("ИП")) {
                command = operations();
                if (command.equalsIgnoreCase("снять")) {
                    individEntities.removeMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Пополнить")) {
                    individEntities.addingMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Инфо")) {
                    individEntities.getInfo();
                    System.out.println("================================================\n");
                }
                //===================================================================
            }
        }
    }

    private static String setAction() {
        System.out.println("Выберите клиента банка:\n1)Физлицо\n2)Юрлицо\n3)ИП");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String operations() {
        System.out.println("ВВедите комманду:\n1)Снять\n" +
            "2)Пополнить\n3)Инфо");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static double selectMoney() {
        System.out.println("Введите сумму:");
        Scanner sumScan = new Scanner(System.in);
        return sumScan.nextDouble();
    }
}
