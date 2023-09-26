import DAO.EmployeeIMPL;
import DTO.Client;
import DTO.Employee;
import SERVICE.ClientService;
import SERVICE.EmployeeService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class menu {
    public static void getOneEmploye() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Registration Employee Number :");
        String num = scanner.nextLine();
        EmployeeService personService = new EmployeeService();
        Optional<Employee> getOneEmploye = personService.getOneByRegistrationNum(num);
        Employee Employee = getOneEmploye.get();

        System.out.println("registration Number : " + Employee.getRegistrationNumber());
        System.out.println("Recrutment Date : " + Employee.getRecruitmentDate());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("email : " + Employee.getEmail());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void getAllEmployes() throws SQLException {
        EmployeeIMPL employedao = new EmployeeIMPL();
        List<Optional<Employee>> Employes = employedao.getAll();
        int counter = 1;
        for (Optional<Employee> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("registration Number : " + employeee.get().getRegistrationNumber());
            System.out.println("Recrutment Date : " + employeee.get().getRecruitmentDate());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("email : " + employeee.get().getEmail());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void searchByAllAttributs() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EmployeeIMPL employedao = new EmployeeIMPL();
        System.out.println("Enter any Attribute :");
        String Attribute = scanner.nextLine();
        List<Optional<Employee>> Employes = employedao.searchByAllAttributs(Attribute);
        int counter = 1;
        for (Optional<Employee> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("registration Number : " + employeee.get().getRegistrationNumber());
            System.out.println("Recrutment Date : " + employeee.get().getRecruitmentDate());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("email : " + employeee.get().getEmail());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void insertEmploye() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration Number :");
        String registrationNumber = scanner.nextLine();
        System.out.println("Enter Recrutment Date  :");
        LocalDate RecrutmentDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Enter last name :");
        String lastname = scanner.nextLine();
        System.out.println("Enter Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter email :");
        String email = scanner.nextLine();
        System.out.println("Enter phone number :");
        String phonenumber = scanner.nextLine();


        EmployeeService employeeService = new EmployeeService();
        Employee newEmploye = new Employee(firstname, lastname, DateOfBirth, phonenumber, registrationNumber, RecrutmentDate, email);
        Optional<Employee> Data = employeeService.insertEmployee(newEmploye);
        Employee Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("registration Number : " + Employee.getRegistrationNumber());
        System.out.println("Recrutment Date : " + Employee.getRecruitmentDate());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("email : " + Employee.getEmail());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration Number to Update Employee:");
        String registrationNumber = scanner.nextLine();
        System.out.println("Update Recrutment Date  :");
        LocalDate RecrutmentDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Update first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Update last name :");
        String lastname = scanner.nextLine();
        System.out.println("Update Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Update email :");
        String email = scanner.nextLine();
        System.out.println("Update phone number :");
        String phonenumber = scanner.nextLine();


        EmployeeService employeeService = new EmployeeService();
        Employee newEmploye = new Employee(firstname, lastname, DateOfBirth, phonenumber, registrationNumber, RecrutmentDate, email);
        Optional<Employee> Data = employeeService.updateEmployee(newEmploye);
        Employee Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("registration Number : " + Employee.getRegistrationNumber());
        System.out.println("Recrutment Date : " + Employee.getRecruitmentDate());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("email : " + Employee.getEmail());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void deleteEmploye() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration number for Employe : ");
        String Rnum = scanner.nextLine();
        EmployeeService employeeService = new EmployeeService();
        Boolean isDeleted = employeeService.deleteEmployee(Rnum);
        if (isDeleted) {
            System.out.println("deleted Successfully");
        } else {
            System.out.println("delete Failed");
        }
    }


//    CLIENT SIDE


    public static void getOneClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Client Code :");
        String num = scanner.nextLine();
        ClientService personService = new ClientService();
        Optional<Client> getOneEmploye = personService.getOneByCode(num);
        Client Employee = getOneEmploye.get();

        System.out.println("Code : " + Employee.getCode());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("adress : " + Employee.getAdress());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void getAllClients() throws SQLException {
        ClientService employedao = new ClientService();
        List<Optional<Client>> Employes = employedao.getAll();
        int counter = 1;
        for (Optional<Client> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Code : " + employeee.get().getCode());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("Adress : " + employeee.get().getAdress());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void searchByAttributsClients() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ClientService employedao = new ClientService();
        System.out.println("Enter any Attribute :");
        String Attribute = scanner.nextLine();
        List<Optional<Client>> Employes = employedao.searchByAttributs(Attribute);
        int counter = 1;
        for (Optional<Client> employeee : Employes) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Code : " + employeee.get().getCode());
            System.out.println("first name : " + employeee.get().getFirstName());
            System.out.println("last name : " + employeee.get().getLastName());
            System.out.println("Date Of Birth : " + employeee.get().getDateOfBirth());
            System.out.println("Adress : " + employeee.get().getAdress());
            System.out.println("phone number : " + employeee.get().getPhoneNumber());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public static void insertClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Code :");
        String code = scanner.nextLine();
        System.out.println("Enter first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Enter last name :");
        String lastname = scanner.nextLine();
        System.out.println("Enter Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter Adress :");
        String adress = scanner.nextLine();
        System.out.println("Enter phone number :");
        String phonenumber = scanner.nextLine();


        ClientService employeeService = new ClientService();
        Client newEmploye = new Client(firstname, lastname, DateOfBirth, phonenumber, code, adress);
        Optional<Client> Data = employeeService.insertClient(newEmploye);
        Client Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("Code : " + Employee.getCode());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("adress : " + Employee.getAdress());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void updateClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Code to Update Client:");
        String code = scanner.nextLine();
        System.out.println("Update first name  :");
        String firstname = scanner.nextLine();
        System.out.println("Update last name :");
        String lastname = scanner.nextLine();
        System.out.println("Update Date Of Birth :");
        LocalDate DateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Update Adress :");
        String Adress = scanner.nextLine();
        System.out.println("Update phone number :");
        String phonenumber = scanner.nextLine();


        ClientService employeeService = new ClientService();
        Client newEmploye = new Client(firstname, lastname, DateOfBirth, phonenumber, code, Adress);
        Optional<Client> Data = employeeService.updateClient(newEmploye);
        Client Employee = Data.get();

        System.out.println("\nThe New Employe :");
        System.out.println("Code : " + Employee.getCode());
        System.out.println("first name : " + Employee.getFirstName());
        System.out.println("last name : " + Employee.getLastName());
        System.out.println("Date Of Birth : " + Employee.getDateOfBirth());
        System.out.println("adress : " + Employee.getAdress());
        System.out.println("phone number : " + Employee.getPhoneNumber());
        System.out.println("---------------------------------------");
    }

    public static void deleteClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter registration number for Employe : ");
        String Rnum = scanner.nextLine();
        ClientService ClientService = new ClientService();
        Boolean isDeleted = ClientService.deleteClient(Rnum);
        if (isDeleted) {
            System.out.println("deleted Successfully");
        } else {
            System.out.println("delete Failed");
        }
    }
}
