package SERVICE;

import DAO.ClientIMPL;
import DAO.EmployeeIMPL;
import DTO.Client;
import DTO.Employee;
import INTERFACES.ClientDAO;
import INTERFACES.EmployeeDAO;

import java.sql.SQLException;
import java.util.*;

public class EmployeeService {
    public Optional<Employee> getOneByRegistrationNum(String param) {
        Optional<Employee> Employe = Optional.empty();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Optional<Employee> employee = employedao.getOne(param);
            Employe = Optional.of(employee.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Employe;
    }

    public List<Optional<Employee>> searchByAllAttributs(String param) {
        List<Optional<Employee>> Employes = new ArrayList<>();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            List<Optional<Employee>> employee = employedao.searchByAllAttributs(param);
            Employes = employee;
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Employes;
    }

    public Map<String, Optional<Employee>> getAll() {
        Map<String, Optional<Employee>> client = new HashMap<>();
        try {
            EmployeeDAO employedao = new EmployeeIMPL();
            client = employedao.getAll();
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return client;
    }

    public Optional<Employee> insertEmployee(Employee employes) {
        Optional<Employee> Employe = Optional.empty();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Employe = employedao.insert(employes);
            Employe = Optional.of(Employe.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Employe;
    }

    public Optional<Employee> updateEmployee(Employee employes) {
//        check if Registration Number is exist
        Optional<Employee> Employe = Optional.empty();
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Employe = employedao.update(employes);
            Employe = Optional.of(Employe.get());
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Employe;
    }

    public Boolean deleteEmployee(String Rnum) {
        Boolean Employe = null;
        try {
            EmployeeIMPL employedao = new EmployeeIMPL();
            Employe = employedao.delete(Rnum);
        } catch (Exception e) {
            System.out.println(e + " :Not Found");
        }
        return Employe;
    }
}