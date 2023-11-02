import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IVali {
    double f1(Employee e);
    String f2(Employee e);
}

class EmployeeList {
    
    private List<Employee> employees;
    
    public EmployeeList() {
        employees = new ArrayList<>();
    }
    
    public void AddE(Employee employee) {
        employees.add(employee);
    }
    
    public void inputList(int n, EmployeeList employeeList) {
        Scanner scanner = new Scanner(System.in);
        Validate validator = new Validate();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Employee " + (i + 1) + " details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            
            scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            
            Employee employee = new Employee(name, salary, phone);
            salary = validator.f1(employee);
            phone = validator.f2(employee);
            Employee newemployee = new Employee(name, salary, phone);
            
            employeeList.AddE(newemployee);
        }
    }
    
    public void displayEmployeeList() {
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Phone: " + employee.getPhone());
        }
    }
}

class Employee {
    
    private String Name;
    private double Salary;
    private String Phone;
    
    public Employee(String Name, double Salary, String Phone) {
        this.Name = Name;
        this.Salary = Salary;
        this.Phone = Phone;
    }
    
    public String getName() {
        return Name;
    }
    
    public double getSalary() {
        return Salary;
    }
    
    public String getPhone() {
        return Phone;
    }
    
    public void displayInfomation() {
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("Phone: " + getPhone());
    }
}

class Validate implements IVali {
    
    @Override
    public double f1(Employee e) {
        if (e.getSalary() >= 2000) {
            return e.getSalary() + 0.1 * e.getSalary();
        } else {
            return e.getSalary();
        }
    }
    
    @Override
    public String f2(Employee e) {
        String phone = e.getPhone();
        String result = "";
        
        if (phone.length() % 3 != 0) {
            return "Invalid phone number";
        }
        
        for (int i = 0; i < phone.length(); i += 3) {
            result += phone.substring(i, i + 3) + "-";
        }
        return result.substring(0, result.length() - 1);
    }
    
    public void InfoValid(Employee employee) {
        System.out.println("---------------------------");
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary: " + f1(employee));
        System.out.println("Phone: " + f2(employee));
    }
}

public class BTTH2 {
    
    public static void main(String[] args) {
        Employee employee = new Employee("Tran Khai", 2500, "01235789");
        Validate validator = new Validate();
        
        employee.displayInfomation();
        validator.InfoValid(employee);
        
        Scanner sc = new Scanner(System.in);
        EmployeeList ems = new EmployeeList();
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        ems.inputList(n, ems);
        System.out.println("---------------------------");
        ems.displayEmployeeList();
    }
}
