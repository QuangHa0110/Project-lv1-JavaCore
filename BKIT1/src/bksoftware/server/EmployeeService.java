package bksoftware.server;

import bksoftware.model.Customer;
import bksoftware.model.Employee;

import java.util.List;

public interface EmployeeService {
    String toker = "TOKEN";

    void show();

    Employee insert(Employee customer);

    boolean delete(Employee customer);

    boolean delete(String id);

    boolean update(Employee customer);

    List<Employee> findAll();

    Employee findByID(String id);
}
