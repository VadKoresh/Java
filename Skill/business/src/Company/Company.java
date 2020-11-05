package Company;

import Company.Employee.Employee;
import Company.Employee.Manager;
import Company.Employee.Operator;
import Company.Employee.TopManager;

import java.util.*;

public class Company {

    private int income;
    private final int FIXED_PART = 40000;
    public List<Employee> employees = new ArrayList<>();

    public Company(int income) {
        this.income = income;
    }

    public int getFIXED_PART() {
        return FIXED_PART;
    }


    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeeList) { //нанять список сотрудников
        employees.addAll(employeeList);
    }

    public void fire() {
        System.out.println("Сколько персонала уволить ,%");
        Scanner scanner = new Scanner(System.in);
        double fireEmployee = employees.size() * (scanner.nextDouble() / 100);
        for (int i = 0; i < fireEmployee; i++) {
            employees.remove((int) Math.random() * employees.size());
        }
    }

    public int getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getMonthSalary() > o2.getMonthSalary()) {
                    return -1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {
                    return 1;
                }
                return 0;
            }
        });
        List<Employee> topSalaryStaff = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            topSalaryStaff.add(i, employees.get(i));
        }
        return topSalaryStaff;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getMonthSalary() > o2.getMonthSalary()) {
                    return 1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {
                    return -1;
                }
                return 0;
            }
        });
        List<Employee> lowestSalaryStaff = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lowestSalaryStaff.add(i, employees.get(i));
        }
        return lowestSalaryStaff;
    }
}
