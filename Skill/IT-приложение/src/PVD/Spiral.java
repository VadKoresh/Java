package PVD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Spiral {

    private Date segodny;
    private Calendar vvodEkspluat;
    private int numberSpiral;
    private ArrayList<Tochki> allTochki = new ArrayList<Tochki>();
    private PrimoyUchactok primoyUchactok;
    private Zona_konds zonaKonds;

    public Spiral(int numberSpiral){
        this.numberSpiral = numberSpiral;
        primoyUchactok = new PrimoyUchactok();
        zonaKonds = new Zona_konds();
        vvodEkspluat.set(2000, 05, 26);
    }

    public void setTochkisZonuKonds(){
        System.out.println("Вводим значение прямого участка спирали № " + numberSpiral);
        primoyUchactok.setNumberTochek();
        System.out.println("Вводим значение зоны конденсата спирали № " + numberSpiral);
        zonaKonds.setNumberTochek();
        System.out.println("Готово");
    }

    public String getRezultZonuKondensata(){
        return "Спираль № " + numberSpiral + zonaKonds.getRezult();
    }

    public String getRezultPrimoygoUchastka(){
        return "Спираль № " + numberSpiral + primoyUchactok.getRezult();
    }

    public void setKomands(){
        Scanner scanner = new Scanner(System.in);
        for (;;){
            System.out.println("Выбирите команду:\n1)Начать измерения\n2)Показать результаты прямого участка" +
                    "\n3)Показать результаты зоны конденсата\n4)Показать все результаты\n5)следующая спираль");
            int vubor = scanner.nextInt();
            if (vubor == 1){
                setTochkisZonuKonds();
            } else if (vubor == 2){
                System.out.println(getRezultPrimoygoUchastka());
            } else if (vubor == 3){
                System.out.println(getRezultZonuKondensata());
            }else if (vubor == 5){
            break;
            }else if (vubor == 4){
                System.out.println(primoyUchactok.getAllZnacheniya());
            }
        }
    }
}
