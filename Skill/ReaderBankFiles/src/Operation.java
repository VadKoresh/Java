public class Operation {

    private String typeOfAccount;
    private String numberAccount;
    private String currency;
    private String dateOperation;
    private String referens;
    private String descriptionOfOperations;
    private double incoming;
    private double expenses;

    public Operation(String typeOfAccount, String numberAccount, String currency,
        String dateOperation,
        String referens, String descriptionOfOperations, double incoming, double expenses) {
        this.typeOfAccount = typeOfAccount;
        this.numberAccount = numberAccount;
        this.currency = currency;
        this.dateOperation = dateOperation;
        this.referens = referens;
        this.descriptionOfOperations = descriptionOfOperations;
        this.incoming = incoming;
        this.expenses = expenses;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getReferens() {
        return referens;
    }

    public void setReferens(String referens) {
        this.referens = referens;
    }

    public String getDescriptionOfOperations() {
        return descriptionOfOperations;
    }

    public void setDescriptionOfOperations(String descriptionOfOperations) {
        this.descriptionOfOperations = descriptionOfOperations;
    }

    public double getIncoming() {
        return incoming;
    }

    public void setIncoming(double incoming) {
        this.incoming = incoming;
    }

    @Override
    public String toString() {
        return "Operation{" +
            "typeOfAccount='" + typeOfAccount + '\'' +
            ", numberAccount=" + numberAccount +
            ", currency='" + currency + '\'' +
            ", dateOperation='" + dateOperation + '\'' +
            ", referens='" + referens + '\'' +
            ", descriptionOfOperations='" + descriptionOfOperations + '\'' +
            ", incoming=" + incoming +
            ", expenses=" + expenses +
            '}';
    }

}
