/*------------------Project-->> Employee Payroll System using Java OOPS Concepts-------------*/

import java.util.ArrayList;
import java.util.List;

//creating the abstract class
abstract class Employee
{
    private String name;
    private int id;

    //creating the constructor to initialize the data members of the employee class
    public Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    //using the getter concept to get the name and id
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }
    //creating one abstract method
    //that is implemented by the subclass
    public abstract double calculateSalary();

    //polymorphism
    //this function convert into the string form
    @Override
    public String toString()
    {
        return "Employee [name=" + name +", id=" + id + ", salary=" + calculateSalary() + "]";

    }
}

//creating the fullTimemployee class
//inheritance concept there we have to use
class FullTimeEmployee extends Employee
{
    private double monthlySalary;

    //creation of the constructor
    public FullTimeEmployee(String name, int id, double monthlySalary)
    {
        //super keyword refer to the immediate parent class constructor
        super(name,id);
        this.monthlySalary = monthlySalary;

    }
    @Override
    //this is the abstract method in the employee class
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

//creating the partTimeemployee class
class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id, int hoursWorked, double hourlyRate)
    {
        super(name,id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
         return hoursWorked*hourlyRate;
    }
}

//creating the payRollSystem class
class PayrollSystem
{
    //creating the employee type of the list
    private List<Employee>employeeList;

    public PayrollSystem()
    {
        employeeList = new ArrayList<>();
    }

    //add the emp into the payrollsystem
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }

    //remove the employee from the payrollsystem if the employee resign the comapny
    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;
        for(Employee employee : employeeList)
        {
            //if the employee is found
            if(employee.getId()==id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        //remove the particular emp from the list
        if(employeeToRemove!=null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    //displaying the emp details
    public void displayEmployees()
    {
        for(Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }
}

public class Main
{
    public static void main(String[]args)
    {
        PayrollSystem p = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("waskle",101,70000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("sonu",102,50000.0);
        PartTimeEmployee emp3 = new PartTimeEmployee("sara",108,50,120.0);
        FullTimeEmployee emp4 = new FullTimeEmployee("roshu",109,74000.0);
        FullTimeEmployee emp5 = new FullTimeEmployee("sukla",103,98000.0);
        PartTimeEmployee emp6 = new PartTimeEmployee("seekhar",107,60,140.0);

        //adding all the employees into the payrollsystem
        p.addEmployee(emp1);
        p.addEmployee(emp2);
        p.addEmployee(emp3);
        p.addEmployee(emp4);
        p.addEmployee(emp5);
        p.addEmployee(emp6);

        System.out.println("Initial Employee Details : ");
        p.displayEmployees();

        System.out.println("\nRemoving Employee Details");
        p.removeEmployee(107);

        System.out.println("\nRemaining Employee Details: ");
        p.displayEmployees();
    }
}
