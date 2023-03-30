import java.io.Serializable;
import java.util.Arrays;

public class Company implements Serializable {
    static final int MAX_EMPLOYEES = 3;
    static int currentEmployeesNumber;
    Employee[] employees = new Employee[MAX_EMPLOYEES];

    public void addEmployee(Employee employee) {
        if (currentEmployeesNumber >= MAX_EMPLOYEES) {
            throw new ArrayIndexOutOfBoundsException("Max number of employees is achieved " + MAX_EMPLOYEES);
        }
        employees[currentEmployeesNumber] = employee;
        currentEmployeesNumber++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
