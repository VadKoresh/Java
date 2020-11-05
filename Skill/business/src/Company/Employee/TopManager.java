package Company.Employee;

import Company.Company;

public class TopManager extends Manager {

    private final double BONUS = 1.5;
    private final int CONDITIONS_OF_THE_BONUSES = 1000000;

    public TopManager(Company company) {
        super(company);
    }

    public void setMonthSalary() {
        this.monthSalary = (int) (company.getFIXED_PART() + getBonusSalary(company));
    }

    private double getBonusSalary(Company company) {
        if (company.getIncome() >= CONDITIONS_OF_THE_BONUSES) {
            return company.getFIXED_PART() * BONUS;
        }
        return 0;
    }
}
