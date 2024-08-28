import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee 
{
    public String name;
    public int salary;

    public Employee(String n, int sal)
    {
        this.name = n;
        this.salary = sal;
    }
}
class EmployeeRankingBySalary implements Comparator<Employee>
{
    public int compare(Employee obj1, Employee obj2) 
    {
        return Integer.compare(obj1.salary, obj2.salary);
    }
}

public class Task06 
{
    public static void main(String[] args) 
    {
        ArrayList<Employee> company = new ArrayList<>();
        Employee e1 = new Employee("Ammad", 50000);
        Employee e2 = new Employee("Zain", 20000);
        Employee e3 = new Employee("Hamza", 90000);
        company.add(e3);
        company.add(e2);
        company.add(e1);

        System.out.println("Before Sorting: " + company);

        EmployeeRankingBySalary salaryRanking = new EmployeeRankingBySalary();
        Collections.sort(company, salaryRanking);

        System.out.println("After Sorting: " + company);
    }
}
