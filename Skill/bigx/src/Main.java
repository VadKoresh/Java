public class Main {

    public static final int CARDINALITY = 9;
    public static final String X = "X";
    public static final String INTERVAL = " ";
    public static void main(String[] args) {
        String[][] bigX = new String[CARDINALITY][CARDINALITY];
        for (int i = 0; i < bigX.length; i++) {
            for (int j = 0; j < bigX[i].length; j++) {
                if (i == j) {
                    bigX[i][j] = X;
                    bigX[i][bigX[i].length - 1 - j] = X;
                    bigX[bigX[i].length - 1 - i][j] = X;
                } else if (bigX[i][j] == null) {
                    bigX[i][j] = INTERVAL;
                }
                System.out.print(bigX[i][j]);
            }
            System.out.println();
        }
    }
}