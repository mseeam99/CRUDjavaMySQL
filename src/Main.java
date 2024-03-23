import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        functionSQLInterface object = new functionSQLImplementation();
        System.out.println("Welcome to Employee Management Application");

        String name;
        int id;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                    "1. Add Employee\n" +
                            "2. Show All Employees\n" +
                            "3. Update Employee\n" +
                            "4. Delete Employee\n" +
                            "5. Clear Table\n" +
                            "6. Exit\n");

            System.out.println("Enter Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Employee emp = new Employee();
                    boolean isValidInput = false;
                    do {
                        System.out.println("Enter ID: ");
                        if (sc.hasNextInt()) {
                            id = sc.nextInt();
                            emp.setId(id);
                            isValidInput = true;
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer for ID.");
                            sc.next(); // Clear the invalid input
                        }
                    } while (!isValidInput);


                    isValidInput = false;
                    do {
                        System.out.println("Enter Name: ");
                        if (sc.hasNext()) {
                            String tempName = sc.next();
                            if (tempName.matches("[a-zA-Z]+")) { // Check if the input contains only letters
                                name = tempName;
                                emp.setName(name);
                                isValidInput = true;
                            } else {
                                System.out.println("Invalid input! Please enter a valid string for Name.");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a valid string for Name.");
                            sc.next(); // Clear the invalid input
                        }
                    } while (!isValidInput);


                    isValidInput = false;
                    do {
                        System.out.println("Enter Salary: ");
                        if (sc.hasNextDouble()) {
                            double salary = sc.nextDouble();
                            emp.setSalary(salary);
                            isValidInput = true;
                        } else {
                            System.out.println("Invalid input! Please enter a valid double for Salary.");
                            sc.next(); // Clear the invalid input
                        }
                    } while (!isValidInput);

                    isValidInput = false;
                    do {
                        System.out.println("Enter Age: ");
                        if (sc.hasNextInt()) {
                            int age = sc.nextInt();
                            emp.setAge(age);
                            isValidInput = true;
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer for Age.");
                            sc.next(); // Clear the invalid input
                        }
                    } while (!isValidInput);

                    object.createEmployee(emp);
                    break;
                case 2:
                    object.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter ID to update the details: ");
                    int empId = sc.nextInt();
                    System.out.println("Enter the new name: ");
                    name = sc.next();
                    object.updateEmployee(empId, name);
                    break;
                case 4:
                    System.out.println("Enter the ID to delete: ");
                    id = sc.nextInt();
                    object.deleteEmployee(id);
                    break;
                case 5:
                    object.clearTable();
                    System.out.println("Table Cleared !");
                    break;
                case 6:
                    System.out.println("Program Exit!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter a valid choice!");
                    break;
            }
        } while (true);
    }
}
