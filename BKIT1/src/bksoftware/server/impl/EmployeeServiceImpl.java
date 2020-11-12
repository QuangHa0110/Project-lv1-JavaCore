package bksoftware.server.impl;

import bksoftware.model.Employee;
import bksoftware.server.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void show() {

    }

    @Override
    public Employee insert(Employee customer) {
        return null;
    }

    @Override
    public boolean delete(Employee customer) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Employee customer) {
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findByID(String id) {
        return null;
    }
}
