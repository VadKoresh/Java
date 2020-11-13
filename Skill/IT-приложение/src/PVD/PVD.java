package PVD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class PVD {

    private int spiralCount;
    private ArrayList<Spiral> spirals = new ArrayList<>();

    public PVD(int spiralCount) {
        this.spiralCount = spiralCount;
    }

    public void newSpiral() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < spiralCount; i++) {
            System.out.println("Введите номер спирали:");
            Spiral spiral = new Spiral(scanner.nextInt());
            spirals.add(spiral);
            spiral.setKomands();
        }
    }

    public void Otchet(){

    }
}
