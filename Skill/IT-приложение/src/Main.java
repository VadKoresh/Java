import PVD.PVD;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (;;){
            System.out.println("Добро пожаловать!\nВыберите оборудование\n1)ПВД\n2)Теплообменник");
            int oborudovanya = scanner.nextInt();
            if (oborudovanya == 1) {
                PVD pvd = new PVD(tochkiCaunt());
                System.out.println("Выберите цифру:\n1)Новая спираль\n2)отчет");
                for (;;){
                    int command = scanner.nextInt();
                    if (command == 1){
                        pvd.newSpiral();
                    }
                    else if (command == 2){
                        pvd.Otchet();
                    }
                }
        }
        }
    }

    private static int tochkiCaunt(){
        System.out.println("Кол-во точек измерения");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
