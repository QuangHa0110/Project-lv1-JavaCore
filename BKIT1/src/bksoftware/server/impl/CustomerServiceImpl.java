package bksoftware.server.impl;

import bksoftware.model.Customer;
import bksoftware.repository.CustomerRepository;
import bksoftware.server.CustomerService;
import bksoftware.server.SystemService;
import bksoftware.server.ValidatorService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ValidatorService validatorService = new ValidatorServiceImpl();

    public CustomerServiceImpl() {
        customerRepository = new CustomerRepository();
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = new CustomerRepository();
    }


    @Override
    public void show(Customer customer) {
        System.out.println("Start CustomerServiceImpl show");
        try {
            System.out.println("Thông tin khách hàng");
            showInfo("ID", customer.getId());
            System.out.println("===LOG===");
            showInfo("Name", customer.getName());
            System.out.println("===LOG===");
            showInfo("Email", customer.getEmail());
            System.out.println("===LOG===");
            showInfo("PhoneNumber", customer.getPhoneNumber());
            System.out.println("===LOG===");
            showInfo("Age", String.valueOf(customer.getAge()));
            System.out.println("===LOG===");
            showInfo("Birthdat", String.valueOf(customer.getBirthday()));
            System.out.println("===LOG===");
            System.out.println("End  CustomerServiceImpl show");
        } catch (Exception e) {
            System.out.println("=====Exception CustomerServiceImpl at show with " + e.getMessage());
        }
        System.out.println("===LOG===");

    }

    public void showInfo(String mess, String data) {
        System.out.println(mess + ": " + data);
    }

    @Override
    public Customer insert(Customer customer) {
        Customer rs = null;
        System.out.println("Start CustomerServiceImpl insert ");
        try {
            rs = customerRepository.insert(customer);
            System.out.println("===LOG===");
            System.out.println("End CustomerServiceImpl insert ");
        } catch (Exception e) {
            System.out.println("===Exception CustomerServiceImpl at insert with " + e.getMessage());
        }
        System.out.println("===LOG===");

        return rs;
    }

    @Override
    public boolean delete(Customer customer) {
        System.out.println("Start CustomerServiceImpl delete (customer)");
        boolean rs = false;
        try {
            rs = customerRepository.delete(customer);
            System.out.println("===LOG===");
            System.out.println("End CustomerServiceImpl delete (customer)");
        } catch (Exception e) {
            System.out.println("===Exception CustomerServiceImpl at delete (customer) with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    @Override
    public boolean delete(String id) {
        boolean rs = false;
        System.out.println("Start CustomerServiceImpl delete (id) ");
        try {
            rs = customerRepository.delete(id);
            System.out.println("===LOG===");
            System.out.println("End CustomerServiceImpl delete (id) ");
        } catch (Exception e) {
            System.out.println("===Exception CustomerServiceImpl at delete (id) with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }


    @Override
    public boolean update(String id, Customer customer) {
        boolean rs = false;
        System.out.println("Start CustomerServiceImpl update ");
        try {
            rs = customerRepository.update(id, customer);
            System.out.println("===LOG===");
            System.out.println("End CustomerServiceImpl update ");
        } catch (Exception e) {
            System.out.println("===Exception CustomerServiceImpl at update with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }


    @Override
    public List<Customer> findAll() {
        List<Customer> customers = null;
        System.out.println("Start CustomerServiceImpl findAll");
        try {
            customers = this.customerRepository.findAll();
            System.out.println("===LOG===");
            System.out.println("End CustomerServiceImpl findAll");
        } catch (Exception e) {
            System.out.println("===Exception CustomerServiceImp; at findAll with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return customers;
    }


    @Override
    public Customer findByID(String id) {
        Customer rs = null;
        System.out.println("Start CustomerServiceImpl findByID");
        try {
            rs = customerRepository.findByID(id);
            System.out.println("===LOG===");
            System.out.println("End CustomerServiceImpl findByID");
        } catch (Exception e) {
            System.out.println("===Exception CustomerServiceImpl at findByID with" + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }
}
