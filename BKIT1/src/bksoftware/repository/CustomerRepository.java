package bksoftware.repository;

import bksoftware.model.Customer;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BinaryOperator;

public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        try{
            FileWriter fo= new FileWriter("Database.txt");
            fo.write(customers.get(0).getName());
            fo.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<Customer> getCustomers() {

        return customers;
    }


    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }



    /**
     * insert 1 customer mới
     *
     * @param customer
     * @return customer
     */
    public Customer insert(Customer customer) {
        Customer rs = null;
        System.out.println("Start CustomerRepository insert");
        System.out.println("==LOG==");
        try {
            customers.add(customer);
            System.out.println("===LOG===");
            System.out.println("End CustomerRepository insert");
        } catch (Exception e) {
            System.out.println("===Exception CustomerRepository at insert with" + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    public boolean delete(Customer customer) {
        boolean rs = false;
        System.out.println("Start CustomerRepository delete (customer)");
        try {
            rs = customers.remove(customer);
            System.out.println("===LOG===");
            System.out.println("End CustomerRepository delete (customer)");
        } catch (Exception e) {
            System.out.println("===Exception CustomerRepository at delete (customer) with" + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    public boolean delete(String id) {
        boolean rs = false;
        System.out.println("Start CustomerRepository delete (id)");
        try {
            rs= customers.remove(findByID(id));
            System.out.println("===LOG===");
            System.out.println("End CustomerRepository delete (id)");
        } catch (Exception e) {
            System.out.println("===Exception CustomerRepository at delete(id) with" + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }

    public boolean update(String id, Customer customer) {
        boolean rs = false;
        System.out.println("Start CustomerRepository update");
        try {
            int position = customers.indexOf(this.findByID(id));
            customers.set(position, customer);
            rs = true;
            System.out.println("===LOG===");
            System.out.println("End CustomerRepository update");
        } catch (Exception e) {
            System.out.println("===Exception CustomerRepository at update with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;
    }


    public List<Customer> findAll() {
        System.out.println("Start CustomerRepository findAll");
        try {
            System.out.println("End CustomerRepository findAll");
        } catch (Exception e) {
            System.out.println("===Exception CustomerRepository at findAll with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return customers;
    }


    public Customer findByID(String id) {
        Customer rs = null;
        System.out.println("Start CustomerRepository findByID");
        try {
            rs = new Customer();
            for (Customer s : customers) {
                if (s.getId().compareTo(id) == 0) {
                    rs = s;
                    break;
                }
            }
            System.out.println("===LOG===");
            System.out.println("End CustomerRepository findByID");
        } catch (Exception e) {
            System.out.println("===Exception CustomerRepository at findByID with " + e.getMessage());
        }
        System.out.println("===LOG===");
        return rs;

    }







}
