package Company.Employee;

import Company.Company;

public class Manager implements Employee {

    public int monthSalary;
    public int getFIXED_PART; //фиксированная зп
    public Company company;
    private final double BONUS = 0.05;
    private final int MIN_INCOME = 115000;
    private final int MAX_INCOME = 140000;

    public Manager(Company company) {
        this.company = company;
        setMonthSalary();
    }

    protected void setMonthSalary() {
        monthSalary = (int) (company.getFIXED_PART() + getIncome() * BONUS);
    }

    private int getIncome() {  //прибыль которую принес менеджер
        return (int) (Math.random() * ((MAX_INCOME - MIN_INCOME) + 1) + MIN_INCOME);
    }

    @Override
    public int getMonthSalary() {
        return monthSalary;
    }
}
