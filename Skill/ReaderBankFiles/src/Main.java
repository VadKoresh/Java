import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String BANK_LIST = "data/movementList.csv";
    public static final DecimalFormat FORMATTER = new DecimalFormat("#0.00");

    public static void main(String[] args) {
        ArrayList<Operation> listOperations = loadOperationsFromFile();
        listOperations.sort((Comparator.comparing(Operation::getDescriptionOfOperations)));

        printIncomingAndExpenses(listOperations);
        System.out.println(resultOperations(listOperations));
    }

    public static String resultOperations(ArrayList<Operation> listOperations) {
        double amountOfExpenses = 0;
        StringBuilder stringBuilder = new StringBuilder("Расходы по организациям:\n");
        String buffer = null;
        for (Operation operation : listOperations) {
            if (operation.getExpenses() > 0) {
                amountOfExpenses += operation.getExpenses();
                if (buffer == null) {
                    buffer = operation.getDescriptionOfOperations();
                } else if (!buffer.equals(operation.getDescriptionOfOperations())) {
                    amountOfExpenses -= operation.getExpenses();
                    buffer += " - " + FORMATTER.format(amountOfExpenses) + " руб.\n";
                    stringBuilder.append(buffer);
                    buffer = operation.getDescriptionOfOperations();
                    amountOfExpenses = operation.getExpenses();
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void printIncomingAndExpenses(ArrayList<Operation> listOperations) {
        double expenses = 0;
        double incoming = 0;
        for (Operation operation : listOperations) {
            if (operation.getExpenses() > 0) {
                expenses += operation.getExpenses();
            } else if (operation.getIncoming() > 0) {
                incoming += operation.getIncoming();
            }
        }
        System.out.println("Сумма расходов: " + FORMATTER.format(expenses) + " руб.\n"
            + "Сумма доходов: " + FORMATTER.format(incoming) + " руб.\n");
    }

    public static ArrayList<Operation> loadOperationsFromFile() {
        ArrayList<Operation> operations = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(BANK_LIST));
            for (String line : lines) {
                if (line == null) {
                    break;
                }
                if (line.replaceAll("[^\"]", "").length() > 0) {
                    line = getCorrectLine(line);
                }
                String[] fragments = line.split(",");
                if (fragments.length != 8) {
                    System.out.println("Wrong line: " + line);
                    continue;
                } else if (!Character.isDigit(fragments[1].charAt(2))) {
                    continue;
                }
                operations.add(new Operation(fragments[0], fragments[1], fragments[2], fragments[3],
                    fragments[4]
                    , getCorrectOperation(fragments[5])
                    , Double.parseDouble(fragments[6])
                    , Double.parseDouble(fragments[7])));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return operations;
    }

    public static String getCorrectLine(String line) {
        String[] fragments = line.split("\"");
        StringBuilder correctLine = new StringBuilder(fragments[0]);
        correctLine.append(fragments[1].replace(",", "."));
        return correctLine.toString();

    }

    public static String getCorrectOperation(String fragments) {
        fragments = fragments.substring(fragments.lastIndexOf("\\") + 1, 69).strip();
        if (fragments.length() > 20) {
            fragments = fragments.substring(fragments.lastIndexOf("/") + 1);
            return fragments;
        }
        return fragments;
    }
}
