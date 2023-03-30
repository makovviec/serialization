import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class CompanyApp {
    static final String FILE_NAME = "Employee.info";
    private static final int READ_FROM_USER = 1;
    private static final int READ_FROM_FILE = 2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Wprowadzanie pracownika od użytkownika " + READ_FROM_USER);
        System.out.println("Pokaż listę pracowników " + READ_FROM_FILE);

        int input = scanner.nextInt();
        scanner.nextLine();
        if (input == READ_FROM_USER) {
            Company company = createCompany();
            fileWriter(company);
        } else if (input == READ_FROM_FILE) {
            try {
                Company company = fileReader();
                System.out.println(company);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("Błąd odczytu pliku " + e);
            }
        }

        scanner.close();
    }

    static Company fileReader() throws IOException, ClassNotFoundException {
        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
            return (Company) ois.readObject();
        }
    }

    static void fileWriter(Company company) {
        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ) {
            oos.writeObject(company);
            System.out.println("Zapisano do pliku");
        } catch (IOException e) {
            throw new RuntimeException("Błąd zapisu " + e);
        }
    }

    static Company createCompany() {
        Company company = new Company();
        for (int i = 0; i < Company.MAX_EMPLOYEES; i++) {
            System.out.println("Podaj imie pracownika " + (Company.currentEmployeesNumber + 1));
            String firstName = scanner.nextLine();
            System.out.println("Podaj nazwisko pracownika " + (Company.currentEmployeesNumber + 1));
            String lastName = scanner.nextLine();
            System.out.println("Pęsja pracownika " + (Company.currentEmployeesNumber + 1));
            BigDecimal salary = scanner.nextBigDecimal();
            scanner.nextLine();
            company.addEmployee(new Employee(firstName, lastName, salary));
        }
        return company;
    }
}
