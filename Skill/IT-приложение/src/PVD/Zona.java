package PVD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public abstract class Zona {

    private double Smin;            //ЗАДАТЬ ЗНАЧЕНИЕв Конструкторах!!!!!!!!!!!
    private double NOMINAL_TOLHINA = 4.0;
    private double Lymda01;
    private String dateFormat = "dd.MM.yyyy";
    private double MIN_DOPYST_ZNACHENYA;
    private int[] NUMBER_TOCHEK;
    private ArrayList<Tochki> tochkis;
    private Date dateKontrol;

    public Zona(){

    }

    public void setNumberTochek(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUMBER_TOCHEK.length; i++) {
            System.out.println("Введите показания точки № " + NUMBER_TOCHEK[i]);
            Tochki tochka = new Tochki(NUMBER_TOCHEK[i]);
            tochka.setZnachenie(scanner.nextDouble());
            tochkis.add(tochka);
        }
    }

    public Double getSном(){           //номинальная толщина,мм
        return NOMINAL_TOLHINA;
    }

    public Double getLymda01(){       // общее время эксплуатации,год
        return Lymda01;
    }

    public Double getSfakt2(){         //минимальная толщина в текущий контроль, мм
        return tochkis.stream().min(Comparator.comparing(Tochki::getZnachenie)).get().getZnachenie();
    }

    public String havEKI(){            //наличие ЭКИ
        return getSfakt2() < NOMINAL_TOLHINA * 0.95 ? "да" : "нет";
    }

    public Double getSfakt1(){         //минимальная толщина в предыдущий контроль
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какая была предыдущая толщина?");
        return scanner.nextDouble();
    }

    public Integer getLymda0(){        //время эксплуатации между предыдущим контролями, год
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько лет прошло?");
        return scanner.nextInt();
    }

    public Object getWs(){  // скорость утонения, мм/год
        if (havEKI().equals("нет")){
            return "-";
        }
        return (getSfakt1() - getSfakt2()) / getLymda0();
    }

    public Integer getLymda(){          //планируемое время до следующего контроля, год
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько лет до следующей проверки?");
        return scanner.nextInt();
    }

    public Double getSmin(){        //минимально допустимая толщина в соответствии НД, мм
        return Smin;
    }

    public Object getSvSkobax(){    //расчетная минимально допустимая толщина с учетом времени до следующего контроля, мм
        if (havEKI().equals("нет")){
            return "-";
        }
        return
    }

    public void getLymdavSkobax(); //год достижения минимально допустимой толщины

    public String getOzenka();

}
