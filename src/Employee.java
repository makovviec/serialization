import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal salary;

    public Employee(String firstName, String lastName, BigDecimal salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary=" + salary;
    }
}
