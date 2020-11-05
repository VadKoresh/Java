import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositAccount;
import java.util.Scanner;

public class Main {

    private static String command;
    private static String account;

    public static void main(String[] args) {
        BankAccount paymentAcc = new BankAccount(10000);
        CardAccount cardAcc = new CardAccount(10000);
        DepositAccount depAcc = new DepositAccount(10000);

        for (; ; ) {
            account = selectAccount(); // Выбираем счет
            if (account.equalsIgnoreCase("Расчетный")) {
                command = operations(); //выбираем операцию
                if (command.equalsIgnoreCase("снять")) {
                    paymentAcc.removalMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Пополнить")) {
                    paymentAcc.addingMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("остаток")) {
                    System.out.println(paymentAcc.getAccBank());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("перевод")) {
                    account = selectAccount();
                    if (account.equalsIgnoreCase("Карточный")) {
                        response(paymentAcc.send(cardAcc, selectMoney()));
                    } else if (account.equalsIgnoreCase("Депозитный")) {
                        response(paymentAcc.send(depAcc, selectMoney()));
                    } else if (account.equalsIgnoreCase("Расчетный")) {
                        System.out.println("Ошибка!");
                    }
                }

                //===================================================================
            } else if (account.equalsIgnoreCase("Карточный")) {
                command = operations(); //выбираем операцию
                if (command.equalsIgnoreCase("Снять")) {
                    cardAcc.removalMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Пополнить")) {
                    cardAcc.addingMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("остаток")) {
                    System.out.println(cardAcc.getAccBank());
                } else if (command.equalsIgnoreCase("перевод")) {
                    account = selectAccount();
                    if (account.equalsIgnoreCase("Карточный")) {
                        System.out.println("Ошибка!");
                    } else if (account.equalsIgnoreCase("Депозитный")) {
                        response(cardAcc.send(depAcc, selectMoney()));
                    } else if (account.equalsIgnoreCase("Расчетный")) {
                        response(cardAcc.send(paymentAcc, selectMoney()));
                    }
                }
                //===================================================================
            } else if (account.equalsIgnoreCase("депозитный")) {
                command = operations(); //выбираем операцию
                if (command.equalsIgnoreCase("снять")) {
                    depAcc.removalMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("Пополнить")) {
                    depAcc.addingMoney(selectMoney());
                    System.out.println("================================================\n");
                } else if (command.equalsIgnoreCase("остаток")) {
                    System.out.println(depAcc.getAccBank());
                } else if (command.equalsIgnoreCase("перевод")) {
                    account = selectAccount();
                    if (account.equalsIgnoreCase("Карточный")) {
                        response(depAcc.send(cardAcc, selectMoney()));
                    } else if (account.equalsIgnoreCase("Депозитный")) {
                        System.out.println("Ошибка!");
                    } else if (account.equalsIgnoreCase("Расчетный")) {
                        response(depAcc.send(paymentAcc, selectMoney()));
                    }
                }
            }
        }
    }


    private static String selectAccount() {
        System.out.println("Выберите счет:\n1) Расчетный\n2) Депозитный\n3) Карточный");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String operations() {
        System.out.println("ВВедите комманду:\n1)Снять\n" +
            "2)Пополнить\n3)Остаток\n4)перевод");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static double selectMoney() {
        System.out.println("Введите сумму:");
        Scanner sumScan = new Scanner(System.in);
        return sumScan.nextDouble();
    }

    private static void response(boolean respon) {
        if (respon) {
            System.out.println("Перевод выполнен успешно");
        } else {
            System.out.println("Перевод не выполнен");
        }
    }
}
