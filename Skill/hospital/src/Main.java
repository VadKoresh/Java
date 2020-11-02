import java.text.DecimalFormat;

public class Main {
    public static final int PATIENT = 30;
    public static final double MAX_TEMP = 40.0;
    public static final double MIN_TEMP = 32.0;
    public static final double MAX_TEMP_HEALTHY = 36.9;
    public static final double MIN_TEMP_HEALTHY = 36.2;
    public static void main(String[] args)
    {
        double averageValue = 0.0;
        double[] temperatura = new double[PATIENT];
        int healthyCount = 0;
        DecimalFormat formatter = new DecimalFormat("#0.00°C");

        for (int i = 0; i < temperatura.length; i++){
            temperatura[i] = MIN_TEMP + (MAX_TEMP-MIN_TEMP)*Math.random();
            System.out.print(formatter.format(temperatura[i])+ " ");
            averageValue += temperatura[i];
            if (temperatura[i] >= MIN_TEMP_HEALTHY && temperatura[i] <= MAX_TEMP_HEALTHY){
                healthyCount++;
            }
        }
        System.out.println();

        averageValue = averageValue / temperatura.length;
        System.out.println("Среднее значение по больнице: " + formatter.format(averageValue));
        System.out.println("Количество здоровых пациенков = " + healthyCount);
    }

}
