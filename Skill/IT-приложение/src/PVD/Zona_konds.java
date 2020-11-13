package PVD;

import java.text.SimpleDateFormat;
import java.util.*;

public class Zona_konds{

    private final double MIN_DOPYST_ZNACHENYA = 1.87;


    public Zona_konds(){
        dateKontrol = new Date();

    }

    public Double getMinIzmerZnach(){
        return tochkis.stream().min(Comparator.comparing(Tochki::getZnachenie)).get().getZnachenie();
    }

    public int getNumberTochek(){
        return NUMBER_TOCHEK.length;
    }

    public Double getMinDopustZnach(){
        return MIN_DOPYST_ZNACHENYA;
    }

    public String getDateKontrol(){
        return new SimpleDateFormat(dateFormat).format(dateKontrol);
    }

    public String getRezult(){
        return "\t| Минимально допустимое значение: " + getMinDopustZnach()
                + "\t| Минимальное измеренное значение: " + getMinIzmerZnach()
                + "\t| Оценка качества: " + getOzenka()
                + "\t| Дата контроля: " + getDateKontrol();
    }

    public String getAllZnacheniya(){
        String rezult = "";
        for (Tochki tochki : tochkis){
            rezult += tochki.toString() + "\t";
        }
        return rezult;
    }


}
