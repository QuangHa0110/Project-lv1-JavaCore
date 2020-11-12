package bksoftware.controller;

import bksoftware.model.Customer;
import bksoftware.server.CustomerService;
import bksoftware.server.ValidatorService;
import bksoftware.server.impl.*;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();
    ValidatorService validatorService = new ValidatorServiceImpl();

    public void show(Customer customer) {
        System.out.println("Start CustomerController show");
        try {
            customerService.show(customer);
            System.out.println("===LOG===");
            System.out.println("End CustomerController show");
        } catch (Exception e) {
            System.out.println("===Exception CustomerController at show with " + e.getMessage());
        }
        System.out.println("===LOG===");
    }

    public Customer insert(Customer customer) {
        Customer rs = null;
        System.out.println("Start CustomerController insert");
        try {
            boolean verify = validatorService.customer(customer);  // check xem customer có hợp lệ không
            System.out.println("===LOG===");
            if (verify) {
                rs = customerService.insert(customer);
                System.out.println("===LOG===");
                System.out.println("End CustomerController insert");
            }
        } catch (Exception e) {
            System.out.println("===Exception CustomerController at insert with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    public boolean delete(Customer customer) {
        boolean rs = false;
        System.out.println("Start CustomerController delete(customer)");
        try {
            boolean verify = validatorService.customer(customer);
            System.out.println("===LOG===");
            if (verify) {
                rs = customerService.delete(customer);
                System.out.println("===LOG===");
                System.out.println("End CustomerController delete (customer) ");
            }

        } catch (Exception e) {
            System.out.println("===Exception CustomerController at delete (customer) with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    public boolean delete(String id) {
        boolean rs = false;
        System.out.println("Start CustomerController delete (id)");
        try {
            if (id != null && !id.isEmpty()) {
                rs = customerService.delete(id);
                System.out.println("===LOG===");
                System.out.println("End CustomerController delete (id)");
            }
        } catch (Exception e) {
            System.out.println("===Exception CustomerController at delete(id) with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    public boolean update(String id, Customer customer) {
        boolean rs = true;
        System.out.println("Start CustomerController update");
        try {
            if (customer != null && (id != null || !id.isEmpty())) {
                rs = customerService.update(id, customer);
                System.out.println("===LOG===");
                System.out.println("End CustomerController update");
            }
        } catch (Exception e) {
            System.out.println("===Exception CustomerController at update with" + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    public List<Customer> findAll() {
        System.out.println("Start CustomerController findAll");
        List<Customer> customers = null;
        try {
            customers = customerService.findAll();
            System.out.println("===LOG===");
            System.out.println("End CustomerController findAll");
        } catch (Exception e) {
            System.out.println("===Exception CustomerController at findAll with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return customers;
    }

    public Customer findByID(String id) {
        System.out.println("Start CustomerController findByID");
        Customer rs = null;
        try {
            if (id != null && !id.isEmpty()) {
                rs = customerService.findByID(id);
                System.out.println("===LOG===");
                System.out.println("End CustomerController findByID");
            }

        } catch (Exception e) {
            System.out.println("===Exception CustomerController at findByID with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;

    }
}
