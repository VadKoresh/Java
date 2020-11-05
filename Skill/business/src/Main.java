import Company.Company;
import Company.Employee.Employee;
import Company.Employee.Manager;
import Company.Employee.Operator;
import Company.Employee.TopManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Company magnit = new Company(100000000);

    public static void main(String[] args) {
        magnit.hireAll(getList());

        System.out.println("Список из 15 зарплат по убыванию:");
        for (Employee employee : magnit.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("=========================================");

        System.out.println("Список из 30 зарплат по позрастанию:");
        for (Employee employee : magnit.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }

        magnit.fire();

        System.out.println("Список из 15 зарплат по убыванию:");
        for (Employee employee : magnit.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("=========================================");

        System.out.println("Список из 30 зарплат по позрастанию:");
        for (Employee employee : magnit.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }


    }

    public static Employee setEmployee(Company company){
        Employee employee = null;
        System.out.println("Кого хотите нанять:1)Оператор\n2)Менеджер\n3)ТопМенеджер");
        Scanner scanner = new Scanner(System.in);
        String employeeStr = scanner.nextLine();
        if (employeeStr.equalsIgnoreCase("Оператор")) {
             employee = new Operator(company);
        } else if (employeeStr.equalsIgnoreCase("Менеджер")) {
            employee =  new Manager(company);
        } else if (employeeStr.equalsIgnoreCase("ТопМенеджер")) {
            employee = new TopManager(company);
        }
        return employee;
    }

    public static List<Employee> getList() {
        List<Employee> employeeList = new ArrayList<>();
        System.out.println("Необходимо нанять сотрудников: операторов, менеджеров, " +
            "топ менеджеров\nСколько операторов нанять?");
        Scanner scanner = new Scanner(System.in);
        int operator = scanner.nextInt();
        for (int i = 0; i < operator; i++) {
            employeeList.add(new Operator(magnit));
        }
        System.out.println("Сколько менеджеров нанять?");
        int manager = scanner.nextInt();
        for (int i = 0; i < manager; i++) {
            employeeList.add(new Manager(magnit));
        }
        System.out.println("Сколько Топ менеджеров нанять?");
        int topManager = scanner.nextInt();
        for (int i = 0; i < topManager; i++) {
            employeeList.add(new TopManager(magnit));
        }
        return employeeList;
    }
}
