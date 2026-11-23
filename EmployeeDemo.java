import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Employee Setup");
        System.out.println("----------------");

        System.out.print("Is this employee a manger? (yes/no): ");
        String isManager = input.nextLine().trim();

        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter base Salary: ");
        double baseSalary = input.nextDouble();

        double bonus = 0;
        if (isManager.equalsIgnoreCase("yes")) {
            System.out.print("Enter bonus: ");
            bonus = input.nextDouble();
        }

        Employee emp;
  if (isManager.equalsIgnoreCase("yes")) {
      emp = new Manager(name, baseSalary, bonus);
  } else {
      emp = new Employee(name, baseSalary);
  }

  System.out.println();
  System.out.println("Employee Report");
  System.out.println("-----------------");
  System.out.printf("%s's Pay: $%.2f%n", emp.getName(), emp.calculatePay());

  input.close();
  
    }
}