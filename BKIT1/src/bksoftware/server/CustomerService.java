package bksoftware.server;

import bksoftware.model.Customer;

import java.util.List;

public interface CustomerService {
    void show(Customer customer);

    Customer insert(Customer customer);

    boolean delete(Customer customer);

    boolean delete(String id);

    boolean update(String id, Customer customer);

    List<Customer> findAll();

    Customer findByID(String id);


}
