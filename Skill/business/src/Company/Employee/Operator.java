package Company.Employee;

import Company.Company;

public class Operator extends Manager {

    public Operator(Company company) {
        super(company);
    }

    public void setMonthSalary() {
        monthSalary = company.getFIXED_PART();
    }

}
